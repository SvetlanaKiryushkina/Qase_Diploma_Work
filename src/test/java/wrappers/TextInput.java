package wrappers;

import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static groovy.xml.dom.DOMCategory.setValue;

@Log4j2
public class TextInput {

    String label;

    private final String INPUT_TEXT = "//label[text()='%s']/../..//input";

    public TextInput(String label) {
        this.label = label;
    }

    public void write(String text) {
        log.info("Writing {} in to {}", text, label);
        $x((String.format(INPUT_TEXT, label))).clear();
        $x((String.format(INPUT_TEXT, label))).setValue(text);
    }
}
