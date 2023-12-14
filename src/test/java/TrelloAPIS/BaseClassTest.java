package TrelloAPIS;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.given;

public class BaseClassTest {

    protected static final String API_KEY = "9a0901958b8f1cedffe36f808e2b6d47";
    protected static final String TOKEN = "ATTA6789644ec2a9cf36bd5e451ea910fb620fe24ed333648284ea5d7d1f1e926d19F93BCA6A";
    protected static String boardId;

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "https://api.trello.com/1";
    }

    protected static RequestSpecification getDefaultRequestSpec() {
        return given()
                .queryParam("key", API_KEY)
                .queryParam("token", TOKEN)
                .contentType(ContentType.JSON);
    }
}
