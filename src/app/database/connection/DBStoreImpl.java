package app.database.connection;

import app.database.DBStore;
import app.model.Contact;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Set;

/**
 * Created by Family on 06.06.2016.
 */
public class DBStoreImpl implements DBStore{

    @Override
    public Long add(Contact contact) throws SQLException {
        Connection connection = DBUtils.getConnection();
        DBUtils.createMySqlContactTable(connection);

        return DBUtils.insert(contact);
    }

    @Override
    public Contact get(Long id) {
        return null;
    }

    @Override
    public Set<Contact> getContacts() {
        return null;
    }

    @Override
    public int remove(Long id) {
        return 0;
    }

    @Override
    public int remove(Contact contact) {
        return 0;
    }

    @Override
    public Set<Contact> search(Contact contact) {
        return null;
    }
}
