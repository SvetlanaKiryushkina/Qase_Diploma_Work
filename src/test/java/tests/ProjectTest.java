package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProjectTest extends BaseTest {

    @Test
    public void checkAuthPositive() {
        loginPage.openPage();
        loginPage.login(user, password);
        projectPage.waitTillOpened();
    }

    @Test
    public void checkAuthNegative() {
        loginPage.openPage()
                .login(user, "");
        loginPage.checkErrorMessage("This field is required");
        assertEquals(loginPage.getErrorMessage(), "This field is require");
    }

    @Test
    public void checkCreateProject() {
        loginPage.openPage()
                .login(user, password);
        projectPage.waitTillOpened();
        modalCreateProject.waitForModal();
        modalCreateProject.fillProjectDetails("Test", "Test", "Test Test",
                "Public");
        modalCreateProject.clickCreate();
    }

    @Test
    public void checkDeleteProject() {
        loginPage.openPage()
                .login(user, password);
        projectPage.waitTillOpened();
        modalCreateProject.waitForModal();
        modalCreateProject.fillProjectDetails("Test for delete", "Test", "Test Test",
                "Public");
        modalCreateProject.clickCreate();
        projectPage.openPage();
        projectPage.deleteProject("Test for delete");
    }
}
