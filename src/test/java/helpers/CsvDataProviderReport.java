package helpers;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CsvDataProviderReport {

    @DataProvider(name = "data")
    public static Object[][] getReportData() throws IOException {
        InputStream is = CsvDataProviderReport.class.getClassLoader().getResourceAsStream("data.csv");
        if (is == null) throw new RuntimeException("CSV not found");
        List<Object[]> data = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new InputStreamReader(is))) {
            List<String[]> rows = reader.readAll();
            for (int i = 1; i < rows.size(); i++) {
                String name = rows.get(i)[0];
                String type = rows.get(i)[1];
                String status = rows.get(i)[2];
                data.add(new Object[]{name, type, status});
            }
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }
        return data.toArray(new Object[0][]);
    }
}

