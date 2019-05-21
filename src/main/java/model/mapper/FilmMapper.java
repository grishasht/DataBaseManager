package model.mapper;

import model.entity.Film;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FilmMapper implements Mapper<Film> {
    @Override
    public Film getFromResultSet(ResultSet resultSet, int... setIndexes) {
        Film film = null;
        try {
            film = new Film(
                    resultSet.getString(setIndexes[0]),
                    resultSet.getString(setIndexes[1]),
                    resultSet.getInt(setIndexes[2]),
                    resultSet.getBoolean(setIndexes[3])
                    );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return film;
    }
}
