package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static data.Elements.CREATEE_NEW_PROJECT_BUTTON;

public class ProjectsPage {

    private final String DELETE_BUTTON_XPATH = "//span[text()='Delete project']";
    private final String REMOVE_BUTTON_CSS = "[data-testid=remove]";
    private String PROJECT_NAME_CSS = "#project-name";

    public ProjectsPage openPage() {
        open("/projects");
        return this;
    }

    //ожидаем пока на странице не появится "Create new project"
    public ProjectsPage waitTillOpened() {
        $(byText(CREATEE_NEW_PROJECT_BUTTON)).shouldBe(Condition.visible);
        return this;
    }

    public void createProject(String project) {
        $(byText(CREATEE_NEW_PROJECT_BUTTON)).click();
        $(PROJECT_NAME_CSS).setValue(project);
        $(byText("Create project")).click();
    }

    public void deleteProject(String project) {
        $(byText(project))
                .ancestor("tr")
                .find("button[aria-label='Open action menu']")
                .click();
        $(REMOVE_BUTTON_CSS).click();
        $x(DELETE_BUTTON_XPATH).click();
    }
}
