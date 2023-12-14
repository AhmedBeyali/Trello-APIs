package TrelloAPIS;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class Test02_RetrieveBoardTestCase extends Test01_CreateBoardTestCase {

    @Test(dependsOnMethods = "testCreateBoard")
    public void testRetrieveBoard() {
        getDefaultRequestSpec()
                .when()
                .get("/boards/{boardId}",boardId)
                .then()
                .statusCode(200)
                .body("id", equalTo(boardId))
                .body("name", equalTo("iti"));
    }
}
