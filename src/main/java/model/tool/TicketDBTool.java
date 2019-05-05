package model.tool;

import model.dao.TicketDao;
import model.entity.Ticket;

import java.util.List;

public class TicketDBTool implements TicketDao {
    @Override
    public List<Ticket> readAll() {
        return null;
    }

    @Override
    public void delete(String deleteBy, String key) {

    }

    @Override
    public void create(Ticket entity) {

    }

    @Override
    public List<Ticket> read(String searchBy, String key) {
        return null;
    }

    @Override
    public void close() {

    }
}
