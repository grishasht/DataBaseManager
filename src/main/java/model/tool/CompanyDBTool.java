package model.tool;

import model.dao.CompanyDao;
import model.entity.Company;

import java.util.List;

public class CompanyDBTool implements CompanyDao {
    @Override
    public List<Company> getAll() {
        return null;
    }

    @Override
    public Company update(Company entity) {
        return null;
    }

    @Override
    public Company getEntityById(String id) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void create(Company entity) {

    }

    @Override
    public void close() {

    }
}
