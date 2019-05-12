package model.service;

import java.util.List;

public interface DaoService <T> {
    void create();

    List<T> readALL();

    List<T> read();

    Boolean update();

    Boolean delete();
}
