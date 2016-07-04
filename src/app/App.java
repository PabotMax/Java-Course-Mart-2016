package app;

import app.database.DBStore;
import app.database.connection.DBStoreImpl;
import app.model.Contact;
import com.google.gson.Gson;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Family on 13.05.2016.
 */
public class App {

    static Gson gson = new Gson();

    public static void main(String[] args) throws SQLException {
        System.out.println("Start");
        /*Connection Connection = DBUtils.getDBConnection ();
        DBUtils.createAddressTable (Connection);

        Connection MySqlConnection = MySqlDB.getConnection ();
        MySqlDB.createAddressTable (MySqlConnection);

        Connection MySqlConnection = DBUtils.getConnection();
        Statement statement = MySqlConnection.createStatement();

        DBUtils.createMySqlContactTable(MySqlConnection);

        DBUtils.createMySqlAddressTable(MySqlConnection);

        DBUtils.createMySqlTelephoneNumbersTable(MySqlConnection);

        DBUtils.createMySqlEmailsTable(MySqlConnection);

        DBUtils.createMySqlContact_telephone(MySqlConnection);
*/
        DBStore store = new DBStoreImpl();

        Contact contact = new Contact();
        contact.firstName = "Me";
        contact.lastName = "MeMe";
        contact.birthday = new Date(System.currentTimeMillis());

        contact.emails = new ArrayList<String>();
        contact.emails.add("a@a.a");
        contact.emails.add("b@b.a");

        store.add(contact);

    }
}

