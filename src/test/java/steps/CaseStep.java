package steps;

import dto.ui.Case;
import pages.CasePage;

public class CaseStep {

    LoginStep loginStep = new LoginStep();
    CasePage casePage = new CasePage();

    public void createCase(Case testCase) {
        casePage.openPageTestCreate()
                .fillForm(testCase);
        casePage.clickSave();
        casePage.getMessageCreate();
    }
}
