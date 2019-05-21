package model.entity;

import java.util.Objects;

public class Company {
    private String name;
    private String country;
    private Integer foundationYear;

    public Company(String name, String country, Integer foundationYear) {
        this.name = name;
        this.country = country;
        this.foundationYear = foundationYear;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setFoundationYear(Integer foundationYear) {
        this.foundationYear = foundationYear;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public Integer getFoundationYear() {
        return foundationYear;
    }

    @Override
    public String toString() {
        return "Company\n" +
                "NAME: " + name +
                "  COUNTRY: " + country +
                "  FOUNDATION: " + foundationYear + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(name, company.name) &&
                Objects.equals(country, company.country) &&
                Objects.equals(foundationYear, company.foundationYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, country, foundationYear);
    }
}
