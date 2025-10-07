package steps;

import dto.ui.Case;
import lombok.extern.log4j.Log4j2;
import pages.CasePage;

@Log4j2
public class CaseStep {

    CasePage casePage = new CasePage();

    public void createCase(Case testCase) {
        log.info("Создание тест-кейса");
        casePage.openPageTestCreate()
                .fillFormCreate(testCase);
        casePage.clickSave();
        log.info("Форма создания кейса успешно сохранена");
        casePage.getMessageCreate();
    }
}
