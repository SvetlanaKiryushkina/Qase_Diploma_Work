package steps;

import pages.LoginPage;
import pages.ProjectsPage;

public class LoginStep {

    LoginPage loginPage = new LoginPage();
    ProjectsPage projectsPage = new ProjectsPage();

    public void auth(String user, String password) {
        loginPage.openPage();
        loginPage.login(user, password);
        projectsPage.waitTillOpened();
    }

    public void enterCredentials(String user, String password) {
        loginPage.openPage();
        loginPage.login(user, password);
    }
}
