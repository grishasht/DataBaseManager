package model.entity;

import java.util.Objects;

public class Film {
    private String name;
    private Integer duration;
    private String actor;

    public void setName(String name) {
        this.name = name;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getName() {
        return name;
    }

    public Integer getDuration() {
        return duration;
    }

    public String getActor() {
        return actor;
    }

    @Override
    public String toString() {
        return "Film \n" +
                "name: " + name +
                ", duration: " + duration +
                ", actor: " + actor + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return Objects.equals(name, film.name) &&
                Objects.equals(duration, film.duration) &&
                Objects.equals(actor, film.actor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, duration, actor);
    }
}
