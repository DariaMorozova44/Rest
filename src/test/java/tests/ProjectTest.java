package tests;

import api.ProjectApi;
import dto.ProjectDto;
import helpers.ConfigLoader;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasKey;

public class ProjectTest extends BaseTest {
    private final ProjectApi projectApi = new ProjectApi();

    @Test()
    public void testGetProjectListSuccess() {
        var response = projectApi.getProjects();

        JsonPath json = response.jsonPath();
        List<Map<String, Object>> projects = json.getList("");
        for (Map<String, Object> project : projects) {
            assertThat(project, hasKey("$type"));
            assertThat(project.get("$type"), equalTo("Project"));

        }
    }

    @Test()
    public void testCreateProject() {
        String timestamp = String.valueOf(System.currentTimeMillis());
        String projectName = "Мой новый проект " + timestamp;
        String shortName = "MNP" + timestamp.substring(timestamp.length() - 6);
        int randomStartingNumber = ThreadLocalRandom.current().nextInt(1, 1001);
        ProjectDto projectDto = new ProjectDto();
        projectDto.setName(projectName);
        projectDto.setShortName(shortName);
        projectDto.setLeader(Map.of("id", ConfigLoader.getIdLeader())); // admin
        projectDto.setStartingNumber(randomStartingNumber);
        projectDto.setCreateContent(true);

        var response = projectApi.createProject(projectDto);


        assertThat(response.jsonPath().getString("$type"), equalTo("Project"));
    }
}
