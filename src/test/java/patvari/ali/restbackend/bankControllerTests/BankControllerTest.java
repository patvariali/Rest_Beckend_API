package patvari.ali.restbackend.bankControllerTests;


import org.junit.jupiter.api.Test;
import patvari.ali.restbackend.pojo.UserPOJO;
import patvari.ali.restbackend.specifications.BCSpecifications;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankControllerTest {


    @Test
    void bankControllerTest() {
        List<UserPOJO> users = BCSpecifications.requestSpecification
                .get("getAll")
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath().getList("", UserPOJO.class);

        users.forEach(x -> assertEquals(x.getFirstName(), x.getLastName()));


    }
}
