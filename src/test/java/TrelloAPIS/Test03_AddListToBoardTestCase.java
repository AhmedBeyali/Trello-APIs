package TrelloAPIS;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class Test03_AddListToBoardTestCase extends BaseClassTest {

    protected static String listId;

    @Test(dependsOnMethods = "testCreateBoard")
    public void testAddListToBoard() {
        Response response = getDefaultRequestSpec()
                .queryParam("name", "TestList")
                .queryParam("idBoard", boardId)
                .when()
                .post("/lists")
                .then()
                .statusCode(200)
                .body("name", equalTo("TestList"))
                .extract().response();

        listId = response.path("id");
        System.out.println("Added List ID: " + listId);
    }
}
