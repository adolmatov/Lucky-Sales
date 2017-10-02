package dao.api;

import Entity.Order;
import Entity.User;

import java.util.List;

/**
 * Created by aleksandrdolmatov on 26.01.17.
 */
public interface OrderDao {
    List<Order> findAllUserOrders(User user);

    Order findById(long id);

    void delete(long id);

    boolean create(Order order);

    boolean update(Order order, long id);
}

