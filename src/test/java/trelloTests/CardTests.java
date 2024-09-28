package trelloTests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utils.Utils;
import utils.Data;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CardTests extends BaseTest{
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

    @Test(dependsOnMethods = "createList", priority = 1)
    public void createCard(){
        Response response =
                given().
                        baseUri(Utils.cardsUrl).
                        queryParam("key", Utils.key).
                        queryParam("token", Utils.token).
                        queryParam("idList",Data.list_id).
                when().
                        contentType(ContentType.JSON).
                        post();
        response.then().
                assertThat().
                statusCode(200).
                body("idList",equalTo(Data.list_id));
        Data.card_id = response.path("id");
    }

    @Test(dependsOnMethods = "createCard", priority = 1)
    public void updateCard(){
        Response response =
                given().
                        baseUri(Utils.cardsUrl).
                        queryParam("key", Utils.key).
                        queryParam("token", Utils.token).
                        queryParam("name", Data.cardName).
                when().
                        contentType(ContentType.JSON).
                        put("/"+ Data.card_id);
        response.then().
                assertThat().
                statusCode(200).
                body("id",equalTo(Data.card_id));
    }

    @Test(dependsOnMethods = "createCard", priority = 2)
    public void getCard(){
        Response response =
                given().
                        baseUri(Utils.cardsUrl).
                        queryParam("key", Utils.key).
                        queryParam("token", Utils.token).
                when().
                        contentType(ContentType.JSON).
                        get("/"+ Data.card_id);
        response.then().
                assertThat().
                statusCode(200).
                body("id",equalTo(Data.card_id));
    }


    @Test(priority = 3)
    public void deleteCard() {
        Response response =
                given().
                        baseUri(Utils.cardsUrl).
                        queryParam("key", Utils.key).
                        queryParam("token", Utils.token).
                when().
                        contentType(ContentType.JSON).
                        delete("/"+ Data.card_id);
        response.then().
                assertThat().
                statusCode(200);
    }
}








