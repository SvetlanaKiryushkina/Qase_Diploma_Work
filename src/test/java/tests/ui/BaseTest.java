package tests.ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import listners.TestListener;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.*;
import utils.PropertyReader;

@Listeners(TestListener.class)
public class BaseTest {

    LoginPage loginPage;
    ProjectsPage projectPage;
    ModalCreateProjectPage modalCreateProject;
    RepositoryPage repositoryPage;
    ProjectsPage projectsPage;
    CreateTestCasePage createTestCasePage;
    String user = System.getProperty("user", PropertyReader.getProperty("user"));
    String password = System.getProperty("password", PropertyReader.getProperty("password"));

    @BeforeMethod
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://app.qase.io";
        Configuration.timeout = 20000;
        Configuration.clickViaJs = true;
        //Configuration.headless = true;//запуск тестов без открытия окна браузера
        Configuration.browserSize = "1280x1280";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximazed");
        Configuration.browserCapabilities = options;
        Configuration.holdBrowserOpen = true;

        loginPage = new LoginPage();
        projectPage = new ProjectsPage();
        modalCreateProject = new ModalCreateProjectPage();
        repositoryPage = new RepositoryPage();
        createTestCasePage = new CreateTestCasePage();
        projectsPage = new ProjectsPage();

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
        );
    }

    /*@AfterMethod
    public void tearDawn(){
       if (getWebDriver() != null){
           getWebDriver().quit();
       }
    }

     */
}
