package app;

import app.database.connection.DBUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Family on 13.05.2016.
 */
public class App {
    public static void main(String[] args) throws SQLException {
        System.out.println ("Start");
        /*Connection Connection = DBUtils.getDBConnection ();
        DBUtils.createAddressTable (Connection);*/

        /*Connection MySqlConnection = MySqlDB.getConnection ();
        MySqlDB.createAddressTable (MySqlConnection);*/

        Connection MySqlConnection = DBUtils.getConnection ();
        Statement statement = MySqlConnection.createStatement ();

        DBUtils.createMySqlContactTable (MySqlConnection);

        DBUtils.createMySqlAddressTable (MySqlConnection);

        DBUtils.createMySqlTelephoneNumbersTable (MySqlConnection);

        DBUtils.createMySqlEmailsTable (MySqlConnection);





    }
}
