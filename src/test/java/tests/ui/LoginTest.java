package tests.ui;

import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.Retry;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test(testName = "Проверка входа с валидными логином/паролем",
            description = "Проверка входа с валидными логином/паролем",
            groups = "smoke")
    @Description("Проверка входа с валидными логином/паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void checkAuthPositive() {
        loginStep.auth(user, password);
    }

    @Test(testName = "Проверка входа с пустым паролем",
            description = "Проверка входа с пустым паролем")
    @Description("Проверка входа с пустым паролем")
    @Severity(SeverityLevel.NORMAL)
    public void checkAuthNegativeNullPassword() {
        loginStep.enterCredentials(user, "");
        loginPage.checkErrorMessage("This field is required");
        assertEquals(loginPage.getPasswordErrorMessage(), "This field is required");
    }

    @Test(testName = "Проверка входа с невалидным логином и паролем",
            description = "Проверка входа с с невалидным логином и паролем", retryAnalyzer = Retry.class)
    @Description("Проверка входа с с невалидным логином и паролем")
    @Severity(SeverityLevel.NORMAL)
    public void checkAuthNegative() {
        loginStep.enterCredentials("test", "test");
        loginPage.checkError("Value 'test' does not match format email of type string");
        assertEquals(loginPage.getErrorMessage(), "Value 'test' does not match format email of type string");
    }

    @DataProvider(name = "Проверка логина с негативными данными")
    public Object[][] loginData() {
        return new Object[][]{
                {user, "", "This field is required"},
                {"", password, "This field is required"}
        };
    }

    @Test(testName = "Проверка логина с негативными данными",
            dataProvider = "Проверка логина с негативными данными",
            description = "Проверка логина с негативными данными")
    @Description("Проверка логина с негативными данными")
    @Owner("Светлана")
    @Feature("Authorization")
    @Severity(SeverityLevel.NORMAL)
    public void paramNegativeTest(String user, String password, String expectedErrorMessage) {
        loginStep.enterCredentials(user, password);
        assertEquals(loginPage.getLoginErrorMessage(),
                expectedErrorMessage,
                "Сообщение об ошибке не соответствует");
    }
}
