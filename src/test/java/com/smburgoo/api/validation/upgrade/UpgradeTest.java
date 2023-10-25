
package com.smburgoo.api.validation.upgrade;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smburgoo.api.validation.config.Configuration;
import com.smburgoo.api.validation.petstore.User;
import com.smburgoo.api.validation.upgrade.models.BorrowerApiCreateRequest;
import com.smburgoo.api.validation.upgrade.models.BorrowerApiResponse;
import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static com.smburgoo.api.validation.petstore.PetstoreUtils.generateRandomTestUser;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.head;

public class UpgradeTest {
    private static Configuration config;
    private static String baseURI;
    private static String basePath;
    private static int port;

    static Map<String,String> postHeaders = new HashMap<>();


    static User testUser;

    static ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    @BeforeAll
    public static void setup() {
        config = new Configuration();
        config.setBaseURI("https://credapi.credify.tech/api/brfunnelorch/v2/resume/byLeadSecret");
        config.setBasePath("");

        baseURI = config.getBaseURI();
        basePath = config.getBasePath();
        port = config.getPort();

        postHeaders.put("Content-type", "application/json");
        postHeaders.put("x-cf-source-id", "coding-challenge-smburgoo");
        postHeaders.put("x-cf-corr-id", UUID.randomUUID().toString());


/*
        RestAssured.useRelaxedHTTPSValidation();
*/
    }

    // TODO this is failing because of unknown properties of the response
       //  this is GOOD because it means our test is unaware of potentially important data
    @Test
    public void postCreateBorrowerFlow() throws JsonProcessingException {
        BorrowerApiCreateRequest borrowerApiCreateRequest = new BorrowerApiCreateRequest();
        borrowerApiCreateRequest.setLoanAppUuid("b8096ec7-2150-405f-84f5-ae99864b3e96");
        borrowerApiCreateRequest.setSkipSideEffects(true);

        String testRequestDataJson = mapper.writeValueAsString(borrowerApiCreateRequest);
        System.out.println("attempting to create the following borrower: " + testRequestDataJson);
        Response response = given()
                .headers(postHeaders)
                .and()
                .body(testRequestDataJson)
                .when()
                .post(baseURI)
                .then()
                .log().ifValidationFails(LogDetail.BODY).statusCode(200)
                .extract().response();

        BorrowerApiResponse borrowerApiResponse = response.as(BorrowerApiResponse.class);

        System.out.println(borrowerApiResponse.toString());

        Assertions.assertEquals(200, response.statusCode(), "Unexpected status code");
        // todo loan type enum
        Assertions.assertEquals("PERSONAL_LOAN", borrowerApiResponse.getLoanAppResumptionInfo().getProductType());
    }

    @Test
    public void postCreateBorrowerFlowShouldRespondWith404_Given_UnknownLoanAppUuid() throws JsonProcessingException {
        BorrowerApiCreateRequest borrowerApiCreateRequest = new BorrowerApiCreateRequest();
        borrowerApiCreateRequest.setLoanAppUuid(UUID.randomUUID().toString());
        borrowerApiCreateRequest.setSkipSideEffects(true);

        String testRequestDataJson = mapper.writeValueAsString(borrowerApiCreateRequest);
        System.out.println("attempting to create the following borrower: " + testRequestDataJson);
        Response response = given()
                .headers(postHeaders)
                .and()
                .body(testRequestDataJson)
                .when()
                .post(baseURI)
                .then()
                .log().ifValidationFails(LogDetail.BODY).statusCode(404)
                .extract().response();

        Assertions.assertEquals(404, response.statusCode(), "Unexpected status code");
    }

}