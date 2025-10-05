package adapters;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import utils.PropertyReader;

import static io.restassured.RestAssured.given;

public class BaseAPI {

    private final String TOKEN = System.getProperty("API_TOKEN", PropertyReader.getProperty("API_TOKEN"));
    private final String BASE_URI = System.getProperty("BASE_URI", PropertyReader.getProperty("BASE_URI"));
    private final RequestSpecification spec;
    protected Gson gson;

    public BaseAPI() {
        this.gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();

        this.spec = given()
                .contentType(ContentType.JSON)
                .header("Token", TOKEN)
                .log().all();
    }

    public RequestSpecification getSpec() {
        return spec;
    }
}
