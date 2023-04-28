package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.*;
import static io.restassured.http.ContentType.JSON;

public class CreatedSpec {

    public static RequestSpecification createdRequestSpec = with()
            .filter(withCustomTemplates())
            .log().uri()
            .contentType(JSON)
            .baseUri("https://reqres.in")
            .basePath("/api/users");

    public static ResponseSpecification createdResponseSpec = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(201)
            .build();
}
