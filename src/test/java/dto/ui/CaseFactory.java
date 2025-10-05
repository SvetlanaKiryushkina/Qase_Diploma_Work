package dto.ui;

import com.github.javafaker.Faker;

import static java.util.Objects.requireNonNullElse;

public class CaseFactory {

    public static Case getTestCase(String title, String status, String suite, String severity, String priority,
                                   String type, String layer, String isFlaky,
                                   String behavior, String automationStatus, String toBeAutomated,
                                   String mutedCase) {
        Faker faker = new Faker();
        // Значения по умолчанию
        String defaultTitle = faker.lorem().sentence(4);
        String defaultStatus = "Draft";
        String defaultSuite = "Test cases without suite";
        String defaultSeverity = "Normal";
        String defaultPriority = "Medium";
        String defaultType = "Functional";
        String defaultLayer = "E2E";
        String defaultIsFlaky = "No";
        String defaultBehavior = "Positive";
        String defaultAutomationStatus = "Automated";
        return new Case(
                requireNonNullElse(title, defaultTitle),
                requireNonNullElse(status, defaultStatus),
                requireNonNullElse(suite, defaultSuite),
                requireNonNullElse(severity, defaultSeverity),
                requireNonNullElse(priority, defaultPriority),
                requireNonNullElse(type, defaultType),
                requireNonNullElse(layer, defaultLayer),
                requireNonNullElse(isFlaky, defaultIsFlaky),
                requireNonNullElse(behavior, defaultBehavior),
                requireNonNullElse(automationStatus, defaultAutomationStatus),
                toBeAutomated,
                mutedCase
        );
    }
}
