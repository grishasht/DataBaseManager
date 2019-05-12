package model.tool;

import model.setConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBTool extends setConnection {
    public DBTool(Connection connection) {
        super(connection);
    }

    protected void closePrepStat(PreparedStatement preparedStatement) {
        try {
            if (preparedStatement != null)
                preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
