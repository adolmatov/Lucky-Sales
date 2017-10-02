package dao.impl;

import Entity.Role;
import Entity.User;
import dao.api.UserDao;
import db_util.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class UserDaoImpl implements UserDao {

    private static UserDao userDao;
    private static final String SELECT_ALL_USERS = "select * from user";
    private static final String SELECT_USER_BY_ID = "select * from user where id = ?";
    private static final String SELECT_USER_BY_LOGIN = "select * from user where login = ?";
    private static final String DELETE_USER_BY_ID = "DELETE FROM user WHERE id = ?";

    private DataSource dataSource;

    private UserDaoImpl() {
        dataSource = DataSource.getInstance();
    }

    public static UserDao getInstance() {
        if (userDao == null) {
            synchronized (UserDaoImpl.class) {
                if (userDao == null) {
                    userDao = new UserDaoImpl();
                }
            }
        }
        return userDao;
    }

    @Override
    public List<User> findAll() {
        Connection connection = dataSource.createConnection();
        List<User> users = new LinkedList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL_USERS);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                User user = new User();
               //TODO dbTables according to Entities
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return users;
    }

    @Override
    public User findById(long id) {
        Connection connection = dataSource.createConnection();
        User user = new User();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user.setId(id);
                user.setName(resultSet.getString("name"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return user;
        }
    }
    @Override
    public User findByLogin(String login) {
        Connection connection = dataSource.createConnection();
        User user = new User();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_LOGIN);
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setOrdersList(OrderDaoImpl.getInstance().findAllUserOrders(user));
                user.setRole(Role.valueOf(resultSet.getString("role")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return user;
        }
    }

    @Override
    public void delete(long id) {
        Connection connection = dataSource.createConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER_BY_ID);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }
    }

    @Override
    public boolean create(User user) {
        Connection connection = dataSource.createConnection();
        boolean bool = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO user (name, login, password, role) VALUES(?, ?, ?, ?)");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLogin());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getRole().toString());
            bool = preparedStatement.execute();
            bool = true;
        } catch (SQLException e) {

            e.printStackTrace();


        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return bool;
        }
    }
    @Override
    public boolean update(User user, long id) {
        Connection connection = dataSource.createConnection();
        boolean bool = false;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE user SET name = ?, login = ?, password = ? WHERE id = ?");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLogin());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setLong(4, id);
            preparedStatement.execute();
            bool = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return bool;
        }


    }

}
