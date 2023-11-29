package test;


import baseUrl.WWBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class WorldWonder extends WWBaseUrl {

    @Test
    public void worldwonder () {
        specWW.pathParams("pp1",
                "/api",
                "pp2",
                "visitorsPurposeList");
        String token = "bjMZF3yRHoUxjAVr0ZdDBK8tOHtxNR";
        Response response = given().spec(specWW).header("authorization", "Bearer" + token)
                .when().get("/{pp1}/{pp2}");

        response.then().statusCode(200).body("message",equalTo("Success"));

    }


}
