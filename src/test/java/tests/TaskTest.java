package tests;

import api.TaskApi;
import dto.TaskDto;
import helpers.CsvDataProviderTask;
import org.testng.annotations.Test;
import specification.Specifications;

import java.util.Map;


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
            response.then().spec(Specifications.getSuccessSpec());
        } else if (Integer.parseInt(status) == 400) {
            response.then().spec(Specifications.badRequestSpec());
        }
    }
}



