package edu.agh.eaiib.repository;
import edu.agh.eaiib.model.Configuration;

public interface UserConfiguration {
    void save(Configuration configuration);

    Configuration read();
}
