package tests.ui;

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
    }

    @Test(testName = "Создание нового проекта без названия",
            description = "Создание нового проекта без названия")
    @Severity(SeverityLevel.CRITICAL)
    public void checkNewProjectWithoutTitle() {
        loginStep.auth(user, password);
        projectStep.createNewProject("", "Test", "Test Test",
                "Public");


    }

    @Test(testName = "Проверка удаления созданного проекта")
    public void checkDeleteProject() {
        loginPage.openPage()
                .login(user, password);
        projectPage.waitTillOpened();
        modalCreateProject.openModalCreate();
        modalCreateProject.fillProjectDetails("Test for delete", "Test", "Test Test",
                "Public");
        modalCreateProject.clickCreate();
        projectPage.openPage();
        projectPage.deleteProject("Test for delete");
    }

    @Test(testName = "Проверка перехода на страницу создания тест-кейса",
            groups = "smoke")
    public void checkOpenPageCreateTestCase() {
        loginPage.openPage()
                .login(user, password);
        projectPage.waitTillOpened();
        modalCreateProject.openModalCreate();
        modalCreateProject.fillProjectDetails("Test", "Test", "Test Test",
                "Public");
        modalCreateProject.clickCreate();
        repositoryPage.clickCreateTestButton();
        repositoryPage.isOpenedPage();
    }

    @Test(testName = "Проверка аллерта")
    public void test4() {
        loginStep.auth(user, password);
        projectStep.createNewProject("", "test", "test", "Private");
        modalCreateProject.checkAlertMessage();
    }
}
