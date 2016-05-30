package app.database.connection;

import java.sql.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by mda on 5/23/16.
 */
public class DBUtils {



    /*public static Connection getDBConnection() {

        String urlPostgress = "jdbc:postgresql://localhost:5432/tac_addressbook";
        String login = "postgres";
        String password = "postgres_password";

        return getDBConnection ("org.postgresql.Driver", urlPostgress, login, password);


//        return getDBConnection("com.mysql.jdbc.Driver", "jdbc:mysql://hostname:port/dbname","username", "password");
//        return getDBConnection("oracle.jdbc.driver.OracleDriver","jdbc:oracle:thin:@localhost:1521:mkyong","username","password");
    }

    private static Connection getDBConnection(String dbDriver,
                                              String dbConnection,
                                              String dbUser,
                                              String dbPassword) {
        Connection connection = null;
        try {
            Class.forName (dbDriver);
        } catch (ClassNotFoundException e) {
            System.out.println (e.getMessage ());
        }
        try {
            connection = DriverManager.getConnection (dbConnection, dbUser, dbPassword);
            return connection;
        } catch (SQLException e) {
            System.out.println (e.getMessage ());
        }
        return connection;
    }

    public static void createAddressTable(Connection dbConnection) {
        Statement statement = null;

        String createTableSQL = "CREATE TABLE address("
                + "address_id INTEGER NOT NULL, "
                + "country VARCHAR(30) NOT NULL, "
                + "city VARCHAR(20) NOT NULL, "
                + "street VARCHAR(250) NOT NULL, "
                + "house_number INTEGER NOT NULL, "
                + "house_suffix VARCHAR(20) NOT NULL, "
                + "poste_code INTEGER NOT NULL, "
                + "PRIMARY KEY (address_id) "
                + ")";

        try {
            statement = dbConnection.createStatement ();

            // выполнить SQL запрос
            statement.execute (createTableSQL);
            System.out.println ("Table \"dbuser\" is created!");
        } catch (SQLException e) {
            System.out.println (e.getMessage ());
        } finally {
            if (statement != null) {
                try {
                    statement.close ();
                } catch (SQLException e) {
                    e.printStackTrace ();
                }
            }
        }
    }*/

    public static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/mysqldb";
        String login = "mysql";
        String password = "mysql_password";

        return getConnection ("com.mysql.jdbc.Driver", url, login, password);
    }

    private static Connection getConnection(String dbDriver,
                                            String dbConnection,
                                            String dbUser,
                                            String dbPassword) {
        Connection connection = null;
        try {
            Class.forName (dbDriver);
        } catch (ClassNotFoundException e) {
            System.out.println (e.getMessage ());
        }
        try {
            connection = DriverManager.getConnection (dbConnection, dbUser, dbPassword);
            return connection;
        } catch (SQLException e) {
            System.out.println (e.getMessage ());
        }
        return connection;
    }

    static void update() {
        String updateTableSQL = "UPDATE DBUSER SET USERNAME = 'mkyong_new' WHERE USER_ID = 1";

        try {
            Connection dbConnection = getConnection ();
            Statement statement = dbConnection.createStatement ();

            // выполняем запрос update SQL
            statement.execute (updateTableSQL);

            System.out.println ("Record is updated to DBUSER table!");
        } catch (SQLException e) {
            System.out.println (e.getMessage ());
        }
    }


    public static void createMySqlContactTable(Connection dbConnection) {
        Statement statement = null;

        String createTableSQL = "CREATE TABLE contact("
                + "user_id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT, "
                + "user_firstName VARCHAR(30) NOT NULL, "
                + "user_lastName VARCHAR(20) NOT NULL, "
                + "address_id INTEGER NOT NULL, "
                + "telephone_numbers_id INTEGER NOT NULL, "
                /*+ "emails VARCHAR(100) NOT NULL, "*/
                + "birthday DATE NOT NULL, "
                /*+ "photoPath VARCHAR(20) NOT NULL, "*/
                + "PRIMARY KEY (user_id) "
                + ")";
        try {
            statement = dbConnection.createStatement ();

            // выполнить SQL запрос
            statement.execute (createTableSQL);
            System.out.println ("Table \"dbuser\" is created!");
        } catch (SQLException e) {
            System.out.println (e.getMessage ());
        } finally {
            if (statement != null) {
                try {
                    statement.close ();
                } catch (SQLException e) {
                    e.printStackTrace ();
                }
            }
        }
    }


    public static void createMySqlAddressTable(Connection dbConnection) {
        Statement statement = null;

        String createTableSQL = "CREATE TABLE address("
                + "address_id INTEGER NOT NULL AUTO_INCREMENT, "
                + "country VARCHAR(30) NOT NULL, "
                + "city VARCHAR(20) NOT NULL, "
                + "street VARCHAR(250) NOT NULL, "
                + "house_number INTEGER NOT NULL, "
                + "house_suffix VARCHAR(20) NOT NULL, "
                + "poste_code INTEGER NOT NULL, "
                + "PRIMARY KEY (address_id) "
                + ")";

        try {
            statement = dbConnection.createStatement ();

            // выполнить SQL запрос
            statement.execute (createTableSQL);
            System.out.println ("Table \"dbuser\" is created!");
        } catch (SQLException e) {
            System.out.println (e.getMessage ());
        } finally {
            if (statement != null) {
                try {
                    statement.close ();
                } catch (SQLException e) {
                    e.printStackTrace ();
                }
            }
        }
    }

    public static void createMySqlTelephoneNumbersTable(Connection dbConnection) {
        Statement statement = null;

        String createTableSQL = "CREATE TABLE telephone_numbers("
                + "telephone_numbers_id INTEGER NOT NULL AUTO_INCREMENT, "
                + "tel_number VARCHAR(13) NOT NULL, "
                + "user_id INTEGER NOT NULL, "
                + "PRIMARY KEY (telephone_numbers_id) "
                + ")";
        try {
            statement = dbConnection.createStatement ();

            // выполнить SQL запрос
            statement.execute (createTableSQL);
            System.out.println ("Table \"dbuser\" is created!");
        } catch (SQLException e) {
            System.out.println (e.getMessage ());
        } finally {
            if (statement != null) {
                try {
                    statement.close ();
                } catch (SQLException e) {
                    e.printStackTrace ();
                }
            }
        }
    }

    public static void createMySqlEmailsTable(Connection dbConnection) {
        Statement statement = null;

        String createTableSQL = "CREATE TABLE emails("
                + "email_id INTEGER NOT NULL AUTO_INCREMENT, "
                + "email VARCHAR(13) NOT NULL, "
                + "user_id INTEGER NOT NULL, "
                + "PRIMARY KEY (email_id) "
                + ")";
        try {
            statement = dbConnection.createStatement ();

            // выполнить SQL запрос
            statement.execute (createTableSQL);
            System.out.println ("Table \"dbuser\" is created!");
        } catch (SQLException e) {
            System.out.println (e.getMessage ());
        } finally {
            if (statement != null) {
                try {
                    statement.close ();
                } catch (SQLException e) {
                    e.printStackTrace ();
                }
            }
        }
    }

    static void delete() {
        String deleteTableSQL = "DELETE DBUSER WHERE USER_ID = 1";

        try {
            Connection dbConnection = getConnection ();
            Statement statement = dbConnection.createStatement ();

            // выполняем запрос delete SQL
            statement.execute (deleteTableSQL);
            System.out.println ("Record is deleted from DBUSER table!");
        } catch (SQLException e) {
            System.out.println (e.getMessage ());
        }
    }
}
