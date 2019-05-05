package model.tool;

import model.dao.SeatDao;
import model.entity.Seat;

import java.util.List;

public class SeatDBTool implements SeatDao {
    @Override
    public List<Seat> readAll() {
        return null;
    }

    @Override
    public void delete(String deleteBy, Integer key) {

    }

    @Override
    public void create(Seat entity) {

    }

    @Override
    public List<Seat> read(String searchBy, Integer key) {
        return null;
    }

    @Override
    public void close() {

    }
}
