package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ProjectNewPage {

    private final String CREATE_TEST_BUTTON_XPATH = "//*[@id=\"create-case-button\"]";
    private final String PAGE_TITLE_TEXT = "Create test case";

    @Step("Переход на страницу создания тест-кейса")
    public CreateTestCasePage openCreateTestCase(){
        open("case/TEST/create");
        return new CreateTestCasePage();
    }

    public CreateTestCasePage clickCreateTestButton(){
        $x(CREATE_TEST_BUTTON_XPATH).click();
        return new CreateTestCasePage();
    }

    public ProjectNewPage isOpenedPage(){
        $(byText(PAGE_TITLE_TEXT)).shouldBe(Condition.visible);
        return this;
    }
}
