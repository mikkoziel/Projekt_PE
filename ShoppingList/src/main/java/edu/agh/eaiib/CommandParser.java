package edu.agh.eaiib;

import edu.agh.eaiib.command.BaseCommand;
import edu.agh.eaiib.command.CommandFactory;
import edu.agh.eaiib.model.User;
import edu.agh.eaiib.repository.GsonUserDatabase;
import edu.agh.eaiib.repository.UserRepositoryImpl;
import edu.agh.eaiib.service.ProductListService;

public class CommandParser {

    static ProductListService service = new ProductListService(new UserRepositoryImpl(new GsonUserDatabase("./database.json")));
    User user;

    public CommandParser(String username) {
        this.user = service.readUser(username);
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
