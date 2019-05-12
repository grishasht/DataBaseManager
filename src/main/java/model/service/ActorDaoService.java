package model.service;

import model.dao.ActorDao;
import model.dao.FilmDao;
import model.data.GenerateActor;
import model.data.Generator;
import model.entity.Actor;
import model.entity.Film;
import model.setConnection;
import model.tool.ActorDBTool;
import model.tool.FilmDBTool;

import java.sql.Connection;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ActorDaoService extends setConnection implements DaoService<Actor> {
    public ActorDaoService(Connection connection) {
        super(connection);
    }

    Scanner scanner = new Scanner(System.in);
    ActorDao actorDao = new ActorDBTool(connection);
    Generator<Actor> actorGenerator = new GenerateActor();

    @Override
    public void create() {
        String actorName, filmName;

        System.out.print("Input actor name: ");
        actorName = scanner.nextLine();
        System.out.print("Input actors film name: ");
        filmName = scanner.nextLine();

        actorDao.create(new Actor(actorName, filmName));
    }

    @Override
    public void createRandomized() {
        FilmDao filmDao = new FilmDBTool(connection);
        String filmName;

        List<Film> films = filmDao.readAll();
        for (Film film : films) {
            filmName = film.getName();
            createOneRandomized(filmName);
        }
    }

    @Override
    public void createOneRandomized(String key) {
        Random random = new Random();
        Integer actorsNumber = 0;
        int i = 0;

        while (actorsNumber == 0) actorsNumber = random.nextInt(5);
        while (i < actorsNumber) {
            actorDao.create(actorGenerator.generate(key));
            //actorDao.create(new Actor(RandomizeService.randomizeName(), key));
            i++;
        }
    }

    @Override
    public List<Actor> readALL() {
        System.out.println("All actors data:");
        return actorDao.readAll();
    }

    @Override
    public List<Actor> read() {
        String parameter, key;

        System.out.print("Enter parameter by which you want to find: ");
        parameter = scanner.nextLine();
        System.out.print("Enter key by which want to find: ");
        key = scanner.nextLine();


        return actorDao.read(parameter, key);
    }

    @Override
    public void update() {
        String actorName, filmName;
        String newActorName, newFilmName;

        System.out.print("Input actor name which update: ");
        actorName = scanner.nextLine();
        System.out.print("Input actors film name which update: ");
        filmName = scanner.nextLine();

        System.out.print("Input new actor name: ");
        newActorName = scanner.nextLine();
        System.out.print("Input new actors film name: ");
        newFilmName = scanner.nextLine();

        actorDao.update(actorName, filmName, new Actor(newActorName, newFilmName));
    }

    @Override
    public void delete() {
        String parameter, key;

        System.out.print("Enter parameter by which you want to remove: ");
        parameter = scanner.nextLine();
        System.out.print("Enter key by which want to remove: ");
        key = scanner.nextLine();

        actorDao.delete(parameter, key);
    }
}
