package tests.api;

import io.qameta.allure.restassured.AllureRestAssured;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("api_test")
public class RestApiTests {

    @Test
    @DisplayName("Запрос списка пользователей")
    void listUsersTest () {
        Integer expectedTotal = 12;

        Integer actualTotal = given()
                .filter(new AllureRestAssured())
                .log().uri()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().path("total");

        assertEquals(expectedTotal, actualTotal);
    }

    @Test
    @DisplayName("Создание пользователя")
    void createdUsersTest () {
        String body = "{\"name\":\"morpheus\",\"job\":\"leader\"}";

        given()
                .filter(new AllureRestAssured())
                .log().uri()
                .body(body)
                .contentType(JSON)
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .log().status()
                .log().body()
                .statusCode(201)
                .body("name", is("morpheus"))
                .body("job", is("leader"));
    }

    @Test
    @DisplayName("Изменение пользователя")
    void updateUsersTest () {
        String body = "{\"name\":\"morpheus\",\"job\":\"zion resident\"}";

        given()
                .filter(new AllureRestAssured())
                .log().uri()
                .body(body)
                .contentType(JSON)
                .when()
                .put("https://reqres.in/api/users/2")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("name", is("morpheus"))
                .body("job", is("zion resident"));
    }

    @Test
    @DisplayName("Удаление пользователя")
    void deleteUsersTest () {

        given()
                .filter(new AllureRestAssured())
                .log().uri()
                .when()
                .delete("https://reqres.in/api/users/2")
                .then()
                .log().status()
                .log().body()
                .statusCode(204);
    }

    @Test
    @DisplayName("Неудачная регистрация")
    void registerUnsuccessfulTest () {
        String body = "{\"email\":\"sydney@fife\"}";

        given()
                .filter(new AllureRestAssured())
                .log().uri()
                .body(body)
                .contentType(JSON)
                .when()
                .post("https://reqres.in/api/register")
                .then()
                .log().status()
                .log().body()
                .statusCode(400)
                .body("error", is("Missing password"));
    }

    @Test
    @DisplayName("Проверка ответа по JSON Schema")
    void listResourceSchemaTest () {

        given()
                .filter(new AllureRestAssured())
                .log().uri()
                .when()
                .get("https://reqres.in/api/unknown")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("total", is(12))
                .body(matchesJsonSchemaInClasspath("Schemas/List_Resource_Schema.json"));
    }

}
