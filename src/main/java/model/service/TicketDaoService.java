package model.service;

import model.dao.FilmDao;
import model.dao.TicketDao;
import model.data.GenerateTicket;
import model.data.Generator;
import model.entity.Film;
import model.entity.Ticket;
import model.setConnection;
import model.tool.FilmDBTool;
import model.tool.TicketDBTool;

import java.sql.Connection;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicketDaoService extends setConnection implements DaoService<Ticket>{
    public TicketDaoService(Connection connection) {
        super(connection);
    }

    TicketDao ticketDao = new TicketDBTool(connection);
    Scanner scanner = new Scanner(System.in);
    Generator<Ticket> ticketGenerator = new GenerateTicket();

    @Override
    public void create() {
        String ownerName, filmName;
        Integer ageCategory;

        System.out.print("Input owner name: ");
        ownerName = scanner.nextLine();
        System.out.print("Input owners film name: ");
        filmName = scanner.nextLine();
        System.out.print("Input films age category: ");
        ageCategory = scanner.nextInt();

        ticketDao.create(new Ticket(ownerName, filmName, ageCategory));
    }

    @Override
    public void createRandomized() {
        FilmDao filmDao = new FilmDBTool(connection);
        String filmName;

        List<Film> films = filmDao.readAll();
        for (Film film: films){
            filmName = film.getName();
            createOneRandomized(filmName);
        }
    }

    @Override
    public void createOneRandomized(String key) {
        Random random = new Random();
        Integer ticketsNumber = 0;
        int i = 0;

        while(ticketsNumber == 0) ticketsNumber = random.nextInt(5);
        while(i < ticketsNumber){
            ticketDao.create(ticketGenerator.generate(key));
            i++;
        }
    }

    @Override
    public List<Ticket> readALL() {
        System.out.println("All tickets data:");
        return ticketDao.readAll();
    }

    @Override
    public List<Ticket> read() {
        String parameter, key;

        System.out.print("Enter parameter by which you want to find: ");
        parameter = scanner.nextLine();
        System.out.print("Enter key by which want to find: ");
        key = scanner.nextLine();


        return ticketDao.read(parameter, key);
    }

    @Override
    public void update() {
        String ownerName;
        Integer ageCategory;
        String newOwnerName, newFilmName;
        Integer newAgeCategory;

        System.out.print("Input owner name which update: ");
        ownerName = scanner.nextLine();

        System.out.print("Input new owner name: ");
        newOwnerName = scanner.nextLine();
        System.out.print("Input new film name: ");
        newFilmName = scanner.nextLine();
        System.out.print("Input new age category: ");
        newAgeCategory = scanner.nextInt();

        ticketDao.update(ownerName, new Ticket(newOwnerName, newFilmName, newAgeCategory));
    }

    @Override
    public List<Ticket> search(Integer choice) {
        List<Ticket> tickets;
        if (choice == 1){
            System.out.println("Enter your phase:");
            tickets = ticketDao.search("SELECT * FROM tickets WHERE to_tsvector(owner_name) @@ " +
                    "to_tsquery('" + scanner.nextLine() + "')");
        }else if (choice == 2){
            System.out.println("Enter words:");
            tickets = ticketDao.search("SELECT * FROM tickets WHERE to_tsvector(owner_name) @@ " +
                    "to_tsquery('" + scanner.nextLine().replace(' ', '&') + "')");
        }else{
            throw new IllegalArgumentException();
        }
        return tickets;
    }

    @Override
    public void delete() {
        String parameter, key;

        System.out.print("Enter parameter by which you want to remove: ");
        parameter = scanner.nextLine();
        System.out.print("Enter key by which want to remove: ");
        key = scanner.nextLine();

        ticketDao.delete(parameter, key);
    }
}
