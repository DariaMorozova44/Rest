package api;

import dto.ReportDto;
import helpers.ConfigLoader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;

public class ReportApi {


    public Response createReport(ReportDto reportDto) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .log().all()
                .body(reportDto)
                .post(ConfigLoader.getReportUrl())
                .then()
                .log().all()
                .extract().response();
    }

}
