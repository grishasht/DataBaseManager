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
        filmName = scanner.nextLine();
        System.out.print("Input films company name: ");
        companyName = scanner.nextLine();
        System.out.print("Input film release year: ");
        release = scanner.nextInt();
        System.out.print("Input if film is 3D: ");
        ar = scanner.nextBoolean();

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
        parameter = scanner.nextLine();
        System.out.print("Enter key by which want to find: ");
        key = scanner.nextLine();


        return filmDao.read(parameter, key);
    }

    @Override
    public void update() {
        String filmName, newFilmName;
        String newCompanyName;
        Integer release, newRelease;
        Boolean newAR;

        System.out.print("Input film name which update: ");
        filmName = scanner.nextLine();
        System.out.print("Input films year release which update: ");
        release = scanner.nextInt();

        System.out.print("Input new film name: ");
        newFilmName = scanner.nextLine();
        System.out.print("Input new films company: ");
        newCompanyName = scanner.nextLine();
        System.out.print("Input new films release year: ");
        newRelease = scanner.nextInt();
        System.out.print("Input new film 3D: ");
        newAR = scanner.nextBoolean();

        filmDao.update(filmName, release, new Film(newFilmName, newCompanyName, newRelease, newAR));
    }

    @Override
    public List<Film> search(Integer choice) {
        List<Film> films;
        if (choice == 1){
            System.out.println("Enter your phase:");
            films = filmDao.search("SELECT * FROM films WHERE to_tsvector(film_name) @@ " +
                    "to_tsquery(" + scanner.nextLine() + ")");
        }else if (choice == 2){
            System.out.println("Enter words:");
            films = filmDao.search("SELECT * FROM films WHERE to_tsvector(film_name) @@ " +
                    "to_tsquery(" + scanner.nextLine().replace(' ', '&') + ")");
        }else{
            throw new IllegalArgumentException();
        }
        return films;
    }

    @Override
    public void delete() {
        String parameter, key;

        System.out.print("Enter parameter by which you want to remove: ");
        parameter = scanner.nextLine();
        System.out.print("Enter key by which want to remove: ");
        key = scanner.nextLine();

        filmDao.delete(parameter, key);
    }
}
