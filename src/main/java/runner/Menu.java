package runner;

import java.util.Scanner;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);

    public static void createMenu() {
        Integer choice;
        System.out.println(new StringBuilder()
                .append("1 - input in database\n")
                .append("2 - find in database \n")
                .append("3 - update in database\n")
                .append("4 - delete from database\n")
                .append("0 - exit\n")
                .append("Your choice:  "));
        while ((choice = scanner.nextInt()) != 0) {
            switch (choice) {
                case 1: input(); break;
                case 2: find(); break;
                case 3: update(); break;
                case 4: delete(); break;
                default: throw new IllegalArgumentException("Choose element of range [0; 4]");
            }
            System.out.println("Your choice: ");
        }
    }

    private static void input(){

    }

    private static void find(){

    }

    private static void update(){

    }

    private static void delete(){

    }

}
