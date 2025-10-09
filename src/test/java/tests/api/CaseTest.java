package tests.api;

import dto.api.models.caseAPI.CreateCaseRq;
import dto.api.models.caseAPI.CreateCaseRs;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.testng.Assert.assertTrue;
import static org.testng.FileAssert.fail;

public class CaseTest extends BaseTest {

    @Test(testName = "Создание тест-кейса, позитивный тест",
            description = "Создание тест-кейса, позитивный тест")
    @Description("Создание тест-кейса, позитивный тест")
    @Severity(SeverityLevel.MINOR)
    public void checkCreateCase() {
        CreateCaseRq rq = CreateCaseRq.builder()
                .title("Тестовый тест")
                .layer(1)
                .automation(2)
                .behavior(1)
                .description("Тестовый комментарий")
                .priority(3)
                .build();

        CreateCaseRs rs = caseAPI.createCase(rq, "ST");

        // Проверяем, что ID тест-кейса не пустой
        Integer createdId = rs.getResult().getId();
        assertThat(createdId).isNotNull();
    }

    @Test(testName = "Создание кейса, невалидные данные",
            description = "Создание кейса, невалидные данные")
    @Description("Создание кейса, невалидные данные")
    public void checkCreateCaseNegative() {
        CreateCaseRq rq = CreateCaseRq.builder()
                .title("Тестовый невалидный тест")
                .layer(20) // некорректное значение
                .build();

        Response response = caseAPI.createCaseWithResponse(rq, "ST");

        assertThat(response.getStatusCode()).isEqualTo(422);

        String errorMessage = response.jsonPath().getString("message");
        assertThat(errorMessage).contains("The selected field value is invalid.");
    }

    @Test(testName = "Проверка на обязательное поле 'Title'",
            description = "Проверка на обязательное поле 'Title'")
    @Description("Проверка на обязательное поле 'Title'")
    public void checkCreateCaseNullTitle() {
        CreateCaseRq rq = CreateCaseRq.builder()
                .title("")
                .build();

        Response response = caseAPI.createCaseWithResponse(rq, "ST");

        assertThat(response.getStatusCode()).isEqualTo(422);

        String errorMessage = response.jsonPath().getString("message");
        assertThat(errorMessage).contains("The title field is required.");
    }

    @Test(testName = "Удаление тест-кейса в проекте",
            description = "Удаление тест-кейса")
    @Description("Удаление тест-кейса")
    public void checkDeleteCase() {
        caseAPI.deleteCase("ST", "30");

        // Теперь проверяем, что кейса больше нет
        try {
            caseAPI.getCaseById("ST", "30");
            fail("Кейс всё ещё существует после удаления");
        } catch (AssertionError e) {
            // Ожидаем, что возникнет AssertionError из-за статуса 404
            String message = e.getMessage();
            assertTrue(message.contains("expected status 200") || message.contains("404"),
                    "Ожидался статус 404 после удаления, но получили: " + message);
        }
    }
}
