package model.service;

import java.util.List;

public interface DaoService <T> {
    void create();

    void createRandomized();

    void createOneRandomized(String key);

    List<T> readALL();

    List<T> read();

    List<T> search(Integer choice);

    void update();

    void delete();
}
