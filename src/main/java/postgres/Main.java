package postgres;
import model.dao.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] argv) {
        Connection.setConnection();

    }
}
