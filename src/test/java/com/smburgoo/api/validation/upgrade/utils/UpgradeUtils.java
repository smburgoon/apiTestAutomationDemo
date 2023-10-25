package com.smburgoo.api.validation.upgrade.utils;

import com.smburgoo.api.validation.petstore.User;
import org.apache.commons.lang3.RandomStringUtils;

public class UpgradeUtils {

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
}
