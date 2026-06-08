package helpers;

import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
    private static final Properties properties = new Properties();

    static {
        try (InputStream input = ConfigLoader.class.getClassLoader()
                .getResourceAsStream("test-config.properties")) {
            if (input == null) {
                throw new RuntimeException("config.properties not found in classpath");
            }
            properties.load(input);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    public static String getBaseUrl() {
        return properties.getProperty("baseUrl");
    }

    public static String getToken() {
        return properties.getProperty("permanentToken");
    }

    public static String getIdLeader() {
        return properties.getProperty("id_leader");
    }
    public static String getProjectUrl() {
        return properties.getProperty("projectUrl");
    }
    public static String getPanelUrl() {
        return properties.getProperty("createPanelUrl");
    }
    public static String getReportUrl() {
        return properties.getProperty("createReportUrl");
    }
    public static String getIssueUrl() {
        return properties.getProperty("createIssueUrl");
    }
}
