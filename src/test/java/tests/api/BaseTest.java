package tests.api;

import adapters.CaseAPI;
import adapters.ProjectAPI;

public class BaseTest {

    ProjectAPI projectAPI;
    CaseAPI caseAPI;

    {
        projectAPI = new ProjectAPI();
        caseAPI = new CaseAPI();
    }
}

