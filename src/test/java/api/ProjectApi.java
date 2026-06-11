package api;

import dto.ProjectDto;
import endpoints.Endpoints;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import specification.Specifications;


public class ProjectApi  {

    public Response getProjects() {
        return RestAssured.given()
                .queryParam("$top", -1)
                .queryParam("$skip", 0)
                .get(Endpoints.GET_PROJECTS)
                .then()
                .spec(Specifications.getSuccessSpec())
                .extract().response();
    }

    public Response createProject(ProjectDto projectDto) {
        return RestAssured.given()
                .body(projectDto)
                .post(Endpoints.GET_PROJECTS)
                .then()
                .spec(Specifications.getSuccessSpec())
                .extract().response();
    }
}


