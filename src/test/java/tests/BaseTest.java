package tests;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public abstract class BaseTest {
    @BeforeSuite
    @Parameters({"permanentToken", "baseUrl"})
    public void setup(String token, String baseUrl) {
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri(baseUrl)
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", "Bearer " + token)
                .build();
    }
}
