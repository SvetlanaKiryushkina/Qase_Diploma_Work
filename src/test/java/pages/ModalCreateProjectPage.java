package pages;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import wrappers.RadioButton;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static data.Elements.CREATE_NEW_PROJECT_BUTTON;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Slf4j
public class ModalCreateProjectPage {

    private final String MODAL_TITLE_TEXT = "Create new project",
            PROJECT_NAME_INPUT = "#project-name",
            PROJECT_CODE_INPUT = "#project-code",
            DESCRIPTION_TEXTAREA = "#description-area",
            BUTTON_CREATE_TEXT = "Create project",
            BUTTON_CANCEL_TEXT = "Cancel",
            INPUT_ERROR_MESSAGE = "validationMessage";

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
        log.info("Нажатие на кнопку Создать проект");
        return new RepositoryPage();
    }

    @Step("Нажатие на кнопку Cansel")
    public ProjectsPage clickCancel() {
        $(byText(BUTTON_CANCEL_TEXT)).click();
        return new ProjectsPage();
    }

    public void verifyValidationMessageForProjectName() {
        String validationMessage = $(PROJECT_NAME_INPUT).getAttribute(INPUT_ERROR_MESSAGE);
        log.info("Полученное сообщение об ошибке: {}", validationMessage);

        try {
            assertThat(validationMessage).matches("(?i)(Заполните это поле\\.|Please fill out this field\\.)");
            log.info("Сообщение соответствует ожидаемому");
        } catch (AssertionError e) {
            log.error("Сообщение не соответствует ожидаемому: {}", validationMessage);
            throw e;
        }
    }
}
