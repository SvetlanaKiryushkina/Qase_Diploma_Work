package dto.api.models.caseAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Response {

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("errors")
    @Expose
    private Errors errors;
}
