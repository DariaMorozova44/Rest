package api;

import dto.ReportDto;
import endpoints.Endpoints;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ReportApi {


    public Response createReport(ReportDto reportDto) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .log().all()
                .body(reportDto)
                .post(Endpoints.CREATE_REPORTS)
                .then()
                .extract().response();
    }

}
