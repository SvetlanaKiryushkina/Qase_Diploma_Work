package adapters;

import dto.api.models.caseAPI.CaseDetails;
import dto.api.models.caseAPI.CreateCaseRq;
import dto.api.models.caseAPI.CreateCaseRs;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class CaseAPI extends BaseAPI {

    @Step("Создание тест-кейса")
    public CreateCaseRs createCase(CreateCaseRq rq, String code) {
        log.info("Создание тест-кейса с body: {} для проекта {}", rq, code);
        return getRequestSpec()
                .body(gson.toJson(rq))
                .when()
                .post("case/" + code)
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .as(CreateCaseRs.class);
    }

    @Step("Создание кейса с получением полного ответа")
    public Response createCaseWithResponse(CreateCaseRq rq, String code) {
        log.info("Создание тест-кейса с body: {} для проекта {}", rq, code);
        return getRequestSpec()
                .body(gson.toJson(rq))
                .when()
                .post("case/" + code)
                .then()
                .log().all()
                .extract()
                .response(); // возвращает весь ответ
    }

    @Step("Удаление тест-кейса")
    public CreateCaseRs deleteCase(String code, String id) {
        log.info("Удаление тест-кейса для проекта: {} с id {}", code, id);
        return getRequestSpec()
                .when()
                .delete("case/" + code + "/" + id)
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .as(CreateCaseRs.class);
    }

    @Step("Получение тест-кейса по id")
    public CaseDetails getCaseById(String code, String id) {
        return getRequestSpec()
                .when()
                .get("case/" + code + "/" + id)
                .then()
                .statusCode(200) // ожидаем, что кейс есть
                .extract()
                .as(CaseDetails.class);
    }

    // Вспомогательный метод для получения RequestSpecification
    public RequestSpecification getRequestSpec() {
        return super.getSpec(); // вызываем из базового класса
    }
}
