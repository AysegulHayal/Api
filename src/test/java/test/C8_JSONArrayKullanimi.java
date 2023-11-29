package test;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class C8_JSONArrayKullanimi {
     /*  {   "firstName": "John",  "lastName": "doe",  "age": 26,  "address":
         {   "streetAddress": "naist street", "city": "Nara",  "postalCode": "630-0192" },
              "phoneNumbers": [ { "type": "iPhone", "number": "0123-4567-8888"},{"type": "home",
                                       "number": "0123-4567-8910" } ] } */
    @Test
    public void jSonArray(){
        JSONObject ceptel = new JSONObject();
        ceptel.put("type", "iPhone");
        ceptel.put("number","0123-4567-8888");

        JSONObject evtel = new JSONObject();
        evtel.put("type","home");
        evtel.put("number","0123-4567-8910");

                     JSONArray phoneNumbers = new JSONArray();
                        phoneNumbers.put(0,ceptel);
                           phoneNumbers.put(1,evtel);

        JSONObject adres = new JSONObject();
        adres.put("streetAddress","naist street");
        adres.put("city","Nara");
        adres.put("postalCode","630-0192");

        JSONObject personalInfo = new JSONObject();
        personalInfo.put("firstName","John");
        personalInfo.put("lastName","doe");
        personalInfo.put("age",26);
        personalInfo.put("address",adres);
        personalInfo.put("phoneNumbers",phoneNumbers);

        System.out.println("personalInfo = " + personalInfo);
        System.out.println("Kişi adı:"+ personalInfo.get("firstName"));
        System.out.println("Kişi soyadı:"+ personalInfo.get("lastName"));
        System.out.println("Kişi yaşı:"+ personalInfo.get("age"));

        System.out.println("Kişi adres-sokak: "+ personalInfo.getJSONObject("address").get("streetAddress"));
        System.out.println("Kişi adres-şehir: "+ personalInfo.getJSONObject("address").get("city"));
        System.out.println("Kişi adres-posta kodu: "+ personalInfo.getJSONObject("address").get("postalCode"));

        System.out.println("Kişi telefon 1 tür: " + personalInfo.getJSONArray("phoneNumbers")
                                                 .getJSONObject(0).get("type"));
        System.out.println("Kişi telefon 1 number: " + personalInfo.getJSONArray("phoneNumbers")
                                                 .getJSONObject(0).get("number"));

        System.out.println("Kişi telefon 2 tür: " + personalInfo.getJSONArray("phoneNumbers")
                                                  .getJSONObject(1).get("type"));
        System.out.println("Kişi telefon 2 number: " + personalInfo.getJSONArray("phoneNumbers")
                                                  .getJSONObject(1).get("number"));




    }






}
