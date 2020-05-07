package edu.agh.eaiib;

import edu.agh.eaiib.repository.GsonProductListRepository;
import edu.agh.eaiib.service.ProductListService;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name to login: ");
        //Zapis usera do bazy
        String username = scanner.nextLine();

        System.out.println(String.format("%s, welcome to lists.", username));
        while (true) {
            String input = scanner.nextLine();
            new CommandParser().parse(input);
        }
    }
}
