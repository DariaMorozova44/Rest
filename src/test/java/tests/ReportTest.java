package tests;

import dto.ReportDto;
import helpers.CsvDataProviderReport;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ReportTest extends BaseTest {
    @Test(dataProvider = "data", dataProviderClass = CsvDataProviderReport.class)

    public void testCreateReport(String name, String typeDiscriminator) {

        ReportDto newReport = new ReportDto();
        newReport.setName(name);
        newReport.setTypeDiscriminator(typeDiscriminator);
        Response response = given()
                .body(newReport)
                .when()
                .post("http://localhost:8082/api/reports")
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();


                assertThat(response.jsonPath().getString("$type"), equalTo("IssuePerProjectReport"));

    }
}

