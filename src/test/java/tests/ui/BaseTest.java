package tests.ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import listners.TestListener;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import pages.*;
import steps.CaseStep;
import steps.LoginStep;
import steps.ProjectStep;
import utils.PropertyReader;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Listeners(TestListener.class)
public class BaseTest {

    LoginPage loginPage;
    ProjectsPage projectPage;
    ModalCreateProjectPage modalCreateProject;
    RepositoryPage repositoryPage;
    ProjectsPage projectsPage;
    CasePage casePage;
    LoginStep loginStep;
    ProjectStep projectStep;
    CaseStep caseStep;
    String user = System.getProperty("user", PropertyReader.getProperty("user"));
    String password = System.getProperty("password", PropertyReader.getProperty("password"));

    @Parameters({"browser"})
    @BeforeMethod(description = "Настройка браузера", alwaysRun = true)
    public void setUp(@Optional("chrome") String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            Configuration.browser = "chrome";
            Configuration.baseUrl = "https://app.qase.io";
            Configuration.timeout = 20000;
            Configuration.clickViaJs = true;
            //запуск тестов без открытия окна браузера
            Configuration.headless = true;
            Configuration.browserSize = "1280x1280";
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximazed");
            Configuration.browserCapabilities = options;
            Configuration.holdBrowserOpen = true;
        } else if (browser.equalsIgnoreCase("firefox")) {
            Configuration.browser = "chrome";
            Configuration.baseUrl = "https://app.qase.io";
            Configuration.timeout = 50000;
            Configuration.clickViaJs = true;
        }

        loginPage = new LoginPage();
        projectPage = new ProjectsPage();
        modalCreateProject = new ModalCreateProjectPage();
        repositoryPage = new RepositoryPage();
        casePage = new CasePage();
        projectsPage = new ProjectsPage();
        loginStep = new LoginStep();
        projectStep = new ProjectStep();
        caseStep = new CaseStep();

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
        );
    }

    @AfterMethod
    public void tearDawn() {
        if (getWebDriver() != null) {
            getWebDriver().quit();
        }
    }
}
