package dto.api.models.caseAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class ResultForCase {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("position")
    @Expose
    private Integer position;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("preconditions")
    @Expose
    private String preconditions;
    @SerializedName("postconditions")
    @Expose
    private String postconditions;
    @SerializedName("severity")
    @Expose
    private Integer severity;
    @SerializedName("priority")
    @Expose
    private Integer priority;
    @SerializedName("type")
    @Expose
    private Integer type;
    @SerializedName("layer")
    @Expose
    private Integer layer;
    @SerializedName("is_flaky")
    @Expose
    private Integer isFlaky;
    @SerializedName("is_muted")
    @Expose
    private Boolean isMuted;
    @SerializedName("behavior")
    @Expose
    private Integer behavior;
    @SerializedName("automation")
    @Expose
    private Integer automation;
    @SerializedName("isManual")
    @Expose
    private Boolean isManual;
    @SerializedName("isToBeAutomated")
    @Expose
    private Boolean isToBeAutomated;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("milestone_id")
    @Expose
    private Integer milestoneId;
    @SerializedName("suite_id")
    @Expose
    private Integer suiteId;
    @SerializedName("links")
    @Expose
    private List<Object> links;
    @SerializedName("custom_fields")
    @Expose
    private List<Object> customFields;
    @SerializedName("attachments")
    @Expose
    private List<Object> attachments;
    @SerializedName("steps_type")
    @Expose
    private Object stepsType;
    @SerializedName("steps")
    @Expose
    private List<Object> steps;
    @SerializedName("params")
    @Expose
    private List<Object> params;
    @SerializedName("parameters")
    @Expose
    private List<Object> parameters;
    @SerializedName("member_id")
    @Expose
    private Integer memberId;
    @SerializedName("author_id")
    @Expose
    private Integer authorId;
    @SerializedName("tags")
    @Expose
    private List<Object> tags;
    @SerializedName("deleted")
    @Expose
    private Object deleted;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("updated")
    @Expose
    private String updated;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
}
