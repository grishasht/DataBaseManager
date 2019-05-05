package model.entity;

import java.util.Objects;

public class Actor{
    private String name;
    private String film;

    public Actor() {
    }

    public Actor(String name, String film) {
        this.name = name;
        this.film = film;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    public String getName() {
        return name;
    }

    public String getFilm() {
        return film;
    }

    @Override
    public String toString() {
        return "Actor \n" +
                "NAME: " + name +
                "  FILM: " + film + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return Objects.equals(name, actor.name) &&
                Objects.equals(film, actor.film);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, film);
    }
}
