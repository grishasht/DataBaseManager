package model.mapper;

import model.entity.Seat;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SeatMapper implements Mapper<Seat> {
    @Override
    public Seat getFromResultSet(ResultSet resultSet, int... setIndexes) {
        Seat seat = null;
        try {
            seat = new Seat(
                    resultSet.getInt(setIndexes[0]),
                    resultSet.getString(setIndexes[1])
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seat;
    }
}
