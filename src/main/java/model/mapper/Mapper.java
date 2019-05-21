package model.mapper;

import java.sql.ResultSet;

public interface Mapper<T> {
    T getFromResultSet(ResultSet resultSet, int... setIndexes);
}
