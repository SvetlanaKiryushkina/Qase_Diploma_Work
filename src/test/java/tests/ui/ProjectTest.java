package tests.ui;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

public class ProjectTest extends BaseTest {

    @Test(testName = "Проверка создания нового проекта",
            description = "Проверка создания нового проекта",
            groups = "smoke")
    @Severity(SeverityLevel.CRITICAL)
    public void checkCreateProject() {
        loginStep.auth(user, password);
        projectStep.createNewProject("Test", "Test", "Test Test",
                "Public");
        projectPage.openPage();
        projectPage.deleteProject("Test");
    }

    //дописать проверку на пустое поле
    @Test(testName = "Создание нового проекта без названия",
            description = "Создание нового проекта без названия")
    @Description("Создание нового проекта без названия")
    @Severity(SeverityLevel.CRITICAL)
    public void checkNewProjectWithoutTitle() {
        loginStep.auth(user, password);
        projectStep.createNewProject("", "Test", "Test Test",
                "Public");
    }

    @Test(testName = "Проверка удаления созданного проекта",
            description = "Проверка удаления созданного проекта")
    @Description("Проверка удаления созданного проекта")
    @Severity(SeverityLevel.NORMAL)
    public void checkDeleteProject() {
        loginStep.auth(user, password);
        projectStep.createNewProject("Test for delete", "Test", "Test Test",
                "Public");
        projectPage.openPage();
        projectPage.deleteProject("Test for delete");
    }

    @Test(testName = "Проверка перехода на страницу создания тест-кейса",
            description = "Проверка перехода на страницу создания тест-кейса",
            groups = "smoke")
    @Description("Проверка перехода на страницу создания тест-кейса")
    @Severity(SeverityLevel.CRITICAL)
    public void checkOpenPageCreateTestCase() {
        loginStep.auth(user, password);
        modalCreateProject.openModalCreate();
        modalCreateProject.fillProjectDetails("Test", "Test", "Test Test",
                "Public");
        modalCreateProject.clickCreate();
        repositoryPage.clickCreateTestButton();
        casePage.isOpenedPage();
        projectPage.openPage();
        projectPage.deleteProject("Test");
    }
}
