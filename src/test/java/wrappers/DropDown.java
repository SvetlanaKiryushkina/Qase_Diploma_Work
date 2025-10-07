package wrappers;

import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$x;

@Log4j2
public class DropDown {

    private final String BUTTON_DROPDOWN = "//label[contains(text(),'%s')]/following-sibling::" +
            "div//div[@role='combobox']";
    private final String DROPDOWN_LIST = "//div[text()='%s']";
    private final String TEST = "//label[text()='Priority']/following-sibling::div//span";

    protected String label;

    public DropDown(String label) {
        this.label = label;
    }

    public void selectForNewCase(String option) {
        log.info("Click field {}", label);
        $x(String.format(BUTTON_DROPDOWN, label)).click();
        log.info("Set option '{}'", option);
        $x(String.format(DROPDOWN_LIST, option)).click();
    }

    public void selectForEditCase(String option) {
        log.info("Click field {}", label);
        $x(String.format(TEST, label)).click();
    }
}
