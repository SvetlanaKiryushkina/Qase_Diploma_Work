package tests.api;

import dto.api.models.project.create.CreateProjectRs;
import io.restassured.RestAssured;
import dto.api.models.project.create.CreateProjectRq;
import org.testng.annotations.Test;

import static dto.api.adapters.ProjectAPI.createProject;
import static dto.api.adapters.ProjectAPI.deleteProject;

public class APIProjectTest {

    @Test
    public void checkCreateProject(){
        RestAssured.useRelaxedHTTPSValidation();
        CreateProjectRq rq = CreateProjectRq.builder()
                .title("Name progect")
                .code("NP")
                .description("test")
                .group("test")
                .access("all")
                .build();

        CreateProjectRs rs = createProject(rq);
        String code = rs.getResult().getCode();

        deleteProject(code);
    }
}
