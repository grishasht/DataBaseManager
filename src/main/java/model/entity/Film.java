package model.entity;

import java.util.Objects;

public class Film {
    private String name;
    private String companyName;
    private Integer release;
    private Boolean ar; // 3d effect (augmented reality)

    public Film(String name, String companyName, Integer release, Boolean ar) {
        this.name = name;
        this.companyName = companyName;
        this.release = release;
        this.ar = ar;
    }

    public void setAr(Boolean ar) {
        this.ar = ar;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRelease(Integer release) {
        this.release = release;
    }

    public Boolean getAr() {
        return ar;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getName() {
        return name;
    }

    public Integer getRelease() {
        return release;
    }

    @Override
    public String toString() {
        return "Film \n" +
                "NAME: " + name +
                "  RELEASE YEAR: " + release +
                "  COMPANY: " + companyName +
                "  3D: " + ar + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return Objects.equals(name, film.name) &&
                Objects.equals(release, film.release) &&
                Objects.equals(companyName, film.companyName) &&
                Objects.equals(ar, film.ar);
    }
}
