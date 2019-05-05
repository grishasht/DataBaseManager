package model.dao;

import model.entity.Actor;

public interface ActorDao extends Dao<Actor, String> {
    void update(String name, String film, Actor entity);
}
