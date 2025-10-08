package dto.api.models.project.get;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Runs {
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("active")
    @Expose
    private Integer active;
}
