package dao.api;

import Entity.User;

import java.util.List;

/**
 * Created by aleksandrdolmatov on 21.01.17.
 */

    public interface UserDao {
        List<User> findAll();

         User  findById(long id);

         User findByLogin(String login);

        void delete(long id);

        boolean create(User user);

        boolean update(User user, long id);
    }


