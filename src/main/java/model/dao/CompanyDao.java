package model.dao;

import model.entity.Company;

public interface CompanyDao extends Dao<Company, String> {
    void update(String name, Integer year, Company entity);
}
