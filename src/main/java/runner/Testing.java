package runner;

import model.data.*;
import model.entity.Actor;
import model.entity.Film;
import model.tool.ActorDBTool;
import model.tool.FilmDBTool;

import java.sql.Connection;

public class Testing {

    public static void test(){
        Connection connection = runner.Connection.setConnection();
        Factory factory = new Factory();
//        System.out.println(RandomizeService.randomizeNumber());
//        System.out.println(RandomizeService.randomizeDuration());
//        System.out.println(RandomizeService.randomizeAge());
//        System.out.println(RandomizeService.randomizeName());
//        System.out.println("------------------------");
//
//        System.out.println(factory.generateIssue(new GenerateActor(), "test").toString());
//        System.out.println(factory.generateIssue(new GenerateCompany(), "test").toString());
//        System.out.println(factory.generateIssue(new GenerateTicket(), "test").toString());
//        System.out.println(factory.generateIssue(new GenerateFilm(), "test").toString());
//        System.out.println(factory.generateIssue(new GenerateSeat(), "test").toString());

//        ActorDBTool actorDBTool = new ActorDBTool(connection);
//        actorDBTool.create(factory.generateIssue(new GenerateActor(), "name1"));
//        actorDBTool.create(factory.generateIssue(new GenerateActor(), "name2"));
//        actorDBTool.create(factory.generateIssue(new GenerateActor(), "name3"));
//        actorDBTool.read("film_name","name").forEach(System.out::println);
//        System.out.println("------------------------");
//        actorDBTool.readAll().forEach(System.out::println);
//        System.out.println("------------------------");
//        actorDBTool.delete("actor_name", "ubbvtcndnlrpvxgtgjyd");
//        actorDBTool.readAll().forEach(System.out::println);
//        System.out.println("------------------------");
//        actorDBTool.update("trjxxefmrewxeledgroa", "name", new Actor("Pedro", "Godfather"));
//        actorDBTool.readAll().forEach(System.out::println);

        FilmDBTool filmDBTool = new FilmDBTool(connection);
       // filmDBTool.create(factory.generateIssue(new GenerateFilm(), "name1"));
       // filmDBTool.create(factory.generateIssue(new GenerateFilm(), "name2"));
       // filmDBTool.create(factory.generateIssue(new GenerateFilm(), "name3"));
        filmDBTool.read("company_name","name1").forEach(System.out::println);
        System.out.println("------------------------");
        //filmDBTool.readAll().forEach(System.out::println);
        //System.out.println("------------------------");
        filmDBTool.delete("film_name", "gfeudqpvojkrzuwvqtmf");
        filmDBTool.delete("film_name", "jloxciqfettcbgpvztll");
        filmDBTool.delete("film_name", "zrduijvdthkmhwjhcoej");
        filmDBTool.delete("film_name", "dysgetopqpwujxsjyobe");
        filmDBTool.readAll().forEach(System.out::println);
        System.out.println("------------------------");
        filmDBTool.update("gfeudqpvojkrzuwvqtmf", 1923, new Film(
                "Godfather", "WarnerBS", 1972, false));
        filmDBTool.readAll().forEach(System.out::println);
    }

}
