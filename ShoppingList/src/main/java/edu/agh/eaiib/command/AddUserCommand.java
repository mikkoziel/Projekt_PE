package edu.agh.eaiib.command;

import edu.agh.eaiib.AppContext;
import edu.agh.eaiib.model.ProductList;

public class AddUserCommand extends BaseCommand{

    private String userName;
    private String listName;

    public AddUserCommand(String input, AppContext appContext){
        super(appContext);
        String tmp = input.replaceFirst("user add ", "");
        userName = tmp.substring(0, tmp.indexOf(" "));
        tmp = tmp.replaceFirst("[A-Za-z0-9]+ to ", "");
        listName = tmp;
    }

    @Override
    public void execute() {
        ProductList list = currentUser.findList(listName);
        if (list == null) {
            System.out.println(String.format("List %s does not exists.", listName));
            return;
        }
        currentUser.addUserToList(userName, list);
        service.saveUser(currentUser);
    }
}
