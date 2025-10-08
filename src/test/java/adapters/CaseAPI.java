package adapters;

import dto.api.models.caseAPI.CreateCaseRq;
import dto.api.models.project.create.CreateProjectRq;
import dto.api.models.project.create.CreateProjectRs;
import io.qameta.allure.Step;
import io.restassured.specification.RequestSpecification;
import lombok.extern.log4j.Log4j2;

//описываем все методы, которые взаимодействуют с кейсами, создание изменение
@Log4j2
public class CaseAPI extends BaseAPI {

    @Step("Создание тест-кейса")
    public CreateProjectRs createCase(CreateCaseRq rq) {
        log.info("Создание тест-кейса с body: {}", rq);
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


    // Вспомогательный метод для получения RequestSpecification
    public RequestSpecification getRequestSpec() {
        return super.getSpec(); // вызываем из базового класса
    }
}
