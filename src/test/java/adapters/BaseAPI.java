package adapters;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import utils.PropertyReader;

import static io.restassured.RestAssured.given;

public class BaseAPI {

    protected final Gson gson;
    private final String token = System.getProperty("API_TOKEN", PropertyReader.getProperty("API_TOKEN"));
    private final String BASE_URI = System.getProperty("BASE_URI", PropertyReader.getProperty("BASE_URI"));
    private final RequestSpecification spec;

    public BaseAPI() {
        this.gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();

        this.spec = given()
                .contentType(ContentType.JSON)
                .header("Token", token)
                .log().all();
    }

    public Gson getGson() {
        return gson;
    }

    public RequestSpecification getSpec() {
        return spec;
    }
}
