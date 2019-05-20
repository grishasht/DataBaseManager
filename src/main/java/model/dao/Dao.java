package model.dao;

import runner.Connection;

import java.util.List;

public interface Dao<E, K> extends AutoCloseable{

    List<E> readAll();

    void delete(String deleteBy, K key);

    void create(E entity);

    List<E> read(String searchBy, K key);


    List<E> searchPhrase(String phrase);

    List<E> searchWord(String[] words);

    @Override
    void close();
}
