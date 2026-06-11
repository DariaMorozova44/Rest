package endpoints;

import helpers.ConfigLoader;

public class Endpoints {
    public static final String BASE_URL = ConfigLoader.getBaseUrl();

    public static final String CREATE_DASHBOARDS = BASE_URL + "api/dashboards";
    public static final String GET_PROJECTS = BASE_URL +"api/admin/projects";
    public static final String CREATE_REPORTS = BASE_URL + "api/reports";
    public static final String CREATE_ISSUE = BASE_URL +  "api/issues";


}


