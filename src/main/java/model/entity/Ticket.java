package model.entity;

import java.util.Objects;

public class Ticket {
    private String filmName;
    private String personName;
    private Integer ageCategory;

    public Ticket(String filmName, String personName, Integer ageCategory) {
        this.filmName = filmName;
        this.personName = personName;
        this.ageCategory = ageCategory;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public void setAgeCategory(Integer ageCategory) {
        this.ageCategory = ageCategory;
    }

    public String getFilmName() {
        return filmName;
    }

    public Integer getAgeCategory() {
        return ageCategory;
    }

    public String getPersonName() {
        return personName;
    }

    @Override
    public String toString() {
        return "Ticket\n" +
                "OWNER: " + personName +
                "  FILM: " + filmName +
                "  AGE CATEGORY: " + ageCategory + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(filmName, ticket.filmName) &&
                Objects.equals(personName, ticket.personName) &&
                Objects.equals(ageCategory, ticket.ageCategory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmName, personName, ageCategory);
    }
}
