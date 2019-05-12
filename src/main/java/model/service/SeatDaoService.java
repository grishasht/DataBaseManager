package model.service;

import model.dao.SeatDao;
import model.entity.Seat;
import model.setConnection;
import model.tool.SeatDBTool;

import java.sql.Connection;
import java.util.List;

public class SeatDaoService extends setConnection implements DaoService<Seat>{
    public SeatDaoService(Connection connection) {
        super(connection);
    }

    SeatDao seatDao = new SeatDBTool(connection);

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
    public List<Seat> readALL() {
        return null;
    }

    @Override
    public List<Seat> read() {
        return null;
    }

    @Override
    public void update() {
    }

    @Override
    public void delete() {

    }
}
