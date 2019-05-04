package model.tool;

import model.dao.TicketDao;
import model.entity.Ticket;

import java.util.List;

public class TicketDBTool implements TicketDao {
    @Override
    public List<Ticket> getAll() {
        return null;
    }

    @Override
    public Ticket update(Ticket entity) {
        return null;
    }

    @Override
    public Ticket getEntityById(String id) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void create(Ticket entity) {

    }

    @Override
    public void close() {

    }
}
