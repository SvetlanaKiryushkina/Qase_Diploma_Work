package tests.ui;

import dto.ui.Case;
import dto.ui.CaseFactory;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CaseTest extends BaseTest {

    Case testCase = CaseFactory.getTestCase("Для удаления", null, null, null, null,
            null, null, null, null, null, "", "");
    Case testCaseDefault = CaseFactory.getTestCase(null, null, null, null, null,
            null, null, null, null, null, "", "");

    @Test(testName = "Создание теста в действующем проекте",
            description = "Создание теста в действующем проекте")
    @Description("Создание теста в действующем проекте")
    @Severity(SeverityLevel.CRITICAL)
    public void checkCreateCase() {
        projectStep.openProject(user, password, "ShareLane Test");
        caseStep.createCase(testCase);
    }

    @Test(testName = "Проверка сообщения о создании тест-кейса",
            description = "Проверка сообщения о создании тест-кейса")
    @Description("Проверка сообщения о создании тест-кейса")
    @Severity(SeverityLevel.NORMAL)
    public void checkVerificationMessage() {
        projectStep.openProject(user, password, "ShareLane Test");
        caseStep.createCase(testCaseDefault);
        casePage.getMessageCreate();
        assertEquals(casePage.getMessageCreate(), "Test case was created successfully!");
    }

    @Test(testName = "Проверка удаления тест-кейса",
            description = "Проверка удаления тест-кейса",
            dependsOnMethods = {"checkCreateCase"})
    @Description("Проверка удаления тест-кейса")
    @Severity(SeverityLevel.NORMAL)
    public void checkDeleteCase() {
        projectStep.openProject(user, password, "ShareLane Test");
        casePage.checkBox("Для удаления");
        casePage.deleteCase();
        assertEquals(casePage.getMessageDelete(), "1 test case was successfully deleted");
    }

    @Test(testName = "Изменение тест-кейса",
            description = "Изменение тест-кейса")
    @Description("Изменение тест-кейса")
    @Severity(SeverityLevel.CRITICAL)
    public void checkEditCase() {
        projectStep.openProject(user, password, "ShareLane Test");
        casePage.checkBox("Для редактирования");
        casePage.editCase();
        casePage.fillFormEdit("Изменение теста");
        casePage.clickUpdate();
        casePage.getMessageEdit();
    }
}
