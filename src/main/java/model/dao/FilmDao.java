package model.dao;

import model.entity.Film;

public interface FilmDao extends Dao<Film, String> {
    void update(String name, Integer release, Film entity);
}
