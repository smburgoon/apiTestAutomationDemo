
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

    static User testUser;

    static ObjectMapper mapper = new ObjectMapper();

    @BeforeAll
    public static void setup() {
        config = new Configuration();

        baseURI = config.getBaseURI();
        basePath = config.getBasePath();
        port = config.getPort();

        RestAssured.useRelaxedHTTPSValidation();
    }

    @BeforeAll
    public static void postCreateUser() throws JsonProcessingException {
        testUser = generateRandomTestUser();
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
                .get("https://petstore.swagger.io/v2/user/" + testUser.getUsername())
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.statusCode());
//        Assertions.assertEquals("qui est esse", response.jsonPath().getString("title[1]"));
    }

//    @Test
//    public void getUserLogin() {
//
//    }

    @Test
    public void getSession() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .cookie("bm_sz=27998356B6428FA14943780085C504E0~YAAQBL7CF6LOaGCLAQAAhqoIaBUqX4euLpNtzuz+shsc+4rwsRLI1C/b/eH90gXvz0/ID2HfeDh6CUBQbhxz+WC0soOvpCHRJglRMGvsYKH/Yg7olzZE6SpO3b0jS6KTvnGIZ98FmPxjaEIRZ+cP4IvL2lKK0XrynkDurXbwAlTGgrA56fJkFMCL+jlxyW3k3+j2STO14WjRj9IMUbDbYmkk/oZqefg7va4N+YgEGfsNiafAJYMq5eRpv4LJAID5p1bR/ptOu/qWPLpas7wSOIl/4mtpptLWgPtVV9ZgtlrUKcqP~3421240~3552566; ras_cookie_uuid=19299a15-3e63-4d98-83e7-3035500fe449; ras_session_id=4f40ee2d-eff5-4c55-90b8-81c61768ea5e; ak_bmsc=991E65F732BF3FEE6546544DC6A6C736~000000000000000000000000000000~YAAQBL7CF8jOaGCLAQAACK4IaBWc9e15aQ/Sja5EymDotQfNmJn3LJZhUWQUkloXOIOwUL8GBtI6hxXDB5us7+1xUgv7hE76Yedozqz/7xET7RDMSicARET2SOI8LchiVEitVJnEVUxBjapZBwNi1yT2Yd5dzvc6R9K+LdxtTAbU4X9pGCD5tUU8ewvyOSwUU3X22MemJxxVarKC/BDHGnTryJ2DJMbqincpoSMK+3WsY2k7zIv+JhOTHc8Tey5nFKnqT3t9vr5w5S8A10QdTOF1Y3UfR78/USX/VXOyERDG+xBxbZMPGZwR8n/Kh4IoZ97El7JN38mk3uxtIsbkX5FA7GDAm+wz8Ngen28GfDD2KVVvgdL7dl3lXvVM8cgECmhx6J21nZf4bsZEpvrITn7rj+PdEB25TZE/QHIOrjV/GiJ3aeq2Uy2CTPdqCP/v39rVQfMDkg3+RpSSARRCmQM3MFqhc5d2plEyOzJMDX+vKqouaTQ2LecYYwA3Y4XAmDDXdRZ/AQxKsmejPfxNDcHunRxblhSFpPI=; impact_click_id=undefined; t-ip=1; tatari-session-cookie=bfe50f7a-7f2b-f06d-423b-da423066a3eb; IR_gbd=upgrade.com; _hp2_ses_props.710315446=%7B%22ts%22%3A1698257480762%2C%22d%22%3A%22www.upgrade.com%22%2C%22h%22%3A%22%2F%22%7D; _gid=GA1.2.1678708070.1698257481; _gcl_au=1.1.1444711722.1698257481; OptanonConsent=isGpcEnabled=0&datestamp=Wed+Oct+25+2023+14%3A11%3A23+GMT-0400+(Eastern+Daylight+Time)&version=202308.2.0&browserGpcFlag=0&isIABGlobal=false&hosts=&consentId=a8b48ab4-3258-4c11-8bb4-41b3753fe1d1&interactionCount=1&landingPath=https%3A%2F%2Fwww.upgrade.com%2F&groups=C0001%3A1%2CC0003%3A1%2CC0002%3A1%2CC0004%3A1; _hp2_props.710315446=%7B%22ras_cookie_uuid%22%3A%2219299a15-3e63-4d98-83e7-3035500fe449%22%7D; utag_main=v_id:018b6808ab8a0076a48d8dad9ad00506f001806700bd0$_sn:1$_se:2$_ss:0$_st:1698259284168$ses_id:1698257480587%3Bexp-session$_pn:2%3Bexp-session$dc_visit:1$dc_event:2%3Bexp-session$dc_region:us-east-1%3Bexp-session; IR_5676=1698257484431%7C0%7C1698257484431%7C%7C; _ga=GA1.1.1996970155.1698257481; fs_lua=1.1698257484523; fs_uid=#GDWG7#bfad0bfc-6a35-4510-9628-a4d34d1a67a4:b7499bb2-9c6b-40cb-a248-c452743351c0:1698257484523::1#a33a4ba7#/1729793484; _uetsid=e88a8fd0736111ee9b9c99f86bdca4c7; _uetvid=e88ace70736111eea7134d9d47759b2e; ras_properties={%22ras_action%22:%22landing_page%22%2C%22ras_device_v1%22:%22b7eb82a4cee834cd5d5f88e7f699ca05f5c256a142a60742db7a8836f892ea08%22%2C%22ras_page_url%22:%22https://www.upgrade.com/deposit/apply/account-email?pdc=DEP_CH_03%22%2C%22ras_timestamp%22:%22Wed%20Oct%2025%202023%22}; _hp2_id.710315446=%7B%22userId%22%3A%224736420420364508%22%2C%22pageviewId%22%3A%224959206914338418%22%2C%22sessionId%22%3A%225601287444072652%22%2C%22identity%22%3Anull%2C%22trackerVersion%22%3A%224.0%22%7D; _ga_E66J2PKJXL=GS1.1.1698257480.1.1.1698257535.0.0.0; device_token=eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.ewogICJ0eXBlIiA6IG51bGwsCiAgInV1aWQiIDogIjdiNmNiNDY3LWQ5MWQtNGQ4Zi04NzBiLTkyZTg1OWQ0YTZhZiIKfQ.U_gEum1FVaG0tuxNzi4SIwOWeiCfc1IzkrJiB-r6Zao3x7z0dW92ak7t7PnINOmjvylijxKqdBfeOBTMb9NexIPJ5wGR1Vogw110z4R8tHfn2xSYyhQ0yDF4Lpr87BaGKaDQ3iK5qRMxZZwkm6k6fM7xwpTHcqWM2E0tp7PeFHsRjGe5yBHvaRZifNNhIuf5nfRJ1vi9Qy_aIf6G4S1EZCFT0CY96cBZFYbsGM7DAMdOzv0y6fbnI0Pd1rxOcdQqm9mcPurLIUraRyKEQhvzfIriA6sW1S0bnsz__N_R9pYeLrR33CCkwYW8LbwM7Kzp-H4qQ1iglbQJAtglXFjUMg; access_token=eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJhcGlfY2xpZW50X2lkIjotMSwidXNlcl9uYW1lIjoic2hhbmUuYnVyZ29vbkBnbWFpbC5jb20iLCJhbXIiOltdLCJpc3MiOiJsb2dpbi1zcnZjIiwicmVzb3VyY2VzIjpbXSwidHlwZSI6ImFjY2Vzcy10b2tlbiIsImFsbF9mYWN0b3JfYXV0aGVudGljYXRlZCI6dHJ1ZSwiYXV0aG9yaXRpZXMiOlsiUk9MRV9CT1JST1dFUl9VU0VSIl0sImluaXRpYXRvcl90b2tlbiI6ImV5SmhiR2NpT2lKU1V6STFOaUlzSW5SNWNDSTZJa3BYVkNKOS5ld29nSUNKMGVYQmxJaUE2SUNKcGJtbDBhV0YwYjNJdGRHOXJaVzRpTEFvZ0lDSmhZMk5sYzNOVWIydGxia2xrSWlBNklDSTJPRGM1T1dObU1pMHdPVGt5TFRRME9EQXRPVFF4TnkxaVkyRmxOV0pqTlRneE9XVWlMQW9nSUNKaGNHbERiR2xsYm5SSlpDSWdPaUF0TVN3S0lDQWliRzluYVc1SlpDSWdPaUF5T1RZd016QTRNeXdLSUNBaVpYaHdhWEpoZEdsdmJpSWdPaUFpTWpBeU15MHhNUzB5TkZReE9Eb3hNam8wTkM0NU9UVTFOVGc0T1RaYUlncDkuQUl5OGR0VzVsMWdPUExyUG1Tbm14ZU1Tbl9CWjRBQlVaUU1CWjBBRlMtdFoySS1sOTVndC1oRjVxcG9BQnpCNEV6Q3VpTTR5SV81RXItMW9Hb25ibmdQZlkwNzAxc0dLYXFEeFJFckk1dUFMZW1jXzhnYi1ibkpteXJYNFBaUGJTNjBjb1JNU1lPRFR1X0t5UFE1RHJaREFxNmlOWEVVX1NqcERJYmczbEFEUHFJUGViY09sTzJoSHRod1dvczJLaFhTN1htckMyQlAyRTRieWEwWVljRjRZSlBhWkpSd3lnY3ZoN09Nd2RVbmJVYXhyMk1fSzFfelNEVTk0OEJac0NkaXctYjU1dzJISThmMUVOQ2JHUi1qaVctVVpUVnBORTFTUmM1UzFCclZYdjBPV0VDcGtoV045MlJwRzBZdGgxRHl5UHJZQk5reHkydzNmbEdsNnFnIiwiY2xpZW50X2lkIjoiY3JlZGlmeSIsInVzZXJfdXVpZCI6IjY1NjJjMDAzLTBiMjktNDM2Yi04MzFiLWQ0Y2FiNjE3ODkxMiIsInJlZnJlc2hlZF9hdCI6MTY5ODI1NzU2NCwidXNlcl9pZCI6Mjk2MDMwODMsInVwZ3JhZGFibGVfYXV0aGVudGljYXRpb24iOmZhbHNlLCJzY29wZSI6WyJ1c2VyOnNlbGY6cmVhZCIsIkFjY291bnQ6SE9MREVSOnVzZSIsIkFjdG9yOnNlbGY6Y3VzdG9tZXItbWFuYWdlLXNlcnZpY2UtcmVxdWVzdCIsIkFjdG9yOnNlbGY6dXBkYXRlLWNvbnRhY3QiLCJBY3RvcjpzZWxmOm1hbmFnZS1jaGFubmVsLWFkZHJlc3MiLCJMb2dpbjpzZWxmOnJlYWQiLCJBY3RvcjpzZWxmOmN1c3RvbWVyLXJlYWQtc2VydmljZS1yZXF1ZXN0IiwiQWN0b3I6c2VsZjpyZWFkLWNvbnRhY3RzIiwiTG9naW46c2VsZjp1cGRhdGUiLCJBY3RvcntcImhpZ2hSaXNrXCI6XCJmYWxzZVwifTpzZWxmOnVwZGF0ZS1waG9uZS1udW1iZXIiLCJBY2NvdW50OkhPTERFUjptYW5hZ2UtY2FyZCIsIkxvZ2luOnNlbGY6cmV2b2tlLXRydXN0ZWQtZGV2aWNlIiwiQWN0b3I6c2VsZjpyZWFkLWNvbnRhY3QiLCJMb2dpbjpzZWxmOm1hbmFnZS1iaW5kaW5nIiwiTG9naW46c2VsZjpyZWdpc3Rlci10cnVzdGVkLWRldmljZSIsIkFjdG9yOnNlbGY6bWFuYWdlLW5vdGlmaWNhdGlvbiIsImdyYW50ZWRfcmVzb3VyY2VzIiwiQWN0b3I6c2VsZjpyZXBseS1hY3Rvci10b2RvIiwiQWNjb3VudDpIT0xERVI6cmVhZCIsIkFjdG9yOnNlbGY6Y3JlYXRlLWNvbnRhY3QiLCJBY3RvcjpzZWxmOnJlYWQiLCJBY3RvcjpzZWxmOnVwZGF0ZSIsIkFjY291bnQ6SE9MREVSOnJlYWQtd2lyZS10cmFuc2ZlciJdLCJleHAiOjE2OTgyNTkzNjQsImF1dGhlbnRpY2F0aW9uX2xldmVsIjoiZnVsbCIsImlhdCI6MTY5ODI1NzU2NCwianRpIjoiNjg3OTljZjItMDk5Mi00NDgwLTk0MTctYmNhZTViYzU4MTllIn0.T10j8uawD-R94cwdvWfnbYCsu2KY9rwTI_MTsAYMHCu-Jev1DRoakVEy9tk7EAvAc54KQjdse3a9STvGqbPXwDKUmDsiQojHMjt9ZVscmNlj2yh87iYgU54gItq0ExzlpXIoJuDWlUBbT9BMNaeBkDQGw6fK_WXGLj_CuJUmat-VdBb1nkV8TRrGvueUKFLe5iL94PSXqUwep_9N43oZlgLEHmo7DrLY-KFk3Z_TbO-86-Ny8TKJAE_g4nzRRBpOS0eEIDtDcy2v-TUZJPrbsjNfQh5udTcimwKtGzpW5KEYBDjlTX1tqo09O3KDY40BLDQTiBv4c9httbHlQvPrcQ; _abck=6252B5221E6F35154F48EF7C114830BA~-1~YAAQBL7CFzLeaGCLAQAAz/UJaAqC0YZfwRi7blZPT1FKf2yhk9wg4GZ1f7rMo8WdAFTiJkc8Q8+umMCRiWVTe5trsj6pBQQS0a5nD0AuiJhOofFMWXReVCdvDxyKf78L7ttfllwf9At5TGgxBR18lfkZEjwP1LozolbmXTW1WW2fdInKOLxym+lJKebS1HQGvdl7t3sK+GFebaNBkSB3CF9pvZL7liCvceVHeWMdTW8qQLlm+DCzPLV8ytq8a3XOxEp/1FpqQSRGZI04AWylPeQcrvAhq8oQHKj5VbD4dNRd42iLDyoZARr9xajyxrGNlfYyIt+GO3KNWQ9V4RqgiF+m6EiXNgb1ERrktoPcidjC4HcCfPP07jGuAzWOi/S5ajxm2stzmnU9EBysoqjbs4XQH4QUMJwgaQ==~0~-1~-1; bm_sv=C2689571EA00070BEA78846DF9D002EA~YAAQBL7CFzPeaGCLAQAAz/UJaBX4JJ3e/Va0Nn2jmVp12o2kj54eJR2S39bq5t/D7YKesYR9H/jcd9BfI/Psk47RT/t9GKifUlpiQNQiOLqVgOMYjCzHGnjWVEOADYab9sRWSBXwv6fsNP5Jld2u6uqyxKaCuJEcDeJS1rG0B6WMm+7g1R9qs7SibIeX8QvRPmEquqCwug/+Pe6CzmLxgfS1UKxCa0iJuMqcBEK8gLHHxsHSckE7nQ6nniuJ1yEwYg==~1")
                .get("https://credapi.upgrade.com/api/brfunnelorch/v2/auth/sessions/login")
                .then()
                .extract().response();

        System.out.println("reponse" + response.getStatusLine());
        Assertions.assertEquals(200, response.statusCode());
//        Assertions.assertEquals("qui est esse", response.jsonPath().getString("title[1]"));
    }
}