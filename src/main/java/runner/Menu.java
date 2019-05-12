package runner;

import model.entity.*;
import model.service.*;

import java.util.Scanner;

public class Menu {
    private static java.sql.Connection connection = runner.Connection.setConnection();
    private static DaoService<Film> filmDaoService = new FilmDaoService(connection);
    private static DaoService<Actor> actorDaoService = new ActorDaoService(connection);
    private static DaoService<Company> companyDaoService = new CompanyDaoService(connection);
    private static DaoService<Ticket> ticketDaoService = new TicketDaoService(connection);
    private static DaoService<Seat> seatDaoService = new SeatDaoService(connection);

    private static Scanner scanner = new Scanner(System.in);
    private static StringBuilder tableMenu = new StringBuilder()
            .append("In which table?\n")
            .append("1 - films, 2 - actors, 3 - companies, 4 - tickets, 5 - seats\n");

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
                case 1:
                    input();
                    break;
                case 2:
                    find();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    delete();
                    break;
                default:
                    throw new IllegalArgumentException("Choose element of range [0; 4]");
            }
            System.out.println("Your choice: ");
        }
    }

    private static void inputRandomizeData() {
        System.out.println(tableMenu);
        Integer choice = scanner.nextInt();
        switch (choice) {
            case 1:
                filmDaoService.createRandomized();
                break;
            case 2:
                actorDaoService.createRandomized();
                break;
            case 3:
                companyDaoService.createRandomized();
                break;
            case 4:
                ticketDaoService.createRandomized();
                break;
            case 5:
                seatDaoService.createRandomized();
                break;
            default:
                throw new IllegalArgumentException("Choose element of range [1; 5]");
        }
    }

    private static void userInput() {
        System.out.println(tableMenu);
        Integer choice = scanner.nextInt();
        switch (choice) {
            case 1:
                filmDaoService.create();
                break;
            case 2:
                actorDaoService.create();
                break;
            case 3:
                companyDaoService.create();
                break;
            case 4:
                ticketDaoService.create();
                break;
            case 5:
                seatDaoService.create();
                break;
            default:
                throw new IllegalArgumentException("Choose element of range [1; 5]");
        }
    }

    private static void input() {
        System.out.println(new StringBuilder()
                .append("1 - randomized data, 2 - user input"));
        Integer choice = scanner.nextInt();
        switch (choice) {
            case 1:
                inputRandomizeData();
                break;
            case 2:
                userInput();
                break;
            default:
                throw new IllegalArgumentException("Choose element of range [1; 2]");
        }

    }

    private static void findAll() {
        System.out.println(tableMenu);
        Integer choice = scanner.nextInt();
        switch (choice) {
            case 1:
                filmDaoService.readALL().forEach(System.out::println);
                break;
            case 2:
                actorDaoService.readALL().forEach(System.out::println);
                break;
            case 3:
                companyDaoService.readALL().forEach(System.out::println);
                break;
            case 4:
                ticketDaoService.readALL().forEach(System.out::println);
                break;
            case 5:
                seatDaoService.readALL().forEach(System.out::println);
                break;
            default:
                throw new IllegalArgumentException("Choose element of range [1; 5]");
        }
    }

    private static void findParticular() {
        System.out.println(tableMenu);
        Integer choice = scanner.nextInt();
        switch (choice) {
            case 1:
                filmDaoService.read().forEach(System.out::println);
                break;
            case 2:
                actorDaoService.read().forEach(System.out::println);
                break;
            case 3:
                companyDaoService.read().forEach(System.out::println);
                break;
            case 4:
                ticketDaoService.read().forEach(System.out::println);
                break;
            case 5:
                seatDaoService.read().forEach(System.out::println);
                break;
            default:
                throw new IllegalArgumentException("Choose element of range [1; 5]");
        }
    }

    private static void find() {
        System.out.println(new StringBuilder()
                .append("1 - read all; 2 - read particular"));
        Integer choice = scanner.nextInt();
        switch (choice) {
            case 1:
                findAll();
                break;
            case 2:
                findParticular();
                break;
            default:
                throw new IllegalArgumentException("Choose element of range [1; 2]");
        }
    }

    private static void update() {
        System.out.println(tableMenu);
        Integer choice = scanner.nextInt();
        switch (choice) {
            case 1:
                filmDaoService.update();
                break;
            case 2:
                actorDaoService.update();
                break;
            case 3:
                companyDaoService.update();
                break;
            case 4:
                ticketDaoService.update();
                break;
            case 5:
                seatDaoService.update();
                break;
            default:
                throw new IllegalArgumentException("Choose element of range [1; 5]");
        }
    }

    private static void delete() {
        System.out.println(tableMenu);
        Integer choice = scanner.nextInt();
        switch (choice) {
            case 1:
                filmDaoService.delete();
                break;
            case 2:
                actorDaoService.delete();
                break;
            case 3:
                companyDaoService.delete();
                break;
            case 4:
                ticketDaoService.delete();
                break;
            case 5:
                seatDaoService.delete();
                break;
            default:
                throw new IllegalArgumentException("Choose element of range [1; 5]");
        }
    }

}
