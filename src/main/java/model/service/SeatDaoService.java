package model.service;

import model.dao.SeatDao;
import model.dao.TicketDao;
import model.data.GenerateSeat;
import model.data.Generator;
import model.entity.Seat;
import model.entity.Ticket;
import model.setConnection;
import model.tool.SeatDBTool;
import model.tool.TicketDBTool;

import java.sql.Connection;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SeatDaoService extends setConnection implements DaoService<Seat> {
    public SeatDaoService(Connection connection) {
        super(connection);
    }

    SeatDao seatDao = new SeatDBTool(connection);
    Scanner scanner = new Scanner(System.in);
    Generator<Seat> seatGenerator = new GenerateSeat();

    @Override
    public void create() {
        String ownerName;
        Integer seatNum;

        System.out.print("Input owner name: ");
        ownerName = scanner.nextLine();
        System.out.print("Input owners seating place: ");
        seatNum = scanner.nextInt();

        seatDao.create(new Seat(seatNum, ownerName));
    }

    @Override
    public void createRandomized() {
        TicketDao ticketDao = new TicketDBTool(connection);
        String ownerName;

        List<Ticket> tickets = ticketDao.readAll();
        for (Ticket ticket : tickets) {
            ownerName = ticket.getOwnerName();
            createOneRandomized(ownerName);
        }
    }

    @Override
    public void createOneRandomized(String key) {
        Random random = new Random();
        Integer ticketsNumber = 0;
        int i = 0;

        while (ticketsNumber == 0) ticketsNumber = random.nextInt(5);
        while (i < ticketsNumber) {
            seatDao.create(seatGenerator.generate(key));
            //actorDao.create(new Actor(RandomizeService.randomizeName(), key));
            i++;
        }
    }

    @Override
    public List<Seat> readALL() {
        System.out.println("All seats data:");
        return seatDao.readAll();
    }

    @Override
    public List<Seat> read() {
        String parameter, key;

        System.out.print("Enter parameter by which you want to find: ");
        parameter = scanner.nextLine();
        System.out.print("Enter key by which want to find: ");
        key = scanner.nextLine();


        return seatDao.read(parameter, key);
    }

    @Override
    public void update() {
        String ownerName;
        Integer seatNum;
        String newOwnerName;
        Integer newSeatNum;

        System.out.print("Input owner name which update: ");
        ownerName = scanner.nextLine();
        System.out.print("Input owners seating number which update: ");
        seatNum = scanner.nextInt();

        System.out.print("Input new owner name: ");
        newOwnerName = scanner.nextLine();
        System.out.print("Input new owners seating place: ");
        newSeatNum = scanner.nextInt();

        seatDao.update(ownerName, seatNum, new Seat(newSeatNum, newOwnerName));
    }

    @Override
    public void delete() {
        String parameter, key;

        System.out.print("Enter parameter by which you want to remove: ");
        parameter = scanner.nextLine();
        System.out.print("Enter key by which want to remove: ");
        key = scanner.nextLine();

        seatDao.delete(parameter, key);
    }
}
