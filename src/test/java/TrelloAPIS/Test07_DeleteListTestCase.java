package TrelloAPIS;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class Test07_DeleteListTestCase extends Test06_DeleteCardTestCase {

    @Test(dependsOnMethods = "testDeleteCard")
    public void testDeleteList() {
        // Retrieve list details before deletion
        Response response = getDefaultRequestSpec()
                .when()
                .get("/lists/{listId}", listId)
                .then()
                .extract()
                .response();

        // Log the response details
        System.out.println("List details before deletion: " + response.asString());

        // Delete the list
        getDefaultRequestSpec()
                .when()
                .delete("/lists/{listId}", listId)
                .then()
                .statusCode(404);

        System.out.println("List deleted successfully.");
    }
}
