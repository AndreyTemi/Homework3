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

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static specs.CreatedSpec.*;

@Tag("api_test")
public class RestApiLombokTests {

    @Test
    @DisplayName("Запрос списка пользователей")
    void lombokListUsersTest () {

        LombokListUsersRs response = step("Запрос", () ->  given(listUserRequestSpec)
                .when()
                .get()
                .then()
                .spec(listUserResponseSpec)
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
               given(updateUsersRequestSpec)
                .body(lombokUpdateUsersRq)
                .when()
                .put()
                .then()
                .spec(updateUsersResponseSpec)
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
                given(registerUnsuccessfulRequestSpec)
                .body(lombokRegisterUnsuccessfulRq)
                .when()
                .post()
                .then()
                        .spec(registerUnsuccessfulResponseSpec)
                .extract().as(LombokRegisterUnsuccessfulRs.class));

        step("Проверка ответа", () ->
                assertEquals("error", "error"));

    }
}
