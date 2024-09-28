package tests.api;

import io.qameta.allure.restassured.AllureRestAssured;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.api.PojoModel.CreatedUsers.CreatedUsersRs;
import tests.api.PojoModel.CreatedUsers.CreatedUsersRq;
import tests.api.PojoModel.ListUsers.ListUsersRs;
import tests.api.PojoModel.UpdateUsers.UpdateUsersRq;
import tests.api.PojoModel.UpdateUsers.UpdateUsersRs;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("api_test")
public class RestApiPojoTests {

    @Test
    @DisplayName("Запрос списка пользователей")
    void listUsersTest () {
        Integer expectedTotal = 12;

        ListUsersRs response = given()
                .filter(new AllureRestAssured())
                .log().uri()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().as(ListUsersRs.class);

        assertEquals(12, response.getTotal());
    }

    @Test
    @DisplayName("Создание пользователя")
    void createdUsersTest () {

        CreatedUsersRq createdUsersRq = new CreatedUsersRq();
        createdUsersRq.setName("morpheus");
        createdUsersRq.setJob("leader");

        CreatedUsersRs response = given()
                .filter(new AllureRestAssured())
                .log().uri()
                .body(createdUsersRq)
                .contentType(JSON)
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .log().status()
                .log().body()
                .statusCode(201)
                .extract().as(CreatedUsersRs.class);

        assertEquals("morpheus", response.getName());
        assertEquals("leader", response.getJob());
    }

    @Test
    @DisplayName("Изменение пользователя")
    void updateUsersTest () {

        UpdateUsersRq updateUsersRq = new UpdateUsersRq();
        updateUsersRq.setName("morpheus");
        updateUsersRq.setJob("zion resident");

       UpdateUsersRs response = given()
               .filter(new AllureRestAssured())
                .log().uri()
                .body(updateUsersRq)
                .contentType(JSON)
                .when()
                .put("https://reqres.in/api/users/2")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().as(UpdateUsersRs.class);

        assertEquals("morpheus", response.getName());
        assertEquals("zion resident", response.getJob());
    }

}
