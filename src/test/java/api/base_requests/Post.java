package api.base_requests;

import utils.data.ProjectData;
import utils.api.ValidateResponseWaiter;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class Post {

    public Response withoutAuth(int responseCode, String endpoint, String body) {
        RestAssured.baseURI = ProjectData.value("base_url");
        ValidateResponseWaiter responseWaiter = () -> {
            return given()
                    .relaxedHTTPSValidation()
                    .header("Content-Type", "application/json")
                    .header("Accept", "application/json")
                    .body(body)
                    .when()
                    .post(endpoint)
                    .then()
                    .statusCode(responseCode);
        };
        return WaitResponse.validate(responseWaiter, responseCode);
    }

    public Response withToken(String token, int responseCode, String endpoint, String body) {
        ValidateResponseWaiter responseWaiter = () -> {
            RestAssured.baseURI = ProjectData.value("base_url");
            return given()
                    .relaxedHTTPSValidation()
                    .auth().oauth2(token)
                    .header("Content-Type", "application/json")
                    .header("Accept", "application/json")
                    .body(body)
                    .when()
                    .get(endpoint)
                    .then()
                    .statusCode(responseCode);
        };
        return WaitResponse.validate(responseWaiter, responseCode);
    }
}
