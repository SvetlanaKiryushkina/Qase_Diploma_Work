package tests.ui;

import org.testng.annotations.Test;
import utils.Retry;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test(testName = "Проверка входа с валидными логином/паролем")
    public void checkAuthPositive() {
        loginPage.openPage();
        loginPage.login(user, password);
        projectPage.waitTillOpened();
    }

    @Test(testName = "Проверка входа с пустым паролем",
            description = "Проверка входа с пустым паролем", retryAnalyzer = Retry.class)
    public void checkAuthNegativeNullPassword() {
        loginPage.openPage()
                .login(user, "");
        loginPage.checkErrorMessage("This field is required");
        assertEquals(loginPage.getPasswordErrorMessage(), "This field is required");
    }

    @Test(testName = "Проверка входа с пустым логином",
            description = "Проверка входа с пустым логином и паролем", retryAnalyzer = Retry.class)
    public void checkAuthNegative() {
        loginPage.openPage()
                .login("", "123");
        loginPage.checkErrorMessage("This field is required");
        assertEquals(loginPage.getLoginErrorMessage(), "This field is required");
    }
}
