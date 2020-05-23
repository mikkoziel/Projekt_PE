package edu.agh.eaiib;

import edu.agh.eaiib.fixtures.TestLogin;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name to login: ");
        String username = scanner.nextLine();

        CommandParser commandParser = new CommandParser();
        commandParser.parse("login " + username);
        while (true) {
            String input = scanner.nextLine();
            boolean shouldContinue = commandParser.parse(input);
            if (!shouldContinue) break;
        }
    }
}
