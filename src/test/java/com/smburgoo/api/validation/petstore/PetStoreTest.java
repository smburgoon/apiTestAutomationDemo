/*
 * MIT License
 *
 * Copyright (c) 2023 Shane Burgoon
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.smburgoo.api.validation.petstore;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smburgoo.api.validation.config.ConfigMgr;
import com.smburgoo.api.validation.config.Configuration;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.smburgoo.api.validation.petstore.PetstoreUtils.generateRandomTestUser;
import static io.restassured.RestAssured.given;

public class PetStoreTest {
    private static Configuration config;
    private static String baseURI;
    private static String basePath;
    private static int port;

    ObjectMapper mapper = new ObjectMapper();

    /*
    "username": "smburgoo",
  "firstName": "shane",
  "lastName": "burgoon",
  "email": "smburgoo@gmail.com",
  "password": "CorrectHorseBatteryStaple",
  "phone": "8888888888",
  "userStatus": 0
     */
    private static String requestBody = "{\n" +
            "  \"username\": \"foo\",\n" +
            "  \"firstName\": \"bar\",\n" +
            "  \"lastName\": \"bar\",\n" +
            "  \"email\": \"bar\",\n" +
            "  \"password\": \"bar\",\n" +
            "  \"phone\": \"bar\",\n" +
            "  \"userStatus\": 1 \n}";

    @BeforeAll
    public static void setup() {
        config = new Configuration();

        baseURI = config.getBaseURI();
        basePath = config.getBasePath();
        port = config.getPort();

        RestAssured.useRelaxedHTTPSValidation();
    }

    @Test
    public void postCreateUser() throws JsonProcessingException {
        User testUser = generateRandomTestUser();
        String testUserJson = mapper.writeValueAsString(testUser);
        System.out.println("attempting to create the following user: " + testUserJson);
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(testUserJson)
                .when()
                .post("https://petstore.swagger.io/v2/user")
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.statusCode(), "Unexpected status code");
        Assertions.assertEquals(200, response.jsonPath().getInt("code"), "");
        Assertions.assertEquals("unknown", response.jsonPath().getString("type"));
//        Assertions.assertEquals("1", response.jsonPath().getString("message"));
    }

    @Test
    public void getUser() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("https://petstore.swagger.io/v2/user/smburgoo")
                .then()
                .extract().response();

//        Assertions.assertEquals(200, response.statusCode());
//        Assertions.assertEquals("qui est esse", response.jsonPath().getString("title[1]"));
    }
}