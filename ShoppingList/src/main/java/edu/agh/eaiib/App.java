package edu.agh.eaiib;

import edu.agh.eaiib.model.Configuration;
import edu.agh.eaiib.repository.GsonUserConfiguration;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {

    static GsonUserConfiguration configuration = new GsonUserConfiguration("./configuration.json");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (configuration.read().equals(configuration.defaultConfiguration)) {
            System.out.print("There is no configuration, would You like to load the default? [Yes/No] ");
            String answer = scanner.nextLine();
            if (answer.equals("Yes") || answer.equals("Y")) {
                configuration.save(configuration.defaultConfiguration);
            } else {
                System.out.println("Fill out the configuration parameters");
                System.out.println("Type one in each line: <username>");
                String username = scanner.nextLine();
                System.out.println("Type one in each line: <database file name>");
                String file = scanner.nextLine();
                System.out.println("Type one in each line: <configuration name>");
                String configName = scanner.nextLine();
                Configuration newConfig = new Configuration(username, file, configName);
                configuration.save(newConfig);
            }
        }

        System.out.println(String.format("%s, welcome to lists.", configuration.read().getUsername()));

        CommandParser commandParser = new CommandParser(configuration.read());
        while (true) {
            String input = scanner.nextLine();
            boolean shouldContinue = commandParser.parse(input);
            if (!shouldContinue) break;
        }
    }
}
