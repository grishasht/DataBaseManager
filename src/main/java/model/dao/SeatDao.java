package model.dao;

import model.entity.Seat;

public interface SeatDao extends Dao<Seat, String> {
    void update(String name, Integer seatNum, Seat entity);
}
