package by.aston.bakumenko.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PostmanEchoTest {

    @BeforeAll
    public static void setUpBaseUri() {
        RestAssured.baseURI = "https://postman-echo.com";
    }

    private void verifyCommonResponseHeaders(Response response) {
        response.then()
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.accept-encoding", equalTo("gzip,deflate"));
    }

    @Test
    @Description("Этот тест проверяет, что GET-запрос к Postman Echo возвращает ожидаемые данные в теле ответа.")
    public void getRequest() {
        Response response = given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get("/get")
                .then()
                .log().all()
                .statusCode(200)
                .body("args", hasEntry("foo1", "bar1"))
                .body("args", hasEntry("foo2", "bar2"))
                .body("headers", hasKey("x-request-start"))
                .body("headers", hasKey("x-amzn-trace-id"))
                .body("headers.postman-token", nullValue())
                .body("url", is("https://postman-echo.com/get?foo1=bar1&foo2=bar2"))
                .extract().response();
        verifyCommonResponseHeaders(response);
    }

    @Test
    @Description("Тест POST-запроса с текстовым телом к Postman Echo")
    public void PostRawText() {
        String response = "This is expected to be sent back as part of response body.";
        Response postResponse = given()
                .contentType("text/plain")
                .body(response)
                .when()
                .post("/post")
                .then()
                .log().all()
                .statusCode(200)
                .body("data", equalTo(response))
                .extract().response();
        verifyCommonResponseHeaders(postResponse);
    }

    @Test
    @Description("Тест проверки PATCH-запроса с текстовым телом к сервису Postman Echo.")
    public void PatchRequest() {
        String response = "This is expected to be sent back as part of response body.";
        Response patchResponse = given()
                .contentType("text/plain; charset=utf-8")
                .body(response)
                .when()
                .patch("/patch")
                .then()
                .log().all()
                .statusCode(200)
                .body("data", equalTo(response))
                .body("headers.x-request-start", notNullValue())
                .body("headers.x-amzn-trace-id", notNullValue())
                .extract().response();
        verifyCommonResponseHeaders(patchResponse);
    }

    @Test
    @Description("Тест проверки DELETE-запроса с текстовым телом к сервису Postman Echo.")
    public void DeleteRequest() {
        String response = "This is expected to be sent back as part of response body.";
        Response deleteResponse = given()
                .contentType("text/plain")
                .body(response)
                .when()
                .delete("/delete")
                .then()
                .log().all()
                .statusCode(200)
                .body("data", equalTo(response))
                .body("headers.x-request-start", notNullValue())
                .body("headers.x-amzn-trace-id", notNullValue())
                .extract().response();
        verifyCommonResponseHeaders(deleteResponse);
    }
}