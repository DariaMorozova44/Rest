package helpers;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CsvDataProviderTask {
    @DataProvider(name = "data_task")
    public static Object[][] getReportData() throws IOException {
        InputStream is = CsvDataProviderReport.class.getClassLoader().getResourceAsStream("data_task.csv");
        if (is == null) throw new RuntimeException("CSV not found");
        List<Object[]> data = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new InputStreamReader(is))) {
            List<String[]> rows = reader.readAll();
            for (int i = 1; i < rows.size(); i++) {
                String summary = rows.get(i)[0];
                String description = rows.get(i)[1];
                String projectId = rows.get(i)[2];
                String status = rows.get(i)[3];
                data.add(new Object[]{summary, description, projectId, status});
            }
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }
        return data.toArray(new Object[0][]);
    }
}

