package dto.api.adapters;

import dto.api.models.project.create.CreateProjectRq;
import dto.api.models.project.create.CreateProjectRs;

//класс который описывает всю логику работы с проектами.
// Тут будут описаны все методы, которые будут работать все методы с которыми работаем PUT и т.д
public class ProjectAPI extends BaseAPI {

    public static CreateProjectRs createProject(CreateProjectRq rq) {
        return spec
                .body(gson.toJson(rq))
                .when()
                .post(BASE_URI + "project/")
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .as(CreateProjectRs.class);
    }

    public static void deleteProject(String code) {
        spec
                .when()
                .delete(BASE_URI + "project/" + code)
                .then()
                .log().all()
                .statusCode(200);
    }
}