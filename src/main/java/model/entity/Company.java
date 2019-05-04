package model.entity;

import java.util.Objects;

public class Company {
    private String name;
    private String country;
    private String film;

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getFilm() {
        return film;
    }

    @Override
    public String toString() {
        return "Company\n" +
                "name: " + name +
                ", country: " + country +
                ", film: " + film + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(name, company.name) &&
                Objects.equals(country, company.country) &&
                Objects.equals(film, company.film);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, country, film);
    }
}
