package tests;

import dto.PanelDto;
import helpers.CsvDataProviderPanel;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class PanelTest extends BaseTest {

    @Test(dataProvider = "data_panel", dataProviderClass = CsvDataProviderPanel.class)
    public void testCreatePanel(String name) {
        PanelDto panelDto = new PanelDto();
        panelDto.setName(name);
        Response response = given()
                .body(panelDto)
                .log().all()
                .when()
                .post("http://localhost:8082/api/dashboards")
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();

        assertThat(response.jsonPath().getString("$type"), equalTo("Dashboard"));
    }

}
