package pages;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import wrappers.RadioButton;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static data.Elements.CREATE_NEW_PROJECT_BUTTON;

@Slf4j
public class ModalCreateProjectPage {

    private final String MODAL_TITLE_TEXT = "Create new project",
            PROJECT_NAME_INPUT = "#project-name",
            PROJECT_CODE_INPUT = "#project-code",
            DESCRIPTION_TEXTAREA = "#description-area",
            BUTTON_CREATE_TEXT = "Create project",
            BUTTON_CANCEL_TEXT = "Cancel";

    RadioButton radioButton = new RadioButton();

    @Step("Открытие модального окна, для создания проекта")
    public ModalCreateProjectPage openModalCreate() {
        log.info("Открылось модальное окно для создания проекта");
        $(byText(CREATE_NEW_PROJECT_BUTTON)).click();
        $(byText(MODAL_TITLE_TEXT)).shouldBe(visible);
        return this;
    }

    @Step("Заполнение формы создания проекта")
    public ModalCreateProjectPage fillProjectDetails(String projectName,
                                                     String projectCode,
                                                     String description,
                                                     String projectType) {
        log.info("Заполнена форма для создания тест-кейса");
        openModalCreate();
        String radioType = radioButton.getRadioButtonXPathByLabel(projectType);
        $(PROJECT_NAME_INPUT).setValue(projectName);
        $(PROJECT_CODE_INPUT).setValue(projectCode);
        $(DESCRIPTION_TEXTAREA).setValue(description);
        $x(radioType).click();
        return this;
    }

    @Step("Нажатие на кнопку Создать проект")
    public RepositoryPage clickCreate() {
        $(byText(BUTTON_CREATE_TEXT)).click();
        return new RepositoryPage();
    }

    @Step("Нажатие на кнопку Cansel")
    public ProjectsPage clickCancel() {
        $(byText(BUTTON_CANCEL_TEXT)).click();
        return new ProjectsPage();
    }

    public void checkAlertMessage() {
        WebDriver driver = WebDriverRunner.getWebDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Ждем появления alert
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        // Проверяем текст
        String alertText = alert.getText();
        assert alertText.equals("Заполните это поле") : "Неверный текст алерта";

        // Подтверждаем
        alert.accept();
    }
}
