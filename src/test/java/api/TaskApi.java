package api;

import dto.TaskDto;
import helpers.ConfigLoader;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;

public class TaskApi {


    public Response createIssue(TaskDto taskDto) {
        return RestAssured.given()
                .body(taskDto)
                .post(ConfigLoader.getIssueUrl())
                .then()
                .log().all()
                .extract().response();

    }
}
