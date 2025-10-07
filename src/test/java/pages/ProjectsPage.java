package pages;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static data.Elements.CREATE_NEW_PROJECT_BUTTON;

@Slf4j
public class ProjectsPage {

    private final String DELETE_BUTTON_XPATH = "//span[text()='Delete project']",
            REMOVE_BUTTON_CSS = "[data-testid=remove]",
            MENU_PROJECT_BUTTON = "button[aria-label='Open action menu']",
            NAME_PROJECT_XPATH = "//a[text() = '%s']",
            PROJECTS_URL = "/projects";

    @Step("Открытие страницы с проектами")
    public ProjectsPage openPage() {
        log.info("Открыта страница с проектами");
        open(PROJECTS_URL);
        return this;
    }

    @Step("Ожидаем появления на странице Create new project")
    public ProjectsPage waitTillOpened() {
        try {
            $(byText(CREATE_NEW_PROJECT_BUTTON)).shouldBe(visible, Duration.ofSeconds(60));
        } catch (TimeoutException e) {
            log.error((e.getMessage()));
            Assert.fail("Страница не открылась");
        }
        return this;
    }

    @Step("Удаление проекта")
    public ProjectsPage deleteProject(String projectName) {
        log.info("Проект удален {}", projectName);
        $(byText(projectName))
                .ancestor("tr")
                .find(MENU_PROJECT_BUTTON)
                .click();
        $(REMOVE_BUTTON_CSS).click();
        $x(DELETE_BUTTON_XPATH).click();
        return this;
    }

    @Step("Переход на страницу проекта '{nameProject}'")
    public RepositoryPage openProject(String nameProject) {
        log.info("Перешли на страницу проекта{}", nameProject);
        $x(String.format(NAME_PROJECT_XPATH, nameProject)).click();
        return new RepositoryPage();
    }
}
