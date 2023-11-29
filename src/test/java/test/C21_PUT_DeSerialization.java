package test;

import baseUrl.jsonPlaceBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testDatas.TestDataJSONPlace;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class C21_PUT_DeSerialization extends jsonPlaceBaseUrl {
    /* https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki
body'e sahip bir PUT request yolladigimizda donen response'in
response body'sinin asagida verilen ile ayni oldugunu test ediniz

Request Body
    {
    "title":"Ahmet",
    "body":"Merhaba",
    "userId":10,
    "id":70
    }

Expected Data :
  {
    "title":"Ahmet",
    "body":"Merhaba",
    "userId":10,
    "id":70
    }                 */
    @Test
    public void put01(){
        specJsonPlace.pathParams("pp1","posts","pp2",70);
        TestDataJSONPlace testDataJSONPlace = new TestDataJSONPlace();
        HashMap<String,Object> reqBody = testDataJSONPlace.requestBodyOlusturMap();
        HashMap<String,Object> expData = testDataJSONPlace.requestBodyOlusturMap();
        Response response = given()
                                 .spec(specJsonPlace).contentType(ContentType.JSON)
                                .when()
                                  .body(reqBody).put("/{pp1}/{pp2}");// toString yok java tanıyor
        //ASSERTION ISLEMI
        HashMap<String,Object> respMAP = response.as(HashMap.class);
        Assert.assertEquals(expData.get("title"),respMAP.get("title"));
        Assert.assertEquals(expData.get("body"),respMAP.get("body"));
        Assert.assertEquals(expData.get("userId"),respMAP.get("userId"));
        Assert.assertEquals(expData.get("id"),respMAP.get("id"));


    }


}
