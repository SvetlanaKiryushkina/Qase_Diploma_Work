package pages;

import io.qameta.allure.Step;
import wrappers.RadioButton;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static data.Elements.CREATE_NEW_PROJECT_BUTTON;

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
        $(byText(CREATE_NEW_PROJECT_BUTTON)).click();
        $(byText(MODAL_TITLE_TEXT)).shouldBe(visible);
        return this;
    }

    @Step("Заполнение формы создания проекта")
    public ModalCreateProjectPage fillProjectDetails(String projectName,
                                                     String projectCode,
                                                     String description,
                                                     String projectType) {
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
}
