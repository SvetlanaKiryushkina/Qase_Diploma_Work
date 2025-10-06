package tests.api;

import adapters.CaseAPI;
import adapters.ProjectAPI;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    ProjectAPI projectAPI;
    CaseAPI caseAPI;

    @BeforeClass
    public void initAPIAdapter() {
        RestAssured.useRelaxedHTTPSValidation();
        projectAPI = new ProjectAPI();
        caseAPI = new CaseAPI();
    }
}

