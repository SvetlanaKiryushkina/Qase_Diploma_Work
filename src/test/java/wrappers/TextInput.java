package wrappers;

import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$x;

@Log4j2
public class TextInput {

    private final String INPUT_TEXT = "//label[text()='%s']/../..//input";
    private final String INPUT_EDIT = "//*[@id='modals']/dialog/div/div[2]/div[1]/div[1]/div/div[5]/div/div/div/div/div/div[2]/div/div[2]/div/div/p";
    String label;

    public TextInput(String label) {
        this.label = label;
    }

    public void write(String text) {
        log.info("Writing {} in to {}", text, label);
        $x((String.format(INPUT_TEXT, label))).clear();
        $x((String.format(INPUT_TEXT, label))).setValue(text);
    }

    public void writeEdit(String text) {
        $x(INPUT_EDIT).setValue(text);
    }
}
