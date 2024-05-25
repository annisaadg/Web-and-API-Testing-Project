package com.tubes.dummyapi.helper;

import org.apache.commons.lang3.RandomStringUtils;

public class Utility {

    // generate randon data email dengan panjang karakter 10
    public static String generateRandomEmail() {
        String email = "";
        String temp = RandomStringUtils.randomAlphanumeric(10); // Panjang email 10 karakter
        email = temp + "@testdata.com";
        return email.toLowerCase();
    }
}
