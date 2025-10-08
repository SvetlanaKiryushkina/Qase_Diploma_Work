package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class LoginPage {

    private final String USER_FILED_CSS = "[name=email]",
            PASSWORD_FILED_XPATH = "//*[@name='password']",
            SING_IN_BATTON = "//span[text()='Sign in']",
            ERROR_MESSAGE_PASSWORD = "//input[@name='password']/ancestor::div//small",
            ERROR_MESSAGE_LOGIN = "//input[@name='email']/ancestor::div//small",
            ERROR_MESSAGE = "//*[@id='modals']/div/div[1]/span/span";

    @Step("Открытие страницы авторизации")
    public LoginPage openPage() {
        open("/login");
        $x(SING_IN_BATTON).shouldBe(visible, Duration.ofSeconds(20));
        log.info("Открылась страница авторизации");
        return this;
    }

    @Step("Авторизация с валидным логином и паролем")
    public ProjectsPage login(String user, String password) {
        sleep(5000);
        log.info("Авторизация с валидным логином и паролем");
        $(USER_FILED_CSS).setValue(user);
        $x(PASSWORD_FILED_XPATH).setValue(password).submit();
        return new ProjectsPage();
    }

    public void checkErrorMessage(String error) {
        $x(ERROR_MESSAGE_PASSWORD).shouldHave(Condition.text(error));
    }

    public void checkError(String error) {
        $x(ERROR_MESSAGE)
                .shouldBe(visible, Duration.ofSeconds(10))
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
