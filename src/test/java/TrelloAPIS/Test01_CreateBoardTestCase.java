package TrelloAPIS;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class Test01_CreateBoardTestCase extends BaseClassTest {

    @Test
    public void testCreateBoard() {
        Response response = getDefaultRequestSpec()
                .queryParam("name", "iti")
                .when()
                .post("/boards")
                .then()
                .statusCode(200)
                .body("name", equalTo("iti"))
                .extract().response();

        boardId = response.path("id");
        System.out.println("Created Board ID: " + boardId);
    }
}
