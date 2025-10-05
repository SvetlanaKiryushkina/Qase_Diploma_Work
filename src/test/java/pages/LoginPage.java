package pages;

import com.codeborne.selenide.Condition;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    private final String USER_FILED_CSS = "[name=email]";
    private final String PASSWORD_FILED_XPATH = "//*[@name='password']";
    private final String ERROR_MESSAGE_PASSWORD = "//input[@name='password']/ancestor::div//small";
    private final String ERROR_MESSAGE_LOGIN = "//input[@name='email']/ancestor::div//small";
    private final String ERROR_MESSAGE = "//*[@id='modals']/div/div[1]/span/span";

    public LoginPage openPage() {
        open("/login");
        return this;
    }

    public ProjectsPage login(String user, String password) {
        $(USER_FILED_CSS).setValue(user);
        $x(PASSWORD_FILED_XPATH).setValue(password).submit();
        return new ProjectsPage();
    }

    public void checkErrorMessage(String error) {
        $x(ERROR_MESSAGE_PASSWORD).shouldHave(Condition.text(error));
    }

    public void checkError(String error) {
        $x(ERROR_MESSAGE)
                .shouldBe(Condition.visible, Duration.ofSeconds(10))
                .shouldHave(Condition.text(error));
    }

    public String getPasswordErrorMessage() {
        return $x(ERROR_MESSAGE_PASSWORD).text();
    }

    public String getLoginErrorMessage() {
        return $x(ERROR_MESSAGE_LOGIN).text();
    }

    public String getErrorMessage() {
        return $x(ERROR_MESSAGE).text();
    }
}
