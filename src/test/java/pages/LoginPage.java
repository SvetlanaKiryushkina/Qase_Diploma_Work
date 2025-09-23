package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    private final String USER_FILED_CSS = "[name=email]";
    private final String PASSWORD_FILED_XPATH = "//*[@name='password']";
    private final String ERROR_MESSAGE = "//small";

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
        $x(ERROR_MESSAGE).shouldHave(Condition.text(error));
    }

    public String getErrorMessage() {
        return $x(ERROR_MESSAGE).text();
    }
}
