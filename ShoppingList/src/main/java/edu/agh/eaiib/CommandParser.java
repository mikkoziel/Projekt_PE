package edu.agh.eaiib;

import edu.agh.eaiib.command.BaseCommand;
import edu.agh.eaiib.command.CommandFactory;
import edu.agh.eaiib.model.Configuration;
import edu.agh.eaiib.repository.GsonUserDatabase;
import edu.agh.eaiib.repository.UserRepositoryImpl;
import edu.agh.eaiib.service.ProductListService;

import java.io.File;
import java.io.IOException;

public class CommandParser {
    ProductListService service;
    String username;
    Configuration configuration;
    AppContext appContext;

    public CommandParser(Configuration configuration) {
        this.configuration = configuration;
        String filename = this.handleConfigurationFile();
        this.setInitConfiguration(filename);
    }

    public String handleConfigurationFile(){
        String filename = "./";
        filename += configuration.getFileName() + ".json";
        System.out.println("Your database will be held in: " + filename);
        try {
            File myObj = new File(filename);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return filename;
    }

    public void setInitConfiguration(String filename){
        this.service = new ProductListService(new UserRepositoryImpl(new GsonUserDatabase(filename)));
        this.username = configuration.getUsername();
        this.appContext = new AppContext(service, username);
    }

    public boolean parse(String input) {
        if (input.matches("quit")){
            return false;
        }

        BaseCommand command = CommandFactory.create(input, appContext);
        command.execute();
        return true;
    }
}
