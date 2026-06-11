package api;

import dto.TaskDto;
import endpoints.Endpoints;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TaskApi {


    public Response createIssue(TaskDto taskDto) {
        return RestAssured.given()
                .body(taskDto)
                .post(Endpoints.CREATE_ISSUE)
                .then()
                .log().all()
                .extract().response();

    }
}
