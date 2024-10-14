package utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class SetUp {
    public static Response createBoard(String boardName){
        return given().
                queryParam("key", Utils.key).
                queryParam("token", Utils.token).
                queryParam("name",boardName).
        when().
                contentType(ContentType.JSON).
                post(Utils.boardsUrl);
    }

    public static Response createList(String listName){

       return given().
                 queryParam("key", Utils.key).
                 queryParam("token", Utils.token).
                 queryParam("idBoard", Data.board_id).
                 queryParam("name",listName).
              when().
                 contentType(ContentType.JSON).
                 post(Utils.listsUrl);
    }

    public static Response createCard(){

        return given().
                baseUri(Utils.cardsUrl).
                queryParam("key", Utils.key).
                queryParam("token", Utils.token).
                queryParam("idList", Data.list_id).
        when().
                contentType(ContentType.JSON).
                post();
    }


    public static Response deleteBoard(String boardID)
    {
    return given().
                baseUri(Utils.boardsUrl).
                queryParam("key", Utils.key).
                queryParam("token", Utils.token).
             when().
                contentType(ContentType.JSON).
                delete(boardID);
    }

    public static Response deleteChecklist(String checklistID)
    {
    return given().
                baseUri(Utils.checklistsUrl).
                queryParam("key", Utils.key).
                queryParam("token", Utils.token).
            when().
                contentType(ContentType.JSON).
                delete("/"+ checklistID);
    }

    public static Response deleteCard(String cardID)
    {
    return given().
              baseUri(Utils.cardsUrl).
              queryParam("key", Utils.key).
              queryParam("token", Utils.token).
           when().
              contentType(ContentType.JSON).
              delete("/"+ cardID);
    }

}

