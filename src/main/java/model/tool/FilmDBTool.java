package model.tool;

import model.dao.FilmDao;
import model.entity.Film;

import java.util.List;

public class FilmDBTool implements FilmDao {
    @Override
    public List<Film> getAll() {
        return null;
    }

    @Override
    public Film update(Film entity) {
        return null;
    }

    @Override
    public Film getEntityById(String id) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void create(Film entity) {

    }

    @Override
    public void close() {

    }
}
