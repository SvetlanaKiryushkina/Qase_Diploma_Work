package pages;

import dto.ui.Case;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import wrappers.TextInput;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class CreateTestCasePage {

    private final String BUTTON_CREATE_TEST = "New test";

    @Step("Открытие страницы создания тест-кейса")
    public CreateTestCasePage openPageTestCreate() {
        $(byText(BUTTON_CREATE_TEST)).click();
        return this;
    }

    @Step("Создание тест-кейса с наименованием {testCase.getTitle}")
    public void createTestCase(Case testCase) {
    }

    @Step("Заполнение формы создания тест-кейса")
    public void fillForm(Case testCase) {
        log.info("Create New Test Case");
        new TextInput("Title").write(testCase.getDescription());
        new TextInput("Description").write(testCase.getSeverity());
    }
}
