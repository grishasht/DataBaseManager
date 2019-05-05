package model.data;

import model.entity.Actor;

public class GenerateActor implements Generator<Actor> {
    @Override
    public Actor generate(String name) {
        return new Actor(RandomizeService.randomizeName(),
                name);
    }
}
