package baseUrl;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class WWBaseUrl {
    protected RequestSpecification specWW;

    @Before

    public void setUp(){
        specWW=new RequestSpecBuilder().setBaseUri("https://qa.wonderworldcollege.com").build();
    }
}
