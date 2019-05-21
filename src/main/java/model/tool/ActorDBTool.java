package model.tool;

import model.dao.ActorDao;
import model.entity.Actor;
import model.mapper.ActorMapper;
import model.mapper.Mapper;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ActorDBTool extends DBTool implements ActorDao {
    public ActorDBTool(Connection connection) {
        super(connection);
    }

    @Override
    public List<Actor> readAll() {
        String sqlQuery = "SELECT * FROM actors";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;

        Mapper<Actor> actorMapper = new ActorMapper();
        List<Actor> actors = new LinkedList<>();

        try {
            preparedStatement = connection.prepareStatement(sqlQuery);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                actors.add(actorMapper.getFromResultSet(resultSet, 1, 2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepStat(preparedStatement);
        }

        return actors;
    }

    private void redactRow(String query, Actor entity){
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getFilm());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepStat(preparedStatement);
        }
    }

    @Override
    public void update(String name, String film, Actor entity) {
        String sqlQuery = "UPDATE actors SET actor_name = ?, film_name = ? " +
                "WHERE actor_name = " + "'" + name + "'" +
                " AND film_name = " + "'" + film + "'";

        redactRow(sqlQuery, entity);
    }

    @Override
    public List<Actor> read(String searchBy, String key) {
        String sqlQuery = "SELECT * FROM actors WHERE " + searchBy + " = '" + key + "'";
        PreparedStatement prepStatement = null;
        ResultSet resultSet;

        Mapper actorMapper = new ActorMapper();
        List<Actor> actors = new LinkedList<>();

        try {
            prepStatement = connection.prepareStatement(sqlQuery);
            resultSet = prepStatement.executeQuery();
            while (resultSet.next())
                actors.add((Actor) actorMapper.getFromResultSet(resultSet, 1, 2));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
           closePrepStat(prepStatement);
        }

        return actors;
    }

    @Override
    public void delete(String deleteBy, String key) {
        String sqlQuery = "DELETE FROM actors WHERE " + deleteBy + " = " + "'" + key + "'";
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
    public void create(Actor entity) {
        String sqlQuery = "INSERT INTO actors VALUES (?, ?)";

        redactRow(sqlQuery, entity);
    }

    @Override
    public List<Actor> search(String phrase) {
        List<Actor> actors = new LinkedList<>();
        ActorMapper actorMapper = new ActorMapper();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement(phrase);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                actors.add(actorMapper.getFromResultSet(resultSet, 1, 2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closePrepStat(preparedStatement);
        }
        return actors;
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
