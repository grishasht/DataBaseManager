package model.entity;

import java.util.Objects;

public class Actor{
    private String name;
    private String company;
    private String film;

    public void setName(String name) {
        this.name = name;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public String getFilm() {
        return film;
    }

    @Override
    public String toString() {
        return "Actor: \n" +
                "name: " + name  +
                ", company: " + company +
                ", film: " + film + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return Objects.equals(name, actor.name) &&
                Objects.equals(company, actor.company) &&
                Objects.equals(film, actor.film);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, company, film);
    }
}
