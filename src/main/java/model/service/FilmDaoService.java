package model.service;

import model.dao.CompanyDao;
import model.dao.FilmDao;
import model.data.GenerateFilm;
import model.data.Generator;
import model.entity.Company;
import model.entity.Film;
import model.setConnection;
import model.tool.CompanyDBTool;
import model.tool.FilmDBTool;

import java.sql.Connection;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class FilmDaoService extends setConnection implements DaoService<Film> {
    public FilmDaoService(Connection connection) {
        super(connection);
    }

    FilmDao filmDao = new FilmDBTool(connection);
    Scanner scanner = new Scanner(System.in);
    Generator<Film> filmGenerator = new GenerateFilm();

    @Override
    public void create() {
        String filmName, companyName;
        Integer release;
        Boolean ar;

        System.out.print("Input film name: ");
        System.out.printf("%s\n", filmName = scanner.nextLine());
        System.out.print("Input films company name: ");
        System.out.printf("%s\n", companyName = scanner.nextLine());
        System.out.print("Input film release year: ");
        System.out.printf("%s\n", release = scanner.nextInt());
        System.out.print("Input if film is 3D: ");
        System.out.printf("%s\n", ar = scanner.nextBoolean());

        filmDao.create(new Film(filmName, companyName, release, ar));
    }

    @Override
    public void createRandomized() {
        CompanyDao companyDao = new CompanyDBTool(connection);
        String companyName;

        List<Company> companies = companyDao.readAll();
        for (Company company : companies) {
            companyName = company.getName();
            createOneRandomized(companyName);
        }
    }

    @Override
    public void createOneRandomized(String key) {
        Random random = new Random();
        Integer filmsNumber = 0;
        int i = 0;

        while (filmsNumber == 0) filmsNumber = random.nextInt(5);
        while (i < filmsNumber) {
            filmDao.create(filmGenerator.generate(key));
            //filmDao.create(new Actor(RandomizeService.randomizeName(), key));
            i++;
        }
    }

    @Override
    public List<Film> readALL() {
        System.out.println("All films data:");
        return filmDao.readAll();
    }

    @Override
    public List<Film> read() {
        String parameter, key;

        System.out.print("Enter parameter by which you want to find: ");
        System.out.printf("%s\n", parameter = scanner.nextLine());
        System.out.print("Enter key by which want to find: ");
        System.out.printf("%s\n", key = scanner.nextLine());


        return filmDao.read(parameter, key);
    }

    @Override
    public void update() {
        String filmName, newFilmName;
        String newCompanyName;
        Integer release, newRelease;
        Boolean newAR;

        System.out.print("Input film name which update: ");
        System.out.printf("%s\n", filmName = scanner.nextLine());
        System.out.print("Input films year release which update: ");
        System.out.printf("%s\n", release = scanner.nextInt());

        System.out.print("Input new film name: ");
        System.out.printf("%s\n", newFilmName = scanner.nextLine());
        System.out.print("Input new films company: ");
        System.out.printf("%s\n", newCompanyName = scanner.nextLine());
        System.out.print("Input new films release year: ");
        System.out.printf("%s\n", newRelease = scanner.nextInt());
        System.out.print("Input new film 3D: ");
        System.out.printf("%s\n", newAR = scanner.nextBoolean());

        filmDao.update(filmName, release, new Film(newFilmName, newCompanyName, newRelease, newAR));
    }

    @Override
    public void delete() {
        String parameter, key;

        System.out.printf("Input parameter used for removing: %s\n", parameter = scanner.nextLine());
        System.out.printf("Input key which remove: %s\n", key = scanner.nextLine());

        filmDao.delete(parameter, key);
    }
}
