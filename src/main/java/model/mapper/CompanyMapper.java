package model.mapper;

import model.entity.Company;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CompanyMapper implements Mapper<Company> {
    @Override
    public Company getFromResultSet(ResultSet resultSet, int... setIndexes) {
        Company company = null;

        try {
            company = new Company(
                    resultSet.getString(setIndexes[0]),
                    resultSet.getString(setIndexes[1]),
                    resultSet.getInt(setIndexes[2])
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return company;
    }
}
