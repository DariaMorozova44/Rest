package tests;

import api.ReportApi;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.ReportDto;
import helpers.CsvDataProviderReport;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ReportTest extends BaseTest {
    private final ReportApi reportApi = new ReportApi();
    @Test(dataProvider = "data", dataProviderClass = CsvDataProviderReport.class)

    public void testCreateReport(String name, String typeDiscriminator, String status) {

        ReportDto newReport = new ReportDto();
        newReport.setName(name);
        newReport.setTypeDiscriminator(typeDiscriminator);
        var response = reportApi.createReport(newReport);

        if (Integer.parseInt(status) == 200) {
            response.then().spec(getSuccessSpec());
        } else if (Integer.parseInt(status) == 400) {
            response.then().spec(badRequestSpec());
        }
    }
}

