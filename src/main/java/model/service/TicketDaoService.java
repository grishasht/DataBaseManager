package model.service;

import model.dao.TicketDao;
import model.entity.Ticket;
import model.setConnection;
import model.tool.TicketDBTool;

import java.sql.Connection;
import java.util.List;

public class TicketDaoService extends setConnection implements DaoService<Ticket>{
    public TicketDaoService(Connection connection) {
        super(connection);
    }

    TicketDao ticketDao = new TicketDBTool(connection);

    @Override
    public void create() {

    }

    @Override
    public void createRandomized() {

    }

    @Override
    public void createOneRandomized(String key) {

    }

    @Override
    public List<Ticket> readALL() {
        return null;
    }

    @Override
    public List<Ticket> read() {
        return null;
    }

    @Override
    public void update() {
    }

    @Override
    public void delete() {
    }
}
