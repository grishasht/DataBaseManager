package model.service;

import model.dao.FilmDao;
import model.entity.Film;
import model.setConnection;
import model.tool.FilmDBTool;

import java.sql.Connection;
import java.util.List;

public class FilmDaoService extends setConnection implements DaoService<Film>{
    public FilmDaoService(Connection connection) {
        super(connection);
    }

    FilmDao filmDao = new FilmDBTool(connection);

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
    public List<Film> readALL() {
        return null;
    }

    @Override
    public List<Film> read() {
        return null;
    }

    @Override
    public void update() {
        return null;
    }

    @Override
    public void delete() {
        return null;
    }
}
