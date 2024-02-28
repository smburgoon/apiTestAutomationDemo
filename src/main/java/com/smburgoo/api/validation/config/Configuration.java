
package com.smburgoo.api.validation.config;

/*
  This class is intended to define what configuration the tests will need to run against. Intended for static data such as
    API URL, path, ports, etc
  Using a class such as this can make it easy to understand the basics of what all tests may need, while creating a repeatable pattern usable across APIs and endpoints

 */
public class Configuration  {

    private String basePath;

    private String baseURI;

    private int port;

    public void configuration() {}


    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public String getBasePath() {
        return basePath;
    }

    public String getBaseURI() {
        return baseURI;
    }

    public void setBaseURI(String baseURI) {
        this.baseURI = baseURI;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}