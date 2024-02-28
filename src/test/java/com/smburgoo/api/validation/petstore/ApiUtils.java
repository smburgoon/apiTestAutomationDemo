package com.smburgoo.api.validation.petstore;

import org.apache.commons.lang3.RandomStringUtils;

import java.time.Instant;
import java.util.Arrays;

public class ApiUtils {

    public static User generateRandomTestUser() {

        String username = RandomStringUtils.randomAlphanumeric(11);
        String firstName = RandomStringUtils.randomAlphanumeric(11);
        String lastName = RandomStringUtils.randomAlphanumeric(11);
        String email = firstName + lastName + "@gmail.com";
        String phone = RandomStringUtils.randomNumeric(10);

        User testUser = new User();
        testUser.setUsername(username);
        testUser.setFirstName(firstName);
        testUser.setLastName(lastName);
        testUser.setEmail(email);
        testUser.setPhone(phone);

        return testUser;
    }

    /*

    {id: "0671b5b8-6dd1-4a52-b0ff-1162b9f08cf5", title: "3453f3f3f", applicationArea: 1,…}
applicationArea
:
1
contactEmail
:
""
dateTime
:
"2024-02-28T22:17:21.770Z"
description
:
"34rdfgdg"
id
:
"0671b5b8-6dd1-4a52-b0ff-1162b9f08cf5"
resolved
:
false
tags
:
["bug", "featureRequest", "it", "helpRequested", "accessibility", "urgent"]
title
:
"3453f3f3f"
videoUrl
:
""
     */

    public static Ticket generateTicket() {

        String title = RandomStringUtils.randomAlphanumeric(11);
        String applicationArea = "Settings"; //
        String description = RandomStringUtils.randomAlphanumeric(11);
        Instant date = Instant.now();


        Ticket testTicket = new Ticket();

        // set required fields
        testTicket.setTitle(title);
        testTicket.setDescription(description);
        testTicket.setApplicationArea(applicationArea);
        testTicket.setDateTime("2024-02-14T05:00:00.000Z");

        //set optional fields, optionally

//        String email = RandomStringUtils.randomAlphanumeric(11) + "@gmail.com";
        Boolean resolved = false;


        testTicket.setContactEmail("");
        testTicket.setResolved(resolved);
        testTicket.setTags(Arrays.asList("bug"));




        return testTicket;
    }
}
