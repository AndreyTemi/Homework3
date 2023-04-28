package tests.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.api.LombokModel.CreatedUsers.LombokCreatedUsersRq;
import tests.api.LombokModel.CreatedUsers.LombokCreatedUsersRs;
import tests.api.LombokModel.ListUsers.LombokListUsersRs;
import tests.api.LombokModel.RegisterUnsuccessfulTest.LombokRegisterUnsuccessfulRq;
import tests.api.LombokModel.RegisterUnsuccessfulTest.LombokRegisterUnsuccessfulRs;
import tests.api.LombokModel.UpdateUsers.LombokUpdateUsersRq;
import tests.api.LombokModel.UpdateUsers.LombokUpdateUsersRs;
import static helpers.CustomAllureListener.withCustomTemplates;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static specs.CreatedSpec.createdRequestSpec;
import static specs.CreatedSpec.createdResponseSpec;

@Tag("api_test")
public class RestApiLombokTests {

    @Test
    @DisplayName("Запрос списка пользователей")
    void lombokListUsersTest () {

        LombokListUsersRs response = step("Запрос", () ->  given()
                .filter(withCustomTemplates())
                .log().uri()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().as(LombokListUsersRs.class));

        step("Проверка ответа", () ->
        assertEquals(12, response.getTotal()));
    }

    @Test
    @DisplayName("Создание пользователя")
    void lombokCreatedUsersTest () {

        LombokCreatedUsersRq lombokCreatedUsersRq = new LombokCreatedUsersRq();
        lombokCreatedUsersRq.setName("morpheus");
        lombokCreatedUsersRq.setJob("leader");

        LombokCreatedUsersRs response = step("Запрос", () ->
                given(createdRequestSpec)
                .body(lombokCreatedUsersRq)
                .when()
                .post()
                .then()
                        .spec(createdResponseSpec)
                .extract().as(LombokCreatedUsersRs.class));

        step("Проверка в ответе имени", () ->
                assertEquals("morpheus", response.getName()));
        step("Проверка в ответе работы", () ->
                assertEquals("leader", response.getJob()));
    }

    @Test
    @DisplayName("Изменение пользователя")
    void lombokUpdateUsersTest () {

        LombokUpdateUsersRq lombokUpdateUsersRq = new LombokUpdateUsersRq();
        lombokUpdateUsersRq.setName("morpheus");
        lombokUpdateUsersRq.setJob("zion resident");

       LombokUpdateUsersRs response = step("Запрос", () ->
               given()
               .filter(withCustomTemplates())
                .log().uri()
                .body(lombokUpdateUsersRq)
                .contentType(JSON)
                .when()
                .put("https://reqres.in/api/users/2")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().as(LombokUpdateUsersRs.class));
        step("Проверка в ответе имени", () ->
                assertEquals("morpheus", response.getName()));
        step("Проверка в ответе работы", () ->
                assertEquals("zion resident", response.getJob()));
    }

    @Test
    @DisplayName("Неудачная регистрация")
    void lombokRegisterUnsuccessfulTest () {

        LombokRegisterUnsuccessfulRq lombokRegisterUnsuccessfulRq = new LombokRegisterUnsuccessfulRq();
        lombokRegisterUnsuccessfulRq.setEmail("sydney@fife");

        step("Запрос", () ->
                given()
                .filter(withCustomTemplates())
                .log().uri()
                .body(lombokRegisterUnsuccessfulRq)
                .contentType(JSON)
                .when()
                .post("https://reqres.in/api/register")
                .then()
                .log().status()
                .log().body()
                .statusCode(400)
                .extract().as(LombokRegisterUnsuccessfulRs.class));

        step("Проверка ответа", () ->
                assertEquals("error", "error"));

    }
}
