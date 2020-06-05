package edu.agh.eaiib.repository;
import edu.agh.eaiib.model.Configuration;
import edu.agh.eaiib.model.User;
import java.util.List;

public interface UserConfiguration {
    void save(Configuration configuration);

    Configuration read();
}
