package test;

import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C7_TekrarlardanKurtulma {
    /* https://restful-booker.herokuapp.com/booking/10 url'ine bir GET request gonderdigimizde donen Response'un,
        status code'unun 200,
        ve content type'inin application-json, ve response body'sindeki
        "firstname"in, "Susan",
        ve "lastname"in, "Jackson",
        ve "totalprice"in, 612,
        ve "depositpaid"in, false,
     ve "additionalneeds"in, "Breakfast" oldugunu test edin   */
    @Test
    public void nonRepeat(){
        // 1- Endpoint hazırlama
        String url = "https://restful-booker.herokuapp.com/booking/10";
        // 2- Expected Body verilmedigi icin hazırlanmadı
        // 3- Response kaydet
        Response response = given().when().get("https://restful-booker.herokuapp.com/booking/10");
        // 4- Assertion yap
        response.then().assertThat().statusCode(200).contentType("application-json")
                .body("firstname",equalTo("Susan"),
                        "lastname",equalTo("Jackson"),
                        "totalprice",equalTo(612),
                        "depositpaid",equalTo(false),
                        "additionalneeds",equalTo("Breakfast"));


    }
}
