package patvari.ali.restbackend.specifications;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.with;

public class BCSpecifications {
    public static RequestSpecification requestSpecification = with()
            .baseUri("http://localhost:8080/")
            .basePath("user/")
            .contentType(ContentType.JSON);
}
