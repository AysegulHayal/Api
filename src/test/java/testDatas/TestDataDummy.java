package testDatas;

import org.json.JSONObject;

import java.util.HashMap;

public class TestDataDummy {
        public int okStatusKodu = 200;
        public String contentType = "application/json";
        public JSONObject reqBodyOlusturJSON() {

            JSONObject data = new JSONObject();
            data.put("id",3);
            data.put( "employee_name","Ashton Cox");
            data.put("employee_salary",86000);
            data.put("employee_age",66);
            data.put("profile_image","");

            JSONObject reqBody = new JSONObject();
            reqBody.put("status","success");
            reqBody.put("data",data);
            reqBody.put("message","Successfully! Record has been fetched.");


            return reqBody;
        }
        public HashMap dataOlusturMap() {
            HashMap<String, Object> data = new HashMap<>();
            data.put("id", 3.0);
            data.put("employee_name", "Ashton Cox");
            data.put("employee_salary", 86000.0);
            data.put("employee_age", 66.0);
            data.put("profile_image", "");

            return data;
        }
        public HashMap expectedBodyOlusturMap(){
            HashMap<String,Object> expData = new HashMap<>();
            expData.put("status","success");
            expData.put("data",dataOlusturMap());
            expData.put("message","Successfully! Record has been fetched.");

            return expData;
        }
}

