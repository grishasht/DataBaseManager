package model.tool;

import model.dao.TicketDao;
import model.entity.Ticket;
import model.mapper.Mapper;
import model.mapper.TicketMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class TicketDBTool extends DBTool implements TicketDao {
    public TicketDBTool(Connection connection) {
        super(connection);
    }

    @Override
    public List<Ticket> readAll() {
        String sqlQuery = "SELECT * FROM tickets";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;

        Mapper<Ticket> ticketMapper = new TicketMapper();
        List<Ticket> tickets = new LinkedList<>();

        try {
            preparedStatement = connection.prepareStatement(sqlQuery);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                tickets.add(ticketMapper.getFromResultSet(resultSet, 1, 2, 3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepStat(preparedStatement);
        }

        return tickets;
    }

    @Override
    public void delete(String deleteBy, String key) {
        String sqlQuery = "DELETE FROM tickets WHERE " + deleteBy + " = ";
        if (deleteBy == "age_category")
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
    public void create(Ticket entity) {
        String sqlQuery = "INSERT INTO tickets VALUES (?, ?, ?)";

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, entity.getOwnerName());
            preparedStatement.setString(2, entity.getFilmName());
            preparedStatement.setInt(3, entity.getAgeCategory());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepStat(preparedStatement);
        }
    }

    @Override
    public void update(String name, Ticket entity) {
        String sqlQuery = "UPDATE tickets SET owner_name = ?, " +
                "film_name = ?, age_category = ?"
                + "WHERE owner_name = " + "'" + name + "'";

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, entity.getOwnerName());
            preparedStatement.setString(2, entity.getFilmName());
            preparedStatement.setInt(3, entity.getAgeCategory());
            preparedStatement.execute();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            closePrepStat(preparedStatement);
        }
    }

    @Override
    public List<Ticket> read(String searchBy, String key) {
        String sqlQuery = "SELECT * FROM tickets WHERE " + searchBy + " = ";
        if (searchBy == "age_category")
            sqlQuery += Integer.parseInt(key);
        else
            sqlQuery += "'" + key + "'";

        PreparedStatement prepStatement = null;
        ResultSet resultSet;

        Mapper ticketMapper = new TicketMapper();
        List<Ticket> tickets = new LinkedList<>();

        try {
            prepStatement = connection.prepareStatement(sqlQuery);
            resultSet = prepStatement.executeQuery();
            while (resultSet.next())
                tickets.add((Ticket) ticketMapper.getFromResultSet(resultSet, 1, 2, 3));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepStat(prepStatement);
        }

        return tickets;
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
