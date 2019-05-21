package model.entity;

import java.util.Objects;

public class Ticket {
    private String filmName;
    private String ownerName;
    private Integer ageCategory;

    public Ticket(String filmName, String ownerName, Integer ageCategory) {
        this.filmName = filmName;
        this.ownerName = ownerName;
        this.ageCategory = ageCategory;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
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

    public String getOwnerName() {
        return ownerName;
    }

    @Override
    public String toString() {
        return "Ticket\n" +
                "OWNER: " + ownerName +
                "  FILM: " + filmName +
                "  AGE CATEGORY: " + ageCategory + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(filmName, ticket.filmName) &&
                Objects.equals(ownerName, ticket.ownerName) &&
                Objects.equals(ageCategory, ticket.ageCategory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmName, ownerName, ageCategory);
    }
}
