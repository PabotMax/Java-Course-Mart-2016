package app.database.connection;

import app.model.Contact;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import parse.gson.Message;

import java.io.*;
import java.sql.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;

import static parse.gson.GsonMain.writeJsonStream;

/**
 * Created by mda on 5/23/16.
 */
public class DBUtils {

    private static SimpleDateFormat dateFormat;

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

        return getConnection("com.mysql.jdbc.Driver", url, login, password);
    }

    private static Connection getConnection(String dbDriver,
                                            String dbConnection,
                                            String dbUser,
                                            String dbPassword) {
        Connection connection = null;
        try {
            Class.forName(dbDriver);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            connection = DriverManager.getConnection(dbConnection, dbUser, dbPassword);
            return connection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

    public static void createMySqlContactTable(Connection dbConnection) {
        Statement statement = null;

        String createTableSQL = "CREATE TABLE contact("
                + "user_id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT, "
                + "user_firstName VARCHAR(30) NOT NULL, "
                + "user_lastName VARCHAR(20) NOT NULL, "
                + "address_id INTEGER NOT NULL, "
                + "telephone_number_id INTEGER NOT NULL, "
                + "email_id VARCHAR(100) NOT NULL, "
                + "birthday DATE NOT NULL, "
                + "PRIMARY KEY (user_id));";
        try {
            statement = dbConnection.createStatement();

            // выполнить SQL запрос
            statement.execute(createTableSQL);
            System.out.println("Table \"contact\" is created!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void createMySqlAddressTable(Connection dbConnection) {
        Statement statement = null;


        String createTableSQL = "CREATE TABLE address("
                + "address_id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT, "
                + "user_id INTEGER UNSIGNED NOT NULL, "
                + "country VARCHAR(30) NOT NULL, "
                + "city VARCHAR(20) NOT NULL, "
                + "street VARCHAR(250) NOT NULL, "
                + "house_number INTEGER NOT NULL, "
                + "house_suffix VARCHAR(20) NOT NULL, "
                + "appartment INTEGER NOT NULL, "
                + "post_code INTEGER NOT NULL, "
                + "PRIMARY KEY (address_id), "
                + "FOREIGN KEY (user_id) REFERENCES contact(user_id) "
                + "ON DELETE CASCADE ON UPDATE CASCADE );";

        try {
            statement = dbConnection.createStatement();

            // выполнить SQL запрос
            statement.execute(createTableSQL);
            System.out.println("Table \"address\" is created!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void createMySqlTelephoneNumbersTable(Connection dbConnection) {
        Statement statement = null;

        String createTableSQL = "CREATE TABLE telephone_numbers("
                + "telephone_number_id INTEGER NOT NULL AUTO_INCREMENT, "
                + "user_id INTEGER UNSIGNED NOT NULL, "
                + "tel_number VARCHAR(20) NOT NULL, "
                + "PRIMARY KEY (telephone_number_id), "
                + "FOREIGN KEY (user_id) REFERENCES contact(user_id) "
                + "ON DELETE CASCADE ON UPDATE CASCADE );";

        try {
            statement = dbConnection.createStatement();

            // выполнить SQL запрос
            statement.execute(createTableSQL);
            System.out.println("Table \"telephone_numbers\" is created!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void createMySqlEmailsTable(Connection dbConnection) {
        Statement statement = null;

        String createTableSQL = "CREATE TABLE emails("
                + "email_id INTEGER NOT NULL AUTO_INCREMENT, "
                + "user_id INTEGER UNSIGNED NOT NULL, "
                + "email VARCHAR(100) NOT NULL, "
                + "PRIMARY KEY (email_id), "
                + "FOREIGN KEY (user_id) REFERENCES contact(user_id) "
                + "ON DELETE CASCADE ON UPDATE CASCADE );";

        try {
            statement = dbConnection.createStatement();

            // выполнить SQL запрос
            statement.execute(createTableSQL);
            System.out.println("Table \"emails\" is created!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void createMySqlContact_telephone(Connection dbConnection) {
        Statement statement = null;

        String createTableSQL = "CREATE TABLE contact_telephone("
                + "user_id INTEGER NOT NULL, "
                + "telephone_number_id INTEGER NOT NULL, "
                + "PRIMARY KEY (user_id, telephone_number_id)"
                + ")";
        try {
            statement = dbConnection.createStatement();

            // выполнить SQL запрос
            statement.execute(createTableSQL);
            System.out.println("Table \"contact_telephone\" is created!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    public static Long insert(Contact contact) throws SQLException {


        String insertContact = "INSERT INTO contact" + "(user_firstName, user_lastName, birthday) " + "VALUES" + "(?, ?, ?)";
        String insertEmail = "INSERT INTO emails" + "(user_id, email)" + "VALUES" + "(?, ?)";

        try {
            Connection dbConnection = getConnection();

            PreparedStatement statement = dbConnection.prepareStatement(insertContact);
            statement.setString(1, contact.firstName());
            statement.setString(2, contact.lastName());
            statement.setDate(3, new Date(contact.birthday.getTime()));

            statement.executeUpdate();

            ResultSet rs = statement.executeQuery("SELECT last_insert_id()");
            long userId = -1; // Here written wrong code.
            if (rs.next()) {
                userId = rs.getLong(1);
            }
            statement.close();

            statement = dbConnection.prepareStatement(insertEmail);
            for (String email : contact.emails) {
                statement.setLong(1, userId);
                statement.setString(1, email);
                statement.executeUpdate();
            }

            statement.close();

            return userId;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private static String getCurrentTimeStamp() {
        java.util.Date today = new java.util.Date();
        return dateFormat.format(today);
    }
}
