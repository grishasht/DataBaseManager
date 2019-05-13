package model.tool;

import model.dao.SeatDao;
import model.entity.Seat;
import model.mapper.Mapper;
import model.mapper.SeatMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class SeatDBTool extends DBTool implements SeatDao {
    public SeatDBTool(Connection connection) {
        super(connection);
    }

    @Override
    public List<Seat> readAll() {
        String sqlQuery = "SELECT * FROM seats";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;

        Mapper<Seat> seatMapper = new SeatMapper();
        List<Seat> seats = new LinkedList<>();

        try {
            preparedStatement = connection.prepareStatement(sqlQuery);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                seats.add(seatMapper.getFromResultSet(resultSet, 1, 2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepStat(preparedStatement);
        }

        return seats;
    }

    @Override
    public void delete(String deleteBy, String key) {
        String sqlQuery = "DELETE FROM seats WHERE " + deleteBy + " = ";
        if (deleteBy == "seat_num")
            sqlQuery += Integer.parseInt(key);
        else
            sqlQuery += "'" + key + "'";

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepStat(preparedStatement);
        }
    }

    @Override
    public void create(Seat entity) {
        String sqlQuery = "INSERT INTO seats(seat_num, owner_name) VALUES (?, ?)";

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, entity.getSeatNumber());
            preparedStatement.setString(2, entity.getOwnerName());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepStat(preparedStatement);
        }
    }

    @Override
    public void update(String name, Integer seatNum, Seat entity) {
        String sqlQuery = "UPDATE seats SET seat_num = ?, owner_name = ? " +
                "WHERE owner_name = " + "'" + name + "'" +
                " AND seat_num = " + seatNum;

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, entity.getSeatNumber());
            preparedStatement.setString(2, entity.getOwnerName());
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closePrepStat(preparedStatement);
        }
    }

    @Override
    public List<Seat> read(String searchBy, String key) {
        String sqlQuery = "SELECT * FROM seats WHERE " + searchBy + " = ";
        if (searchBy == "seat_num")
            sqlQuery += Integer.parseInt(key);
        else
            sqlQuery += "'" + key + "'";

        PreparedStatement prepStatement = null;
        ResultSet resultSet;

        Mapper seatMapper = new SeatMapper();
        List<Seat> seats = new LinkedList<>();

        try {
            prepStatement = connection.prepareStatement(sqlQuery);
            resultSet = prepStatement.executeQuery();
            while (resultSet.next())
                seats.add((Seat) seatMapper.getFromResultSet(resultSet, 1, 2));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepStat(prepStatement);
        }

        return seats;
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
