package dto.api.models.caseAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateCaseRq {

    @SerializedName("title")
    @Expose
    private String title;
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
    @SerializedName("behavior")
    @Expose
    private Integer behavior;
    @SerializedName("automation")
    @Expose
    private Integer automation;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("postconditions")
    @Expose
    private String postconditions;
    @SerializedName("preconditions")
    @Expose
    private String preconditions;
    @SerializedName("suite_id")
    @Expose
    private Integer suiteId;
}
