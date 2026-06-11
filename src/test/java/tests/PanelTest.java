package tests;

import api.PanelApi;
import dto.PanelDto;
import helpers.CsvDataProviderPanel;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class PanelTest extends BaseTest {
    private final PanelApi panelApi = new PanelApi();

    @Test(dataProvider = "data_panel", dataProviderClass = CsvDataProviderPanel.class)
    public void testCreatePanel(String name) {
        PanelDto panelDto = new PanelDto();
        panelDto.setName(name);
       var response = panelApi.createPanel(panelDto);


        assertThat(response.jsonPath().getString("$type"), equalTo("Dashboard"));
    }

}
