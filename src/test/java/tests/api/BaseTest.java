package tests.api;

import adapters.CaseAPI;
import adapters.ProjectAPI;

public class BaseTest {

    ProjectAPI projectAPI;
    CaseAPI caseAPI;

    public BaseTest() {
        this.projectAPI = new ProjectAPI();
        this.caseAPI = new CaseAPI();
    }
}

