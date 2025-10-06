package pages;

import com.codeborne.selenide.Condition;
import dto.ui.Case;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import wrappers.DropDown;
import wrappers.TextInput;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Log4j2
public class CasePage {

    private final String BUTTON_CREATE_TEST = "New test",
            TEXT_PAGE = "Create test case",
            BUTTON_SAVE_XPATH = "//*[@id='save-case']",
            MESSAGE_MODAL_FOR_CREATE = "//*[@id='modals']//span[contains(text(), 'Test case was created successfully')]",
            MESSAGE_MODAL_FOR_DELETE = "//span[contains(text(), 'test case was successfully deleted')]",
            MESSAGE_FOR_EDIT = "//*[@id='modals']//span[contains(text(), 'test case was successfully updated')]",
            CHECK_BOX_CASE = "//div[@data-suite-body-id and .//div[contains(text(), '%s')]]//input[@type='checkbox']",
            ICON_DELETE_XPATH = "//*[@aria-label='Delete']",
            ICON_EDIT_XPATH = "//*[@aria-label='Edit']",
            BUTTON_DELETE_XPATH = "//span[text()='Delete']",
            INPUT_FOR_DELETE_XPATH = "//input[@type='text' and @name='confirm']",
            BUTTON_UPDATE_XPATH = "//*[span='Update']/span/span";

    @Step("Открытие страницы создания тест-кейса")
    public CasePage openPageTestCreate() {
        $(byText(BUTTON_CREATE_TEST)).click();
        return this;
    }

    @Step("Проверка открытия страницы")
    public void isOpenedPage() {
        $(byText(TEXT_PAGE)).shouldBe(Condition.visible);
    }

    @Step("Заполнение формы создания тест-кейса")
    public void fillFormCreate(Case testCase) {
        log.info("Create New Test Case");
        new TextInput("Title").write(testCase.getTitle());
        new DropDown("Status").selectForNewCase(testCase.getStatus());
        new DropDown("Severity").selectForNewCase(testCase.getSeverity());
        new DropDown("Priority").selectForNewCase(testCase.getPriority());
        new DropDown("Type").selectForNewCase(testCase.getType());
        new DropDown("Layer").selectForNewCase(testCase.getLayer());
        new DropDown("Is flaky").selectForNewCase(testCase.getIsFlaky());
        new DropDown("Behavior").selectForNewCase(testCase.getBehavior());
        new DropDown("Automation status").selectForNewCase(testCase.getAutomationStatus());
    }

    @Step("Нажатие на кнопку Сохранить")
    public void clickSave() {
        $x(BUTTON_SAVE_XPATH).click();
    }

    public String getMessageCreate() {
        return $x(MESSAGE_MODAL_FOR_CREATE).text();
    }

    public String getMessageDelete() {
        return $x(MESSAGE_MODAL_FOR_DELETE).text();
    }

    public String getMessageEdit() {
        return $x(MESSAGE_FOR_EDIT).text();
    }

    @Step("Выбор тест-кейса из перечня")
    public void checkBox(String nameCase) {
        $x(String.format(CHECK_BOX_CASE, nameCase)).click();
    }

    @Step("Удаление тест-кейса")
    public void deleteCase() {
        $x(ICON_DELETE_XPATH).click();
        $x(INPUT_FOR_DELETE_XPATH).setValue("CONFIRM");
        $x(BUTTON_DELETE_XPATH).click();
    }

    @Step("Редактирование тест-кейса")
    public void editCase() {
        $x(ICON_EDIT_XPATH).click();

    }

    @Step("Заполнение формы изменения тест-кейса")
    public void fillFormEdit(String description) {
        log.info("Edit Test Case");
        new TextInput("Description").writeEdit(description);
    }

    @Step("Кнопка Изменить")
    public void clickUpdate() {
        $x(BUTTON_UPDATE_XPATH).click();
    }
}

