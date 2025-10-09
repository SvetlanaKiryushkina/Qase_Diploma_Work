package dto.api.models.caseAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Result {

    @SerializedName("id")
    @Expose
    private Integer id;
}
