package TrelloAPIS;

import org.testng.annotations.Test;

public class Test08_DeleteBoardTest extends Test07_DeleteListTestCase {

    @Test(dependsOnMethods = "testDeleteList")
    public void testDeleteBoard() {
        getDefaultRequestSpec()
                .when()
                .delete("/boards/{boardId}", boardId)
                .then()
                .statusCode(200);
    }
}
