package tests.ui;

import dto.ui.Case;
import dto.ui.CaseFactory;
import org.testng.annotations.Test;

public class ProjectTest extends BaseTest {

    @Test(testName = "Проверка создания нового проекта",
            description = "Проверка создания нового проекта")
    public void checkCreateProject() {
        loginPage.openPage()
                .login(user, password);
        projectPage.waitTillOpened();
        modalCreateProject.openModalCreate();
        modalCreateProject.fillProjectDetails("Test", "Test", "Test Test",
                "Public");
        modalCreateProject.clickCreate();
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

    @Test(testName = "Проверка перехода на страницу создания тест-кейса")
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

    @Test
    public void test() {
        loginPage.openPage()
                .login(user, password);
        projectPage.waitTillOpened();
        projectPage.getProjectName();
    }

    @Test
    public void test2() {
        Case testCase = CaseFactory.getTestCase("a", "ak", "au", "au", "ua", "df",
                "df", "fddfv", "rdgd", "sfs", "sfr", "ergr");
        loginPage.openPage()
                .login(user, password);
        projectPage.waitTillOpened();
        modalCreateProject.openModalCreate();
        modalCreateProject.fillProjectDetails("Test", "Test", "Test Test",
                "Public");
        modalCreateProject.clickCreate();
        createTestCasePage.openPageTestCreate();
        createTestCasePage.fillForm(testCase);
    }

    @Test
    public void test3() {
        loginPage.openPage()
                .login(user, password);
        projectsPage.waitTillOpened();
        projectsPage.openProject("ShareLane Test");
        repositoryPage.isOpenedPage();
        repositoryPage.addFilter();
    }
}
