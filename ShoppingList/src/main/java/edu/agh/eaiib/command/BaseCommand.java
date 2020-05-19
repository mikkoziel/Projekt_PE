package edu.agh.eaiib.command;

import edu.agh.eaiib.AppContext;
import edu.agh.eaiib.model.User;
import edu.agh.eaiib.service.ProductListService;

public abstract class BaseCommand {
    protected AppContext appContext = new AppContext();
    protected User currentUser = appContext.getCurrentUser();
    protected ProductListService service = appContext.getService();

    public abstract void execute();
}
