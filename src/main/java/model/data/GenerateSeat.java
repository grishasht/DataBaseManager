package model.data;

import model.entity.Seat;

public class GenerateSeat implements Generator<Seat> {
   @Override
    public Seat generate(String ownName){
        return new Seat(RandomizeService.randomizeNumber(), ownName);
    }
}
