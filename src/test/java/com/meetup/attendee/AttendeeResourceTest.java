package com.meetup.attendee;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class AttendeeResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
                .when().get("/attendee/hello")
                .then()
                .statusCode(200)
                .body(is("Hello Meetup"));
    }

}