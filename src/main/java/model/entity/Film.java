package model.entity;

import java.util.Objects;

public class Film {
    private String name;
    private String companyName;
    private Integer duration;

    public Film(String name, String companyName, Integer duration) {
        this.name = name;
        this.companyName = companyName;
        this.duration = duration;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getName() {
        return name;
    }

    public Integer getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "Film \n" +
                "NAME: " + name +
                "  DURATION: " + duration +
                "  COMPANY: " + companyName + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return Objects.equals(name, film.name) &&
                Objects.equals(duration, film.duration) &&
                Objects.equals(companyName, film.companyName);
    }
}
