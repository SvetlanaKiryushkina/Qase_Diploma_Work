package adapters;

import dto.api.models.project.create.CreateProjectRq;
import dto.api.models.project.create.CreateProjectRs;
import io.restassured.specification.RequestSpecification;

//класс который описывает всю логику работы с проектами.
// Тут будут описаны все методы, которые будут работать все методы с которыми работаем PUT и т.д
public class ProjectAPI extends BaseAPI {

    //Метод для создания проекта
    public CreateProjectRs createProject(CreateProjectRq rq) {
        return getRequestSpec()
                .body(gson.toJson(rq))
                .when()
                .post("https://api.qase.io/v1/project/") // относительный путь
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .as(CreateProjectRs.class);
    }

    // Метод для удаления проекта
    public void deleteProject(String code) {
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
}