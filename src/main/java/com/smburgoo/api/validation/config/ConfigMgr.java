package com.smburgoo.api.validation.config;


/*
This class is intended to manage the source of configuration used by the test to execute
 possible sources may be AWS S3, parameter store, local properties files, GitHub repositories, etc.
 this makes it easier to swap sources without making changes to the base configuration the test needs to run with

 I did not implement this for the purposes of this test, as I am not using remote sources and do not have time; however
 I did want to demonstrate conceptually that I find value in this type of manager pattern
*/
public final class ConfigMgr {

    private static Configuration config;

    private ConfigMgr() {
        config = new Configuration();
    }

    public static Configuration getConfiguration() {
        return config;
    }
}