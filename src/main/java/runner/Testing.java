package runner;

import model.dao.Connection;
import model.data.*;

public class Testing {

    public static void test(){
        Connection.setConnection();
        System.out.println(RandomizeService.randomizeNumber());
        System.out.println(RandomizeService.randomizeDuration());
        System.out.println(RandomizeService.randomizeAge());
        System.out.println(RandomizeService.randomizeName());
        System.out.println("------------------------");
        Factory factory = new Factory();
        System.out.println(factory.generateIssue(new GenerateActor(), "test").toString());
        System.out.println(factory.generateIssue(new GenerateCompany(), "test").toString());
        System.out.println(factory.generateIssue(new GenerateTicket(), "test").toString());
        System.out.println(factory.generateIssue(new GenerateFilm(), "test").toString());
        System.out.println(factory.generateIssue(new GenerateSeat(), "test").toString());

    }

}
