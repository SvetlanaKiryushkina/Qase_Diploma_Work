package adapters;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import utils.PropertyReader;

import static io.restassured.RestAssured.given;

public class BaseAPI {

    private final String TOKEN = System.getProperty("TOKEN", PropertyReader.getProperty("TOKEN"));
    protected final String BASE_URL = System.getProperty("BASE_URL", PropertyReader.getProperty("BASE_URL"));
    private final RequestSpecification spec;
    protected Gson gson;

    public BaseAPI() {
        this.gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();

        this.spec = given()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .header("Token", TOKEN)
                .log().all();
    }

    public RequestSpecification getSpec() {
        return spec;
    }
}
