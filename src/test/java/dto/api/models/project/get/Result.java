package dto.api.models.project.get;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Result {
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("filtered")
    @Expose
    private Integer filtered;
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("entities")
    @Expose
    private List<Project> entities = new ArrayList<Project>();
}
