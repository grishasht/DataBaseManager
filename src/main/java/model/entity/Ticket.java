package model.entity;

import java.util.Objects;

public class Ticket {
    private String filmName;
    private String personName;
    private Integer ageCategory;
    private String seats;

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public void setAgeCategory(Integer ageCategory) {
        this.ageCategory = ageCategory;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public String getFilmName() {
        return filmName;
    }

    public Integer getAgeCategory() {
        return ageCategory;
    }

    public String getSeats() {
        return seats;
    }

    public String getPersonName() {
        return personName;
    }

    @Override
    public String toString() {
        return "Ticket\n" +
                "person name: " + personName +
                "filmName: " + filmName +
                ", ageCategory: " + ageCategory +
                ", seats: " + seats + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(filmName, ticket.filmName) &&
                Objects.equals(personName, ticket.personName) &&
                Objects.equals(ageCategory, ticket.ageCategory) &&
                Objects.equals(seats, ticket.seats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmName, personName, ageCategory, seats);
    }
}
