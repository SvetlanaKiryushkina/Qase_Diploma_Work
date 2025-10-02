package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static data.Elements.CREATE_NEW_PROJECT_BUTTON;

public class ProjectsPage {

    private final String DELETE_BUTTON_XPATH = "//span[text()='Delete project']";
    private final String REMOVE_BUTTON_CSS = "[data-testid=remove]";
    private final String MENU_PROJECT_BUTTON = "button[aria-label='Open action menu']";
    private String PROJECTS_URL = "/projects";
    private final String NAME_PROJECT = "//a[text() = 'ShareLane Test']";

    @Step("Открытие страницы с проектами")
    public ProjectsPage openPage() {
        open(PROJECTS_URL);
        return this;
    }

    @Step("Ожидаем появления на странице Create new project")
    public ProjectsPage waitTillOpened() {
        $(byText(CREATE_NEW_PROJECT_BUTTON)).shouldBe(Condition.visible);
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

    //Третий альтернативный метод проверки наличия товара в корзине
    public ArrayList<String> getProjectName() {
        ArrayList<String> names = $("tbody").findAll("a").stream()
                .map(SelenideElement::getText)
                .collect(Collectors.toCollection(ArrayList::new));

        // Выводим список в консоль
        System.out.println("Список проектов: " + names);

        return names;
    }

    //Проверяет наличие проектов на странице и удаляет все, кроме "ShareLane Test".
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

    @Step("Переход на страницу проекта")
    public RepositoryPage openProject (String nameProject){
        $x(NAME_PROJECT).click();
        return new RepositoryPage();
    }
}