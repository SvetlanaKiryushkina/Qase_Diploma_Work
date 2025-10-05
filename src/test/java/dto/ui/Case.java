package dto.ui;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Case {

    String title;
    String status;
    String suite;
    String severity;
    String priority;
    String type;
    String layer;
    String isFlaky;
    String behavior;
    String automationStatus;
    String toBeAutomated;
    String mutedCase;

    public Case(String title, String status, String suite, String severity,
                String priority, String type, String layer, String isFlaky,
                String behavior, String automationStatus, String toBeAutomated, String mutedCase) {
        this.title = title;
        this.status = status;
        this.suite = suite;
        this.severity = severity;
        this.priority = priority;
        this.type = type;
        this.layer = layer;
        this.isFlaky = isFlaky;
        this.behavior = behavior;
        this.automationStatus = automationStatus;
        this.toBeAutomated = toBeAutomated;
        this.mutedCase = mutedCase;
    }
}
