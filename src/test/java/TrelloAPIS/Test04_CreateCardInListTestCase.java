package TrelloAPIS;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class Test04_CreateCardInListTestCase extends Test03_AddListToBoardTestCase {

    protected static String cardId;

    @Test(dependsOnMethods = "testAddListToBoard")
    public void testCreateCardInList() {
        Response response = getDefaultRequestSpec()
                .queryParam("name", "TestCard")
                .queryParam("idList", listId)
                .when()
                .post("/cards")
                .then()
                .statusCode(200)
                .body("name", equalTo("TestCard"))
                .extract().response();

        cardId = response.path("id");
        System.out.println("Created Card ID: " + cardId);
    }
}
