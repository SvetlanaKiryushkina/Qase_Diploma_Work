package wrappers;

public class RadioButton {

    private final String RADIO_BUTTON = "//label[contains(., '%s')]//input[@type='radio']";

    public RadioButton() {
    }

    public String getRadioButtonXPathByLabel(String labelText) {
        return String.format(RADIO_BUTTON, labelText);
    }
}
