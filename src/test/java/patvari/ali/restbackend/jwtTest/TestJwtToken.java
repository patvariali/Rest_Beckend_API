package patvari.ali.restbackend.jwtTest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import patvari.ali.restbackend.utilities.ConfigurationReader;
import patvari.ali.restbackend.utilities.TokenService;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class TestJwtToken {
    private static TokenService token;

    @BeforeAll
    public static void setup() {
        baseURI = ConfigurationReader.getProperty("baseURI");
        token = new TokenService();
    }

    @Test
    public void testRequestWithJwtToken() {
        String jwtToken = token.getJWTToken(
                ConfigurationReader.getProperty("username"),
                ConfigurationReader.getProperty("password")
        );

        given()
                .auth().oauth2(jwtToken)
                .get("/api/user")
                .then().log().all()
                .statusCode(200);
    }


}
