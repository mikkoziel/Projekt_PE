package edu.agh.eaiib.fixtures;

import edu.agh.eaiib.repository.GsonUserConfiguration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class TestSetup {

    public void cleanUpBeforeTest() throws FileNotFoundException {
        File file = new File(GsonUserConfiguration.defaultConfiguration.getFileName() + ".json");
        PrintWriter writer = new PrintWriter(file);
        writer.print("");
        writer.close();
    }
}
