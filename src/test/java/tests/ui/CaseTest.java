package tests.ui;

import dto.ui.Case;
import dto.ui.CaseFactory;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CaseTest extends BaseTest {

    Case testCase = CaseFactory.getTestCase("Для удаления", null, null, null, null,
            null, null, null, null, null, "", "");
    Case testCaseDefault = CaseFactory.getTestCase(null, null, null, null, null,
            null, null, null, null, null, "", "");

    @Test(testName = "Создание теста в действующем проекте",
            description = "Создание теста в действующем проекте")
    public void checkCreateCase() {
        projectStep.openProject(user, password, "ShareLane Test");
        caseStep.createCase(testCase);
    }

    @Test(testName = "Проверка сообщения о создании тест-кейса",
            description = "Проверка сообщения о создании тест-кейса")
    @Description("Проверка сообщения о создании тест-кейса")
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
    public void checkDeleteCase() {
        projectStep.openProject(user, password, "ShareLane Test");
        casePage.checkBox("Для удаления");
        casePage.deleteCase();
        assertEquals(casePage.getMessageDelete(), "1 test case was successfully deleted");
    }
}
