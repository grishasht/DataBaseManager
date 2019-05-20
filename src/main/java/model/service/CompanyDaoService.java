package model.service;

import model.dao.CompanyDao;
import model.data.GenerateCompany;
import model.data.Generator;
import model.entity.Company;
import model.setConnection;
import model.tool.CompanyDBTool;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class CompanyDaoService extends setConnection implements DaoService<Company> {
    public CompanyDaoService(Connection connection) {
        super(connection);
    }

    CompanyDao companyDao = new CompanyDBTool(connection);
    Scanner scanner = new Scanner(System.in);
    Generator<Company> companyGenerator = new GenerateCompany();

    @Override
    public void create() {
        String companyName, countryName;
        Integer foundationYear;

        System.out.print("Input company name: ");
        companyName = scanner.nextLine();
        System.out.print("Input companies country name: ");
        countryName = scanner.nextLine();
        System.out.print("Input companies foundation year: ");
        foundationYear = scanner.nextInt();

        companyDao.create(new Company(companyName, countryName, foundationYear));
    }

    @Override
    public void createRandomized() {
        for (int i = 0; i < 10; i++) {
            createOneRandomized(null);
        }
    }

    @Override
    public void createOneRandomized(String key) {
        companyDao.create(companyGenerator.generate(null));
    }

    @Override
    public List<Company> readALL() {
        System.out.println("All companies data:");
        return companyDao.readAll();
    }

    @Override
    public List<Company> read() {
        String parameter, key;

        System.out.print("Enter parameter by which you want to find: ");
        parameter = scanner.nextLine();
        System.out.print("Enter key by which want to find: ");
        key = scanner.nextLine();

        return companyDao.read(parameter, key);
    }

    @Override
    public void update() {
        String companyName;
        Integer foundationYear;
        String newCompanyName, newCountryName;
        Integer newFoundationYear;

        System.out.print("Input company name which update: ");
        companyName = scanner.nextLine();
        System.out.print("Input companies foundation year which update: ");
        foundationYear = scanner.nextInt();

        System.out.print("Input new company name: ");
        newCompanyName = scanner.nextLine();
        System.out.print("Input new companies country name: ");
        newCountryName = scanner.nextLine();
        System.out.print("Input new companies foundation year: ");
        newFoundationYear = scanner.nextInt();

        companyDao.update(companyName, foundationYear, new Company(newCompanyName, newCountryName, newFoundationYear));
    }

    @Override
    public List<Company> search(Integer choice) {
        List<Company> companies;

        if (choice == 1){
            System.out.println("Enter your phase:");
            companies = companyDao.search("SELECT * FROM companies WHERE to_tsvector(company_name) @@ " +
                    "to_tsquery(" + scanner.nextLine() + ")");
        }else if (choice == 2){
            System.out.println("Enter words:");
            companies = companyDao.search("SELECT * FROM companies WHERE to_tsvector(company_name) @@ " +
                    "to_tsquery(" + scanner.nextLine().replace(' ', '&') + ")");
        }else{
            throw new IllegalArgumentException();
        }

        return companies;
    }

    @Override
    public void delete() {
        String parameter, key;

        System.out.print("Enter parameter by which you want to remove: ");
        parameter = scanner.nextLine();
        System.out.print("Enter key by which want to remove: ");
        key = scanner.nextLine();

        companyDao.delete(parameter, key);
    }
}
