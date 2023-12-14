package TrelloAPIS;

import org.testng.annotations.Test;

public class Test06_DeleteCardTestCase extends Test05_RetrieveCardsInListTestCase {

    @Test(dependsOnMethods = "testRetrieveCardsInList")
    public void testDeleteCard() {
        // Update card information (if needed)
        getDefaultRequestSpec()
                .queryParam("desc", "UpdatedDescription")
                .when()
                .put("/cards/{cardId}", cardId)
                .then()
                .statusCode(200);

        // Delete the card
        getDefaultRequestSpec()
                .when()
                .delete("/cards/{cardId}", cardId)
                .then()
                .statusCode(200);
    }
}

