package tests;

import helpers.ConfigLoader;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public abstract class BaseTest {
    @BeforeSuite
    public void setup() {
        String token = ConfigLoader.getToken();
        String baseUrl = ConfigLoader.getBaseUrl();
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri(baseUrl)
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", "Bearer " + token.trim())
                .build();
    }
    protected ResponseSpecification getSuccessSpec() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }
    protected ResponseSpecification badRequestSpec() {
        return new ResponseSpecBuilder()
                .expectStatusCode(400)
                .build();
    }
}
