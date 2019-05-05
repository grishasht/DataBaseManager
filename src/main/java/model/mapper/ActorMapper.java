package model.mapper;

import model.entity.Actor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ActorMapper implements Mapper<Actor> {
    @Override
    public Actor getFromResultSet(ResultSet resultSet, int... setIndexes) {
        Actor actor = null;
        try {
            actor = new Actor(
                    resultSet.getString(setIndexes[0]),
                    resultSet.getString(setIndexes[1])
                    );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actor;
    }
}
