package model.tool;

import model.dao.CompanyDao;
import model.entity.Company;

import java.util.List;

public class CompanyDBTool implements CompanyDao {
    @Override
    public List<Company> readAll() {
        return null;
    }

    @Override
    public void delete(String deleteBy, String key) {

    }

    @Override
    public void create(Company entity) {

    }

    @Override
    public List<Company> read(String searchBy, String key) {
        return null;
    }

    @Override
    public void close() {

    }
}
