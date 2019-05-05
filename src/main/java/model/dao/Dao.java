package model.dao;

import java.util.List;

public interface Dao<E, K> extends AutoCloseable{

    List<E> getAll();

    E update(E entity);

    E getEntityById(K id);

    void delete(K id);

    void insert(E entity);

    @Override
    void close();
}
