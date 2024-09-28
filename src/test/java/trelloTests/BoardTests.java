package trelloTests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utils.Utils;
import utils.Data;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class BoardTests extends BaseTest {

    @Test(priority = 1)
    public void getBoard(){

        Response response =
                given().
                            baseUri(Utils.boardsUrl).
                            queryParam("key", Utils.key).
                            queryParam("token", Utils.token).
                when().
                            contentType(ContentType.JSON).
                            get("/"+ Data.board_id);
                response.then().
                            assertThat().
                            statusCode(200).
                            body("id",equalTo(Data.board_id)).
                            body("name",equalTo(Data.boardName));

    }

    @Test(priority = 2)
    public void updateBoard(){
        Response response =
                given().
                        baseUri(Utils.boardsUrl).
                        queryParam("key", Utils.key).
                        queryParam("token", Utils.token).
                        queryParam("name", Data.updatedBoardName).
                when().
                        contentType(ContentType.JSON).
                        put("/"+Data.board_id);

        response.prettyPrint();

                response.then().
                        assertThat().
                        statusCode(200).
                        body("name",equalTo(Data.updatedBoardName)).
                        body("id",equalTo(Data.board_id));
    }
}