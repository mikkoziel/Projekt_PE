package edu.agh.eaiib;

import edu.agh.eaiib.model.Configuration;
import edu.agh.eaiib.command.BaseCommand;
import edu.agh.eaiib.command.CommandFactory;
import edu.agh.eaiib.model.User;
import edu.agh.eaiib.repository.GsonUserDatabase;
import edu.agh.eaiib.repository.UserRepositoryImpl;
import edu.agh.eaiib.service.ProductListService;

import java.io.File;
import java.io.IOException;
public class CommandParser {

    static ProductListService service;
    User user;
    Configuration configuration;

    public CommandParser(Configuration configuration) {
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
        this.service = new ProductListService(new UserRepositoryImpl(new GsonUserDatabase(filename)));
        this.user = service.readUser(configuration.getUsername());
        this.configuration = configuration;
    }

    public boolean parse(String input) {
        if (input.matches("quit")){
            return false;
        }

        BaseCommand command = CommandFactory.create(input);
        command.execute();
        return true;
    }
}
