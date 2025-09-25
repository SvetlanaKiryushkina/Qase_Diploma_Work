package dto.api.adapters;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class BaseAPI {

    public static final String BASE_URI = "https://api.qase.io/v1/";
    private static final String TOKEN = "cd64f013da44fc604c7db1f0e70206f4007cb976acec1719029777993566a275";

    //String token = System.getProperty("TOKEN",PropertyReader.getProperty("TOKEN"));

    public static Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()//мы создаем экземпляр библиотеки и
            // исключать поля у которых нет анатации @Expose
            .create();

    public static RequestSpecification spec = given()
            .contentType(ContentType.JSON)
            .header("Token", TOKEN)
            .log().all();
}
