package dto.api.models.caseAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class Errors {

    @SerializedName("severity")
    @Expose
    private List<String> severity;
}
