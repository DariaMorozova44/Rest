package tests;

import dto.ProjectDto;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ProjectTest extends BaseTest {
    @Test()
    @Parameters("projectUrl")
    public void testGetProjectListSuccess(String taskUrl) {

        var response = given()
                .queryParam("$top", -1)
                .queryParam("$skip", 0)
                .when()
                .get(taskUrl)
                .then()
                .statusCode(200)
                .log().body()
                .extract();
        JsonPath json = response.jsonPath();
        List<Map<String, Object>> projects = json.getList("");
        for (Map<String, Object> project : projects) {
            assertThat(project, hasKey("$type"));
            assertThat(project.get("$type"), equalTo("Project"));

        }
    }

    @Test()
    @Parameters({"id_leader","projectUrl"})
    public void testCreateProject(String leader, String projectUrl) {
        String timestamp = String.valueOf(System.currentTimeMillis());
        String projectName = "Мой новый проект " + timestamp;
        String shortName = "MNP" + timestamp.substring(timestamp.length() - 6);
        int randomStartingNumber = ThreadLocalRandom.current().nextInt(1, 1001);
        ProjectDto projectDto = new ProjectDto();
        projectDto.setName(projectName);
        projectDto.setShortName(shortName);
        projectDto.setLeader(Map.of("id", leader)); // admin
        projectDto.setStartingNumber(randomStartingNumber);
        projectDto.setCreateContent(true);

        var response = given()
                .body(projectDto)
                .log().all()
                .when()
                .post(projectUrl)
                .then()
                .log().all()
                .statusCode(200)
                .extract();

        assertThat(response.jsonPath().getString("$type"), equalTo("Project"));
    }
}
