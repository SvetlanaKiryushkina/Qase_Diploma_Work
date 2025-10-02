package dto.ui;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Case {

    String title;
    String status;
    String description;
    String suite;
    String severity;
    String priority;
    String type;
    String layer;
    String isFlaky;
    String milestone;
    String behavior;
    String automationStatus;
    String toBeAutomated;
    String mutedCase;

    public Case(String title, String status, String description, String suite, String severity,
                String priority, String type, String layer, String isFlaky, String milestone,
                String behavior, String automationStatus, String toBeAutomated, String mutedCase) {
        this.title = title;
        this.status = status;
        this.description = description;
        this.suite = suite;
        this.severity = severity;
        this.priority = priority;
        this.type = type;
        this.layer = layer;
        this.isFlaky = isFlaky;
        this.milestone = milestone;
        this.behavior = behavior;
        this.automationStatus = automationStatus;
        this.toBeAutomated = toBeAutomated;
        this.mutedCase = mutedCase;
    }

    public String getTitle() {
        return title;
    }

    public String getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    public String getSuite() {
        return suite;
    }

    public String getSeverity() {
        return severity;
    }

    public String getPriority() {
        return priority;
    }

    public String getType() {
        return type;
    }

    public String getLayer() {
        return layer;
    }

    public String getIsFlaky() {
        return isFlaky;
    }

    public String getMilestone() {
        return milestone;
    }

    public String getBehavior() {
        return behavior;
    }

    public String getAutomationStatus() {
        return automationStatus;
    }

    public String getToBeAutomated() {
        return toBeAutomated;
    }

    public String getMutedCase() {
        return mutedCase;
    }
}
