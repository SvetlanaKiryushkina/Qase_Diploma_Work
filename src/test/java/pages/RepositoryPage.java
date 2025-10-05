package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RepositoryPage {

    private final String CREATE_TEST_BTN_XPATH = "//*[@id='create-case-button']",
            PAGE_TITLE_TEXT = "New test",
            SUITE_CREATE_BTN = "create-suite-button",
            CASE_CREATE_BTN = "create-case-button",
            ADD_FILTER_BTN_XPATH = "//button[@aria-label = 'Add filter']",
            INPUT_SEARCH_XPATH = "//*[@aria-label = 'Search']",
            FILTER_BTN_CSS = "svg.svg-inline";

    @Step("Переход на страницу создания тест-кейса")
    public CasePage openCreateTestCase() {
        open("case/TEST/create");
        return new CasePage();
    }

    public CasePage clickCreateTestButton() {
        $x(CREATE_TEST_BTN_XPATH).click();
        return new CasePage();
    }

    public RepositoryPage isOpenedPage() {
        $(byText(PAGE_TITLE_TEXT)).shouldBe(Condition.visible);
        return this;
    }

    @Step("Выбор теста по фильтру")
    public RepositoryPage addFilter() {
        $(FILTER_BTN_CSS).click();
        return this;
    }
}
