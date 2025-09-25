package tests.ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import pages.ModalCreateProject;
import pages.ProjectNewPage;
import pages.ProjectsPage;
import listners.PropertyReader;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class UIBaseTest {

    LoginPage loginPage;
    ProjectsPage projectPage;
    ModalCreateProject modalCreateProject;
    ProjectNewPage projectNewPage;
    String user = System.getProperty("user", PropertyReader.getProperty("user"));
    String password = System.getProperty("password",PropertyReader.getProperty("password"));

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
        modalCreateProject = new ModalCreateProject();
        projectNewPage = new ProjectNewPage();

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
        );
    }

    @AfterMethod
    public void tearDawn(){
       if (getWebDriver() != null){
           getWebDriver().quit();
       }
    }
}
