package model.dao;

import model.entity.Ticket;

public interface TicketDao extends Dao<Ticket, String> {
    void update(String name, Ticket entity);
}
