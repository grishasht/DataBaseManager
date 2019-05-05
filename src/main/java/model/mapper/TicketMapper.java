package model.mapper;

import model.entity.Ticket;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TicketMapper implements Mapper<Ticket> {
    @Override
    public Ticket getFromResultSet(ResultSet resultSet, int... setIndexes) {
        Ticket ticket = null;
        try {
            ticket = new Ticket(
                    resultSet.getString(setIndexes[0]),
                    resultSet.getString(setIndexes[1]),
                    resultSet.getInt(setIndexes[2])
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ticket;
    }
}
