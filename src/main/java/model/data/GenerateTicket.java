package model.data;

import model.entity.Ticket;

public class GenerateTicket implements Generator<Ticket> {
    @Override
    public Ticket generate(String name) {
        return new Ticket(name,
                RandomizeService.randomizeName(),
                RandomizeService.randomizeAge());
    }
}
