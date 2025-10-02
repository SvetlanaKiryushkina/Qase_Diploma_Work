package dto.ui;

import com.github.javafaker.Faker;

public class CaseFactory {

    static Faker faker = new Faker();

    public static Case getTestCase(String status, String suite, String severity, String priority,
                             String type, String layer, String isFlaky, String milestone,
                             String behavior, String automationStatus, String toBeAutomated,
                             String mutedCase){
        Faker faker = new Faker();
        return new Case(
                faker.lorem().sentence(4),
                status,
                faker.lorem().paragraph(),
                suite,
                severity,
                priority,
                type,
                layer,
                isFlaky,
                milestone,
                behavior,
                automationStatus,
                toBeAutomated,
                mutedCase
        );
    }

    public static Case fillInAllFieldsOfBasicCase() {
        return Case.builder()
                .title(faker.lorem().sentence(4))
                .status(faker.expression("Draft"))
                .description(faker.lorem().fixedString(20))
                .suite(faker.expression("Test cases without suite"))
                .type(faker.expression("Smoke"))
                .milestone(faker.expression("Not set"))
                .severity(faker.expression("Normal"))
                .layer(faker.expression("Not set"))
                .behavior(faker.expression("Positive"))
                .priority(faker.expression("High"))
                .isFlaky(faker.expression("No"))
                .automationStatus(faker.expression("Not automated"))
                .title(faker.hacker().verb())
                .build();
    }
}
