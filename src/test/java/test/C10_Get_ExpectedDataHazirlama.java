package test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C10_Get_ExpectedDataHazirlama {
     /* https://jsonplaceholder.typicode.com/posts/22 url'ine
           bir GET request yolladigimizda donen response body'sinin
              asagida verilen ile ayni oldugunu test ediniz
                        Response body :
                         {
                 "userId":3,
                  "id":22,
                    "title":"dolor sint quo a velit explicabo quia nam",
                    "body":"eos qui et ipsum ipsam suscipit aut\nsed omnis non odio
                    \nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse"
                            }               */
    @Test
    public void getExp(){
        // 1- Endpoint hazırlama
               String url ="https://jsonplaceholder.typicode.com/posts/22";
        // 2- Expected body hazırlama
        JSONObject expBody = new JSONObject();
        expBody.put("userId",3);
        expBody.put("id",22);
        expBody.put("title","dolor sint quo a velit explicabo quia nam");
        expBody.put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");

       // System.out.println("ExpBody:" +expBody);
        // 3- Response kaydetmek
        Response response = given().when().get(url);

        // 4- Assertion işlemi
        JsonPath respJP = response.jsonPath();//dönen cevabın içindeki verileri inceleyebilmek için
                                             // bir JSONPath objesi içine dönen cevabı yerleştirdik
        Assert.assertEquals(expBody.get("userId"), respJP.get("userId"));
        Assert.assertEquals(expBody.get("id"), respJP.get("id"));
        Assert.assertEquals(expBody.get("title"), respJP.get("title"));
        Assert.assertEquals(expBody.get("body"), respJP.get("body"));

    }
}
