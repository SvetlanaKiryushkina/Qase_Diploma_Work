package adapters;

import dto.api.models.project.create.CreateProjectRq;
import dto.api.models.project.create.CreateProjectRs;
import dto.api.models.project.get.GetProjectsRs;
import dto.api.models.project.get.Project;
import io.qameta.allure.Step;
import io.restassured.specification.RequestSpecification;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ProjectAPI extends BaseAPI {

    @Step("Создание проекта")
    public CreateProjectRs createProject(CreateProjectRq rq) {
        log.info("Создание проекта с body: {}", rq);
        return getRequestSpec()
                .body(gson.toJson(rq))
                .when()
                .post("project/") // относительный путь
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .as(CreateProjectRs.class);
    }

    @Step("Удаление проекта")
    public void deleteProject(String code) {
        log.info("Удаление проекта с кодом: {}", code);
        getRequestSpec()
                .when()
                .delete("project/" + code) // относительный путь
                .then()
                .log().all()
                .statusCode(200);
    }

    // Вспомогательный метод для получения RequestSpecification
    public RequestSpecification getRequestSpec() {
        return super.getSpec(); // вызываем из базового класса
    }

    @Step("Получение списка проектов")
    public GetProjectsRs getProjects() {
        log.info("Получение всех проектов");
        return getRequestSpec()
                .when()
                .get("/project?limit=10&offset=0")
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .as(GetProjectsRs.class);
    }

    @Step("Удаление лишнего проекта")
    public void deleteAllProjectsExcept(String excludedCode) {
        GetProjectsRs response = getProjects();

        for (Project project : response.getResult().getEntities()) {
            String code = project.getCode();

            if (!code.equals(excludedCode)) {
                deleteProject(code);
            }
        }
    }
}
