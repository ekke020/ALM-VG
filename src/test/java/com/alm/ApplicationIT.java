package com.alm;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static io.restassured.RestAssured.when;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ApplicationIT {

    private final static String WELCOME_MESSAGE = """
            <h1>Welcome to a simple calculator...</h1>
            <div>Go to /math/add?x={}&y={} for addition</div>
            <div>Go to /math/sub?x={}&y={} for subtraction</div>
            """;
    private final static String ADDITION_RESULT = "<b>4 + 5 = 9</b>";
    private final static String SUBTRACTION_RESULT = "<b>10 - 5 = 5</b>";

    @BeforeEach
    public void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
    }

    @Test
    public void validates_hello_message() {
        Response response = when().get().then()
                .statusCode(200).extract().response();
        String result = response.getBody().asString();
        assertEquals(WELCOME_MESSAGE, result);

        Response response2 = when().get("/math/add?x=4&y=5").then()
                .statusCode(200).extract().response();
        String result2 = response2.getBody().asString();

        assertEquals(ADDITION_RESULT, result2);

        Response response3 = when().get("/math/sub?x=10&y=5").then()
                .statusCode(200).extract().response();
        String result3 = response3.getBody().asString();

        assertEquals(SUBTRACTION_RESULT, result3);
    }
}
