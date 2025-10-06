package tests.api;

import dto.api.models.project.create.CreateProjectRq;
import dto.api.models.project.create.CreateProjectRs;
import org.testng.annotations.Test;


public class ProjectTest extends BaseTest {

    @Test
    public void checkCreateProject() {
        CreateProjectRq rq = CreateProjectRq.builder()
                .title("Name project")
                .code("NP")
                .description("test")
                .group("test")
                .access("all")
                .build();
        CreateProjectRs rs = projectAPI.createProject(rq);
        String code = rs.getResult().getCode();
        projectAPI.deleteProject(code);
    }
}
