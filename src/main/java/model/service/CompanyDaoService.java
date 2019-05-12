package model.service;

import model.dao.CompanyDao;
import model.entity.Company;
import model.setConnection;
import model.tool.CompanyDBTool;

import java.sql.Connection;
import java.util.List;

public class CompanyDaoService extends setConnection implements DaoService<Company> {
    public CompanyDaoService(Connection connection) {
        super(connection);
    }

    CompanyDao companyDao = new CompanyDBTool(connection);

    @Override
    public void create() {

    }

    @Override
    public void createRandomized() {

    }

    @Override
    public void createOneRandomized(String key) {

    }

    @Override
    public List<Company> readALL() {
        return null;
    }

    @Override
    public List<Company> read() {
        return null;
    }

    @Override
    public void update() {
    }

    @Override
    public void delete() {
    }
}
