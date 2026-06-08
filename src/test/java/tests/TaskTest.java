package tests;

import api.TaskApi;
import dto.TaskDto;
import helpers.CsvDataProviderTask;
import org.testng.annotations.Test;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class TaskTest extends BaseTest {
    private final TaskApi taskApi = new TaskApi();

    @Test(dataProvider = "data_task", dataProviderClass = CsvDataProviderTask.class)
    public void CreateIssue(String summary, String description, String projectId, String status) {

        TaskDto taskDto = new TaskDto();
        taskDto.setSummary(summary);
        taskDto.setDescription(description);
        taskDto.setProject(Map.of("id", projectId));

        var response = taskApi.createIssue(taskDto);
        if (Integer.parseInt(status) == 200) {
            response.then().spec(getSuccessSpec());
        } else if (Integer.parseInt(status) == 400) {
            response.then().spec(badRequestSpec());
        }
    }
}



