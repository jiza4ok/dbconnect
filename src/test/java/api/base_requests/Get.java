package api.base_requests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.data.ProjectData;
import utils.api.ValidateResponseWaiter;

import static io.restassured.RestAssured.given;

public class Get {
    public Response withoutAuth(int responseCode, String endpoint) {
        RestAssured.baseURI = ProjectData.value("base_url");
        ValidateResponseWaiter responseWaiter = () -> {
            return given()
                    .relaxedHTTPSValidation()
                    .header("Content-Type", "application/json")
                    .header("Accept", "application/json")
                    .when()
                    .get(endpoint)
                    .then()
                    .statusCode(responseCode);
        };
        return WaitResponse.validate(responseWaiter, responseCode);
    }
}
