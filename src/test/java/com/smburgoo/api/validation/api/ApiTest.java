
package com.smburgoo.api.validation.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smburgoo.api.validation.config.Configuration;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.smburgoo.api.validation.api.ApiUtils.generateTicket;
import static io.restassured.RestAssured.given;

public class ApiTest {
    private static Configuration config; // TODO implement against ConfigMgr class to manage source of the configuration, such as AWS S3, local properties files, etc

    private static String baseURI;
    private static String basePath;
    private static int port;

    static Ticket testTicket;

    static ObjectMapper mapper = new ObjectMapper();

    @BeforeAll
    public static void setup() {

        // TODO this configuration should live somewhere outside of the code, probably
          // hard code config for purposes of this test
        config = new Configuration();
        config.setBaseURI("http://localhost:4200/api/RequestForm");


        baseURI = config.getBaseURI();
        basePath = config.getBasePath();
        port = config.getPort();

        RestAssured.useRelaxedHTTPSValidation();
    }

    @Test
    public void postCreateTicket() throws JsonProcessingException {
        testTicket = generateTicket();
        String testTicketJson = mapper.writeValueAsString(testTicket);
        System.out.println("attempting to create the following ticket: " + testTicketJson);
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(testTicketJson)
                .when()
                .post(baseURI)
                .then()
                .extract().response();

        System.out.println("ticket creation response" + response.getHeaders().toString());

        Assertions.assertEquals(200, response.statusCode(), "Unexpected status code");

    }

    // validate getting a known existing ticket works (by ID)
    /*
        should contain known field content
        can store as json data alongside tests for each case of known users
     */
    @Test
    public void getKnownTicketExpectingSuccess() {
        Ticket knownTicket = new Ticket();
        knownTicket.setTitle("knownTicket");
        knownTicket.setDescription("knownDescription");
        knownTicket.setDateTime("2024-02-14T05:00:00.000Z");

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("http://localhost:4200/api/RequestForm/" + "92a52663-0af2-417c-956b-ec401feb185c")
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals(knownTicket.getTitle(), response.jsonPath().getString("title"));
        Assertions.assertEquals(knownTicket.getDescription(), response.jsonPath().getString("description"));
        Assertions.assertEquals(knownTicket.getDateTime(), response.jsonPath().getString("dateTime"));
        Assertions.assertEquals(knownTicket.getTags().toString(), response.jsonPath().getString("tags"));
    }

    @Test
    public void getNonexistentTicketExpectingNotFound() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("http://localhost:4200/api/RequestForm/" + "92a52622-0af2-417c-956b-ec401feb185c")
                .then()
                .extract().response();

        Assertions.assertEquals(404, response.statusCode());
    }

    @Test
    public void putUpdateTicketHappyPath() throws JsonProcessingException {
        Ticket updateTicket = new Ticket();
        updateTicket.setTitle("knownTicket");
        updateTicket.setDescription("knownDescription");
        updateTicket.setDateTime("2024-02-14T05:00:00.000Z");

        String knownTicketId = "92a52663-0af2-417c-956b-ec401feb185c";

        String testTicketJson = mapper.writeValueAsString(updateTicket);
        System.out.println("attempting to update the following ticket: " + testTicketJson);

        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(testTicketJson)
                .when()
                .put(baseURI + "/" + knownTicketId)
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.statusCode());
    }

    @Test
    public void putUpdateTicketUnhappyPath() throws JsonProcessingException {
        Ticket updateTicket = new Ticket();
        updateTicket.setTitle("knownTicket");
        updateTicket.setDescription("knownDescription");
        updateTicket.setDateTime("invalid");

        String knownTicketId = "92a52663-0af2-417c-956b-ec401feb185c";

        String testTicketJson = mapper.writeValueAsString(updateTicket);
        System.out.println("attempting to update the following ticket: " + testTicketJson);

        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(testTicketJson)
                .when()
                .put(baseURI + "/" + knownTicketId)
                .then()
                .extract().response();

        Assertions.assertEquals(400, response.statusCode());
    }

    @Test
    public void deleteExistingTicketExpectingSuccess() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .delete("http://localhost:4200/api/RequestForm/" + "92a52663-0af2-417c-956b-ec401feb185c")
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.statusCode());
    }

    @Test
    public void deleteNonexistentTicketExpectingNotFound() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .delete("http://localhost:4200/api/RequestForm/" + "92a52622-0af2-417c-956b-ec401feb185c")
                .then()
                .extract().response();

        Assertions.assertEquals(404, response.statusCode());
    }

}