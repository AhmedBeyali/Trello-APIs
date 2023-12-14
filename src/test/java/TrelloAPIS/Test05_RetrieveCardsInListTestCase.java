package TrelloAPIS;

import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class Test05_RetrieveCardsInListTestCase extends Test04_CreateCardInListTestCase {

    @Test(dependsOnMethods = "testCreateCardInList")
    public void testRetrieveCardsInList() {
        getDefaultRequestSpec()
                .when()
                .get("/lists/{listId}/cards", listId)
                .then()
                .statusCode(200)
                .body("id", hasItem(cardId))
                .body("name", hasItem("TestCard"));
    }
}

