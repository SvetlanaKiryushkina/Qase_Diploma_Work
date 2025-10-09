package dto.api.models.caseAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class CaseDetails {
    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("result")
    @Expose
    private ResultForCase result;
}
