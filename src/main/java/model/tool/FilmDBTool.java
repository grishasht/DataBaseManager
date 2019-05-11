package model.tool;

import model.dao.FilmDao;
import model.entity.Film;
import model.mapper.FilmMapper;
import model.mapper.Mapper;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class FilmDBTool extends DBTool implements FilmDao {
    public FilmDBTool(Connection connection) {
        super(connection);
    }

    @Override
    public List<Film> readAll() {
        String sqlQuery = "SELECT * FROM films";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;

        Mapper<Film> filmMapper = new FilmMapper();
        List<Film> films = new LinkedList<>();

        try {
            preparedStatement = connection.prepareStatement(sqlQuery);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                films.add(filmMapper.getFromResultSet(resultSet, 1, 3, 2, 4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepStat(preparedStatement);
        }

        return films;
    }

    @Override
    public void delete(String deleteBy, String key) {
        String sqlQuery = "DELETE FROM films WHERE " + deleteBy + " = ";
        if (deleteBy == "release")
            sqlQuery += Integer.parseInt(key);
        else if(deleteBy == "ar")
            sqlQuery += Boolean.parseBoolean(key);
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
    public void create(Film entity) {
        String sqlQuery = "INSERT INTO films VALUES (?, ?, ?, ?)";

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setInt(2, entity.getRelease());
            preparedStatement.setString(3, entity.getCompanyName());
            preparedStatement.setBoolean(4, entity.getAr());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepStat(preparedStatement);
        }
    }

    @Override
    public void update(String name, Integer release, Film entity) {
        String sqlQuery = "UPDATE films SET film_name = ?, release = ?, " +
                "company_name = ?,  ar = ?" +
                "WHERE film_name = " + "'" + name + "'" +
                " AND release = " + release;

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setInt(2, entity.getRelease());
            preparedStatement.setString(3, entity.getCompanyName());
            preparedStatement.setBoolean(4, entity.getAr());
            preparedStatement.execute();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            closePrepStat(preparedStatement);
        }
    }

    @Override
    public List<Film> read(String searchBy, String key) {
        String sqlQuery = "SELECT * FROM films WHERE " + searchBy + " = ";
        if (searchBy == "release")
            sqlQuery += Integer.parseInt(key);
        else if(searchBy == "ar")
            sqlQuery += Boolean.parseBoolean(key);
        else
            sqlQuery += "'" + key + "'";

        PreparedStatement prepStatement = null;
        ResultSet resultSet;

        Mapper FilmMapper = new FilmMapper();
        List<Film> films = new LinkedList<>();

        try {
            prepStatement = connection.prepareStatement(sqlQuery);
            resultSet = prepStatement.executeQuery();
            while (resultSet.next())
                films.add((Film) FilmMapper.getFromResultSet(resultSet, 1, 3, 2, 4));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepStat(prepStatement);
        }

        return films;
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
