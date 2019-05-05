package model.data;

import model.entity.Film;

public class GenerateFilm implements Generator<Film> {
    @Override
    public Film generate(String name) {
        return new Film(RandomizeService.randomizeName(),
                name,
                RandomizeService.randomizeYear(),
                RandomizeService.randomizeAr());
    }
}
