package trelloTests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import utils.SetUp;
import utils.Data;
import utils.Utils;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class E2E {

    @BeforeClass
    public void setUp() {

        //Create Board
        Response boardresponse =
                SetUp.createBoard(Data.boardName);
        boardresponse.then().
                assertThat().
                statusCode(200).
                body("name", equalTo(Data.boardName));
        Data.board_id = boardresponse.path("id");


        //Create List
        Response listresponse =
                SetUp.createList(Data.listName);
        listresponse.then().
                assertThat().
                statusCode(200).
                body("name", equalTo(Data.listName)).
                body("idBoard", equalTo(Data.board_id));
        Data.list_id = listresponse.path("id");


        //Create Card
        Response cardresponse =
                SetUp.createCard();
        cardresponse.then().
                assertThat().
                statusCode(200).
                body("idList", equalTo(Data.list_id));
        Data.card_id = cardresponse.path("id");
    }

    @Test(priority = 1)
    public void getBoard() {
        Response response =
                given().
                        baseUri(Utils.boardsUrl).
                        queryParam("key", Utils.key).
                        queryParam("token", Utils.token).
                        when().
                        contentType(ContentType.JSON).
                        get("/" + Data.board_id);
        response.then().
                assertThat().
                statusCode(200).
                body("id", equalTo(Data.board_id)).
                body("name", equalTo(Data.boardName));
    }

    @Test(priority = 2)
    public void updateBoard() {
        Response response =
                given().
                        baseUri(Utils.boardsUrl).
                        queryParam("key", Utils.key).
                        queryParam("token", Utils.token).
                        queryParam("name", Data.updatedBoardName).
                        when().
                        contentType(ContentType.JSON).
                        put("/" + Data.board_id);
        response.then().
                assertThat().
                statusCode(200).
                body("name", equalTo(Data.updatedBoardName)).
                body("id", equalTo(Data.board_id));
    }

    @Test(priority = 2)
    public void updateList() {
        Response response =
                given().
                        baseUri(Utils.listsUrl).
                        queryParam("key", Utils.key).
                        queryParam("token", Utils.token).
                        queryParam("name", Data.updatedListName).
                        when().
                        contentType(ContentType.JSON).
                        put("/" + Data.list_id);
        response.then().
                assertThat().
                statusCode(200).
                body("id", equalTo(Data.list_id)).
                body("name", equalTo(Data.updatedListName));
    }

    @Test(priority = 3)
    public void updateCard() {
        Response response =
                given().
                        baseUri(Utils.cardsUrl).
                        queryParam("key", Utils.key).
                        queryParam("token", Utils.token).
                        queryParam("name", Data.cardName).
                        when().
                        contentType(ContentType.JSON).
                        put("/" + Data.card_id);
        response.then().
                assertThat().
                statusCode(200).
                body("id", equalTo(Data.card_id));
    }

    @Test(priority = 4)
    public void getList() {
        Response response =
                given().
                        baseUri(Utils.listsUrl).
                        queryParam("key", Utils.key).
                        queryParam("token", Utils.token).
                        when().
                        contentType(ContentType.JSON).
                        get("/" + Data.list_id);
        response.then().
                assertThat().
                statusCode(200).
                body("id", equalTo(Data.list_id)).
                body("name", equalTo(Data.updatedListName));
    }

    @Test(priority = 5)
    public void getCard() {
        Response response =
                given().
                        baseUri(Utils.cardsUrl).
                        queryParam("key", Utils.key).
                        queryParam("token", Utils.token).
                        when().
                        contentType(ContentType.JSON).
                        get("/" + Data.card_id);
        response.then().
                assertThat().
                statusCode(200).
                body("id", equalTo(Data.card_id));
    }

    @Test(priority = 6)
    public void createChecklist() {
        Response response =
                given().
                        baseUri(Utils.checklistsUrl).
                        queryParam("key", Utils.key).
                        queryParam("token", Utils.token).
                        queryParam("idCard", Data.card_id).
                        queryParam("name", Data.checklistName).
                when().
                        contentType(ContentType.JSON).
                        post();
        response.then().
                assertThat().
                statusCode(200).
                body("idCard", equalTo(Data.card_id));
        Data.checklist_id = response.path("id");
    }

    @Test(dependsOnMethods = "createChecklist", priority = 6)
    public void updateChecklist() {
        Response response =
                given().
                        baseUri(Utils.checklistsUrl).
                        queryParam("key", Utils.key).
                        queryParam("token", Utils.token).
                        queryParam("name", Data.updatedChecklistName).
                        when().
                        contentType(ContentType.JSON).
                        put("/" + Data.checklist_id);
        response.then().
                assertThat().
                statusCode(200).
                body("id", equalTo(Data.checklist_id)).
                body("name", equalTo(Data.updatedChecklistName));
    }

    @Test(priority = 7)
    public void getChecklist() {
        Response response =
                given().
                        baseUri(Utils.checklistsUrl).
                        queryParam("key", Utils.key).
                        queryParam("token", Utils.token).
                        when().
                        contentType(ContentType.JSON).
                        get("/" + Data.checklist_id);
        response.then().
                assertThat().
                statusCode(200).
                body("id", equalTo(Data.checklist_id));
    }


    @AfterClass
    public void tearDownSetUp() {

        //Delete Checklist
        Response checklistres = SetUp.deleteChecklist(Data.checklist_id);
        checklistres.then().
                assertThat().
                statusCode(200);

        //Delete Card
        Response cardresponse = SetUp.deleteCard(Data.card_id);
        cardresponse.then().
                assertThat().
                statusCode(200);

        //Delete Board
        Response boardresponse = SetUp.deleteBoard(Data.board_id);
        boardresponse.then().
                assertThat().
                statusCode(200).
                body("_value", equalTo(null));
    }

}
