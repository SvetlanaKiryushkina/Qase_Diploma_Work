package pages;

import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static data.Elements.CREATE_NEW_PROJECT_BUTTON;

public class ProjectsPage {

    private final String DELETE_BUTTON_XPATH = "//span[text()='Delete project']",
            REMOVE_BUTTON_CSS = "[data-testid=remove]",
            MENU_PROJECT_BUTTON = "button[aria-label='Open action menu']",
            NAME_PROJECT_XPATH = "//a[text() = '%s']",
            PROJECTS_URL = "/projects";

    @Step("Открытие страницы с проектами")
    public ProjectsPage openPage() {
        open(PROJECTS_URL);
        return this;
    }

    @Step("Ожидаем появления на странице Create new project")
    public ProjectsPage waitTillOpened() {
        $(byText(CREATE_NEW_PROJECT_BUTTON)).shouldBe(visible, Duration.ofSeconds(20));
        return this;
    }

    @Step("Удаление проекта")
    public ProjectsPage deleteProject(String projectName) {
        $(byText(projectName))
                .ancestor("tr")
                .find(MENU_PROJECT_BUTTON)
                .click();
        $(REMOVE_BUTTON_CSS).click();
        $x(DELETE_BUTTON_XPATH).click();
        return this;
    }

    /*//Проверяет наличие проектов на странице и удаляет все, кроме "ShareLane Test".
    public void deleteExtraProjects() {
        List<String> projectNames = $$("tbody tr").stream()
                .map(row -> row.find("a").getText())
                .collect(Collectors.toList());

        for (String projectName : projectNames) {
            if (!projectName.equals("ShareLane Test")) {
                deleteProject(projectName);
            }
        }
    }

    public void deleteProjectsExceptShareLaneTest() {
        String excludedProjectName = "ShareLane Test";

        // Получаем все элементы проектов по тексту
        ElementsCollection projectElements = $$("//table//tr//td//a[contains(@href, '/project/')]");

        for (SelenideElement projectElement : projectElements) {
            String projectName = projectElement.getText();

            if (!projectName.equals(excludedProjectName)) {
                // Находим родительский tr
                SelenideElement row = projectElement.closest("tr");

                // Кликаем по кнопке меню внутри строки
                row.find(MENU_PROJECT_BUTTON).click();

                // Удаляем проект
                $(REMOVE_BUTTON_CSS).click();
                $x(DELETE_BUTTON_XPATH).click();
            }
        }
    }

    public List<String> getAllProjectNames() {
        // Замените на актуальный селектор, который выбирает элементы проектов
        ElementsCollection projectElements = $$("css-селектор-ваших-проектов");

        // Получаем список названий проектов
        List<String> projectNames = projectElements.stream()
                .map(SelenideElement::getText)
                .collect(Collectors.toList());

        return projectNames;
    }

     */

    @Step("Переход на страницу проекта '{nameProject}'")
    public RepositoryPage openProject(String nameProject) {
        $x(String.format(NAME_PROJECT_XPATH, nameProject)).click();
        return new RepositoryPage();
    }
}
