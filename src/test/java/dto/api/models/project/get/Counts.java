package dto.api.models.project.get;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Counts {
    @SerializedName("cases")
    @Expose
    private Integer cases;
    @SerializedName("suites")
    @Expose
    private Integer suites;
    @SerializedName("milestones")
    @Expose
    private Integer milestones;
    @SerializedName("runs")
    @Expose
    private Runs runs;
    @SerializedName("defects")
    @Expose
    private Defects defects;
}
