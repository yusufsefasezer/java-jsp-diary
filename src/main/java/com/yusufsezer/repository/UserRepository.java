package com.yusufsezer.repository;

import com.yusufsezer.contracts.IDatabase;
import com.yusufsezer.contracts.IRepository;
import com.yusufsezer.model.User;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IRepository<User, Integer> {

    private final IDatabase database;
    public static final String USER_ID_COLUMN = "user_id";
    public static final String FIRST_NAME_COLUMN = "first_name";
    public static final String LAST_NAME_COLUMN = "last_name";
    public static final String EMAIL_COLUMN = "email";
    public static final String PASSWORD_COLUMN = "password";
    
    public UserRepository(IDatabase database) {
        this.database = database;
    }

    @Override
    public User get(Integer index) {
        User user = null;
        String query = String
                .format("SELECT * FROM user WHERE %s = %d", USER_ID_COLUMN, index);
        try {
            ResultSet resultSet = database.executeQuery(query);
            while (resultSet.next()) {
                user = new User(
                	resultSet.getInt(USER_ID_COLUMN),
                	resultSet.getString(FIRST_NAME_COLUMN),
                	resultSet.getString(LAST_NAME_COLUMN),
                	resultSet.getString(EMAIL_COLUMN),
                	resultSet.getString(PASSWORD_COLUMN)
                	);
            }
        } catch (Exception e) {
            return user;
        }
        return user;
    }

    @Override
    public List<User> getAll() {
        List<User> list = new ArrayList<>();
        String query = String.format("SELECT * FROM user ORDER BY %s ASC", USER_ID_COLUMN);
          
        try {
            ResultSet resultSet = database.executeQuery(query);
            while (resultSet.next()) {
                User user = new User(
                	resultSet.getInt(USER_ID_COLUMN),
                	resultSet.getString(FIRST_NAME_COLUMN),
                	resultSet.getString(LAST_NAME_COLUMN),
                	resultSet.getString(EMAIL_COLUMN),
                	resultSet.getString(PASSWORD_COLUMN)
                	);
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
        String query = String.format("INSERT INTO user"
                + " VALUES(NULL, '%s', '%s', '%s', '%s')",
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
                FIRST_NAME_COLUMN,
                user.getFirstName(),
                LAST_NAME_COLUMN,
                user.getLastName(),
                EMAIL_COLUMN,
                user.getEmail(),
                PASSWORD_COLUMN,
                user.getPassword(),
                USER_ID_COLUMN,
                index);

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
        String query = String
                .format("DELETE FROM user WHERE %s = %d",USER_ID_COLUMN, index);
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
        String query = String.format("SELECT * FROM user WHERE %s = '%s' AND %s = md5('%s')", EMAIL_COLUMN, email, PASSWORD_COLUMN, password);
        try {
            ResultSet resultSet = database.executeQuery(query);
            while (resultSet.next()) {
            	user = new User(
                	resultSet.getInt(USER_ID_COLUMN),
                	resultSet.getString(FIRST_NAME_COLUMN),
                	resultSet.getString(LAST_NAME_COLUMN),
                	resultSet.getString(EMAIL_COLUMN),
                	resultSet.getString(PASSWORD_COLUMN)
                	);
            }
        } catch (Exception e) {
            return user;
        }
        return user;
    }
}