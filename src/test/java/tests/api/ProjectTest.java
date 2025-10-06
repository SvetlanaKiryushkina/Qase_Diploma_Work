package tests.api;

import dto.api.models.project.create.CreateProjectRq;
import dto.api.models.project.create.CreateProjectRs;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;


public class ProjectTest extends BaseTest {

    @Test(testName = "Создание проекта",
            description = "Создание проекта")
    @Description("Создание проекта")
    @Severity(SeverityLevel.MINOR)
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
