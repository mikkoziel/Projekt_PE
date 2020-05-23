package edu.agh.eaiib.repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import edu.agh.eaiib.model.Configuration;
import edu.agh.eaiib.model.User;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GsonUserConfiguration implements UserConfiguration {

    final static Gson gson = new Gson();
    private final String configFileName;
    public final static Configuration defaultConfiguration = new Configuration("admin", "database", "defaultConfiguation");

    public GsonUserConfiguration(String configFileName) {
        this.configFileName = configFileName;
    }

    @Override
    public void save(Configuration configuration) {
        try (FileWriter writer = new FileWriter(configFileName)) {
            Type type = new TypeToken<Configuration>() {}.getType();
            gson.toJson(configuration, type, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Configuration read() {
        try (Reader reader = new FileReader(configFileName)) {
            Configuration config = gson.fromJson(reader, new TypeToken<Configuration>() {}.getType());
            return config == null ? defaultConfiguration : config;
        } catch (IOException e) {
            e.printStackTrace();
            return defaultConfiguration;
        }
    }
}
