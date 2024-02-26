package patvari.ali.restbackend.utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import patvari.ali.restbackend.pojo.LoginRequest;
import patvari.ali.restbackend.pojo.TokenResponse;

import static io.restassured.RestAssured.given;

public class TokenService {
    public String getJWTToken(String login, String password) {
        LoginRequest loginRequest = new LoginRequest(login, password);

        Response response = given()
                .contentType(ContentType.JSON)
                .body(loginRequest)
                .when()
                .post(ConfigurationReader.getProperty("baseURI")+"/api/login")
                .then().log().all()
                .extract()
                .response();

        TokenResponse tokenResponse = response.as(TokenResponse.class);
        return tokenResponse.getToken();
    }
}
