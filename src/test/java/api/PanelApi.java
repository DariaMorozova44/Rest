package api;

import dto.PanelDto;
import helpers.ConfigLoader;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;

public class PanelApi {


    public Response createPanel(PanelDto panelDto) {
        return RestAssured.given()
                .body(panelDto)
                .post(ConfigLoader.getPanelUrl())
                .then()
                .extract().response();
    }
}
