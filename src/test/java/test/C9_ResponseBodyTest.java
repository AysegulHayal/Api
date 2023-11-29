package test;

import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C9_ResponseBodyTest {
    /*   http://dummy.restapiexample.com/api/v1/employees url'ine bir GET request yolladigimizda
        donen Response'in
          status code'unun 200,
             content type'inin application/json,
              response body'sindeki
                 employees sayisinin 24
                    ve employee'lerden birinin "Ashton Cox"
                          ve girilen yaslar icinde 61,40 ve 30 degerlerinin oldugunu test edin    */
      @Test
    public void get01(){
          // 1- endpoint hazırlama
          String url = "http://dummy.restapiexample.com/api/v1/employees";
          // 2- Expected body verilmediği için hazırlanmadı
          // 3- Response kaydetme
          Response response = given().when().get(url);
          //response.prettyPrint();
          //4- Assertion yapma
          response.then().assertThat()
                                .statusCode(200)
                                 .contentType("application/json")
                      .body("data.id", Matchers.hasSize(24),"data.employee_name",
                              Matchers.hasItem("Ashton Cox"),"data.employee_age", Matchers.hasItems(61,30,40));


      }






}
