package edu.agh.eaiib.model;

import java.util.Objects;

public class Configuration {

    private String name;
    private String username;
    private String databaseFileName;

    public Configuration(String username, String databaseFileName, String name) {
        this.name = name;
        this.username = username;
        this.databaseFileName = databaseFileName;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getFileName() {
        return databaseFileName;
    }
}
