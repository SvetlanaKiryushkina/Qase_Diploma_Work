package wrappers;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Log4j2
public class TextArea {

    private final String TEXTAREA = "//label[text()='%s']/ancestor::div//textarea";
    String label;

    public TextArea(String label) {
        this.label = label;
    }

    @Step("Clear and write the text in TextArea")
    public void write(String text) {
        $x((String.format(TEXTAREA, label))).clear();
        $x((String.format(TEXTAREA, label))).setValue(text);
    }
}
