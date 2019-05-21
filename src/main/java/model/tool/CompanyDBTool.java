package model.tool;

import model.dao.CompanyDao;
import model.entity.Company;
import model.mapper.CompanyMapper;
import model.mapper.Mapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class CompanyDBTool extends DBTool implements CompanyDao {
    public CompanyDBTool(Connection connection) {
        super(connection);
    }

    @Override
    public List<Company> readAll() {
        String sqlQuery = "SELECT * FROM companies";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;

        Mapper<Company> companyMapper = new CompanyMapper();
        List<Company> companies = new LinkedList<>();

        try {
            preparedStatement = connection.prepareStatement(sqlQuery);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                companies.add(companyMapper.getFromResultSet(resultSet, 1, 2, 3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepStat(preparedStatement);
        }

        return companies;
    }

    @Override
    public void delete(String deleteBy, String key) {
        String sqlQuery = "DELETE FROM companies WHERE " + deleteBy + " = ";
        if (deleteBy == "foundation_year")
            sqlQuery += Integer.parseInt(key);
        else
            sqlQuery += "'" + key + "'";

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepStat(preparedStatement);
        }
    }

    @Override
    public void create(Company entity) {
        String sqlQuery = "INSERT INTO companies VALUES (?, ?, ?)";

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getCountry());
            preparedStatement.setInt(3, entity.getFoundationYear());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepStat(preparedStatement);
        }
    }

    @Override
    public void update(String name, Integer year, Company entity) {
        String sqlQuery = "UPDATE companies SET company_name = ?, country = ?, foundation_year = ? " +
                "WHERE company_name = " + "'" + name + "'" +
                " AND foundation_year = " + year;

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getCountry());
            preparedStatement.setInt(3, entity.getFoundationYear());
            preparedStatement.execute();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            closePrepStat(preparedStatement);
        }
    }

    @Override
    public List<Company> read(String searchBy, String key) {
        String sqlQuery = "SELECT * FROM companies WHERE " + searchBy + " = ";
        if (searchBy == "foundation_year")
            sqlQuery += Integer.parseInt(key);
        else
            sqlQuery += "'" + key + "'";

        PreparedStatement prepStatement = null;
        ResultSet resultSet;

        Mapper companyMapper = new CompanyMapper();
        List<Company> companies = new LinkedList<>();

        try {
            prepStatement = connection.prepareStatement(sqlQuery);
            resultSet = prepStatement.executeQuery();
            while (resultSet.next())
                companies.add((Company) companyMapper.getFromResultSet(resultSet, 1, 2, 3));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepStat(prepStatement);
        }

        return companies;
    }

    @Override
    public List<Company> search(String phrase) {
        List<Company> companies = new LinkedList<>();
        CompanyMapper companyMapper = new CompanyMapper();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement(phrase);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                companies.add(companyMapper.getFromResultSet(resultSet, 1, 2, 3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closePrepStat(preparedStatement);
        }

        return companies;
    }


    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
