package tests;

import dto.TaskDto;
import helpers.CsvDataProviderReport;
import helpers.CsvDataProviderTask;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class TaskTest extends BaseTest {

    @Test(dataProvider = "data_task", dataProviderClass = CsvDataProviderTask.class)
    public void CreateIssue(String summary, String description, String projectId) {

        TaskDto taskDto = new TaskDto();
        taskDto.setSummary(summary);
        taskDto.setDescription(description);
        taskDto.setProject(Map.of("id", projectId));

        Response response = given()
                .body(taskDto)
                .log().body()
                .when()
                .post("http://localhost:8082/api/issues")
                .then()
                .statusCode(200)
                .log().body()
                .extract()
                .response();


        assertThat(response.jsonPath().getString("$type"), equalTo("Issue"));
    }

}

