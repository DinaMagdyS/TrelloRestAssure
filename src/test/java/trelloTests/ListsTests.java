package trelloTests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utils.Utils;
import utils.Data;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ListsTests extends BaseTest {

    @Test (priority = 1)
    public void createList(){
        Response response =
           given().
                   queryParam("key", Utils.key).
                   queryParam("token", Utils.token).
                   queryParam("idBoard",Data.board_id).
                   queryParam("name",Data.listName).
           when().
                   contentType(ContentType.JSON).
                   post(Utils.listsUrl);
           response.then().
                   assertThat().
                   statusCode(200).
                   body("name",equalTo(Data.listName)).
                   body("idBoard",equalTo(Data.board_id));
        Data.list_id = response.path("id");
    }

    @Test (dependsOnMethods = "createList",priority = 1)
    public void updateList(){
        Response response =
            given().
                   baseUri(Utils.listsUrl).
                   queryParam("key", Utils.key).
                   queryParam("token", Utils.token).
                   queryParam("name", Data.updatedListName).
            when().
                   contentType(ContentType.JSON).
                   put("/"+Data.list_id);
            response.then().
                   assertThat().
                   statusCode(200).
                   body("id",equalTo(Data.list_id)).
                   body("name",equalTo(Data.updatedListName));
    }

    @Test(dependsOnMethods = "createList", priority = 2)
    public void getList(){
        Response response =
            given().
                    baseUri(Utils.listsUrl).
                    queryParam("key", Utils.key).
                    queryParam("token", Utils.token).
            when().
                    contentType(ContentType.JSON).
                    get("/"+Data.list_id);
        response.then().
                    assertThat().
                    statusCode(200).
                    body("id",equalTo(Data.list_id)).
                    body("name",equalTo(Data.updatedListName));
    }

    @Test(dependsOnMethods = "createList",priority = 3)
    public void archiveList(){
        Response response =
                given().
                        baseUri(Utils.listsUrl).
                        queryParam("key", Utils.key).
                        queryParam("token", Utils.token).
                        queryParam("value",true).
                when().
                        contentType(ContentType.JSON).
                        put("/"+Data.list_id+"/closed");
        response.then().
                assertThat().
                statusCode(200).
                body("id",equalTo(Data.list_id)).
                body("closed",equalTo(true));
    }
}
