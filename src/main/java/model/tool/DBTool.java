package model.tool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBTool {
    protected Connection connection;

    public DBTool(Connection connection) {
        this.connection = connection;
    }

    protected void closePrepStat(PreparedStatement preparedStatement){
        try {
            if (preparedStatement != null)
                preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
