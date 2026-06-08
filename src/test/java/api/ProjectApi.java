package api;

import dto.ProjectDto;
import helpers.ConfigLoader;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;


public class ProjectApi  {

    public Response getProjects() {
        return RestAssured.given()
                .queryParam("$top", -1)
                .queryParam("$skip", 0)
                .get(ConfigLoader.getProjectUrl())
                .then()
                .extract().response();
    }

    public Response createProject(ProjectDto projectDto) {
        return RestAssured.given()
                .body(projectDto)
                .post(ConfigLoader.getProjectUrl())
                .then()
                .extract().response();
    }
}


