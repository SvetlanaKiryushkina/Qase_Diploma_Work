package pages;

import wrappers.RadioButton;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static data.Elements.CREATEE_NEW_PROJECT_BUTTON;

public class ModalCreateProject {

    // Заголовок модального окна для ожидания
    private final String MODAL_TITLE_TEXT = "Create new project";
    private final String PROJECT_NAME_INPUT = "#project-name";
    private final String PROJECT_CODE_INPUT = "#project-code";
    private final String DESCRIPTION_TEXTAREA = "#description-area";
    private final String BUTTON_CREATE_TEXT = "Create project";
    private final String BUTTON_CANCEL_TEXT = "Cancel";

    RadioButton radioButton = new RadioButton();

    public ModalCreateProject openModalCreate() {
        $(byText(CREATEE_NEW_PROJECT_BUTTON)).click();
        $(byText(MODAL_TITLE_TEXT)).shouldBe(visible);
        return this;
    }

    // Метод заполнения формы
    public ModalCreateProject fillProjectDetails(String projectName, String projectCode, String description, String projectType) {
        waitForModal();
        $(PROJECT_NAME_INPUT).setValue(projectName);
        $(PROJECT_CODE_INPUT).setValue(projectCode);
        $(DESCRIPTION_TEXTAREA).setValue(description);
        String radioType = radioButton.getRadioButtonXPathByLabel(projectType);
        $x(radioType).click();
        return this;
    }

    // Метод для нажатия кнопки "Create project"
    public ProjectNewPage clickCreate() {
        $(byText(BUTTON_CREATE_TEXT)).click();
        return new ProjectNewPage();
    }

    // Метод для нажатия кнопки "Cancel"
    public ProjectsPage clickCancel() {
        $(byText(BUTTON_CANCEL_TEXT)).click();
        return new ProjectsPage();
    }
}
