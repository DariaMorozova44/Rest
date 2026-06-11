package api;

import dto.PanelDto;
import endpoints.Endpoints;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import specification.Specifications;

public class PanelApi {



    public Response createPanel(PanelDto panelDto) {
        return RestAssured.given()
                .body(panelDto)
                .post(Endpoints.CREATE_DASHBOARDS)
                .then()
                .spec(Specifications.getSuccessSpec())
                .extract().response();
    }
}
