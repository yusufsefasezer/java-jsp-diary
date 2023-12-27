package com.yusufsezer.repository;

import com.yusufsezer.contracts.IDatabase;
import com.yusufsezer.contracts.IRepository;
import com.yusufsezer.model.User;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IRepository<User, Integer> {

    private final IDatabase database;
    String password = "password";
    String userID ="user_id";
    String firstName ="first_name";
    String lastName ="last_name";
    String email ="email";


    // Constantes para los nombres de las columnas:
    private static final String COLUMN_USER_ID = "user_id";
    private static final String COLUMN_FIRST_NAME = "first_name";
    private static final String COLUMN_LAST_NAME = "last_name";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PASSWORD = "password";

    public UserRepository(IDatabase database) {
        this.database = database;
    }

    @Override
    public User get(Integer index) {
        User user = null;
        String query = String.format("SELECT * FROM user WHERE %s = %d", COLUMN_USER_ID, index);
        try {
            ResultSet resultSet = database.executeQuery(query);
            while (resultSet.next()) {
                user = new User();
            }
        } catch (Exception e) {
            return user;
        }
        return user;
    }

    @Override
    public List<User> getAll() {
        List<User> list = new ArrayList<>();
        String query = String.format("SELECT * FROM user ORDER BY %s ASC", COLUMN_USER_ID);
        try {
            ResultSet resultSet = database.executeQuery(query);
            while (resultSet.next()) {
                User user = new User();
                list.add(user);
            }
        } catch (Exception ex) {
            return list;
        }
        return list;
    }

    @Override
    public boolean add(User user) {
        boolean result = false;
        String query = String.format("INSERT INTO user VALUES(NULL, '%s', '%s', '%s', '%s')",
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword());
        try {
            database.executeSQL(query);
            result = true;
        } catch (Exception ex) {
            return result;
        }
        return result;
    }

    @Override
    public User update(Integer index, User user) {
        User updatedUser = get(index);
        String query = String.format("UPDATE user SET %s = '%s', %s = '%s', %s = '%s', %s = '%s' WHERE %s = %d",
                COLUMN_FIRST_NAME, user.getFirstName(),
                COLUMN_LAST_NAME, user.getLastName(),
                COLUMN_EMAIL, user.getEmail(),
                COLUMN_PASSWORD, user.getPassword(),
                COLUMN_USER_ID, index);

        try {
            boolean result = (boolean) database.executeSQL(query);
            updatedUser = result ? updatedUser : user;
        } catch (Exception ex) {
            return updatedUser;
        }
        return updatedUser;
    }

    @Override
    public User remove(Integer index) {
        String query = String.format("DELETE FROM user WHERE %s = %d", COLUMN_USER_ID, index);
        User deletedUser = get(index);
        try {
            database.executeSQL(query);
        } catch (Exception ex) {
            return deletedUser;
        }
        return deletedUser;
    }

    public User login(String email, String password) {
        User user = null;
        String query = String.format("SELECT * FROM user WHERE %s = '%s' AND %s = md5('%s')",
                COLUMN_EMAIL, email, COLUMN_PASSWORD, password);
        try {
            ResultSet resultSet = database.executeQuery(query);
            while (resultSet.next()) {
                user = new User();
            }
        } catch (Exception e) {
            return user;
        }
        return user;
    }
}

