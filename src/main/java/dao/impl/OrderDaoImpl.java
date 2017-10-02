package dao.impl;

import Entity.Order;
import Entity.Product;
import Entity.User;
import dao.api.OrderDao;
import db_util.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aleksandrdolmatov on 26.01.17.
 */
public class OrderDaoImpl implements OrderDao {
    private static OrderDao orderDao;
    private DataSource dataSource;
    private final static String SELECT_ORDERS_BY_USERID = "SELECT * from `order` where `userId` = ?";


    private OrderDaoImpl() {
        dataSource = DataSource.getInstance();
    }

    public static OrderDao getInstance() {
        if (orderDao == null) {
            synchronized (UserDaoImpl.class) {
                if (orderDao == null) {
                    orderDao = new OrderDaoImpl();
                }
            }
        }
        return orderDao;
    }
    @Override
    public List<Order> findAllUserOrders(User user) {
        Connection connection = dataSource.createConnection();
        List<Order> orders = new ArrayList<>();
    try {


        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ORDERS_BY_USERID);
        preparedStatement.setLong(1, user.getId());
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Order order = new Order();
            order.setId(resultSet.getLong("id"));
            order.setUserID(user.getId());
            order.setSummaryPrice(resultSet.getInt("summaryPrice"));
            order.setProducts(ProductDaoImpl.getInstance().findByOrder(order));
            orders.add(order);
        }
    }catch (SQLException e){
        e.printStackTrace();
    }
        return orders;
    }

    @Override
    public Order findById(long id) {

        return null;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public boolean create(Order order) {
        Connection connection = dataSource.createConnection();
        boolean bool = false;
        try {
            User user = UserDaoImpl.getInstance().findByLogin("pabel");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `order` (`userId`) VALUES (?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, order.getUserID());
            int a = 0;
           preparedStatement.executeUpdate();
            ResultSet result = preparedStatement.getGeneratedKeys();
            while (result.next()){
                a = result.getInt(1);
            }

            for (Product product:order.getProducts()) {
                 PreparedStatement preparedStatement1 = connection.prepareStatement("INSERT into order_product(orderId, productId, quantity)VALUES (?, ?, ?)");
                preparedStatement1.setLong(1, (long) a);
                preparedStatement1.setLong(2, product.getId());
                preparedStatement1.setLong(3, product.getQuantity());
                preparedStatement1.execute();
            }
            for (Product product:order.getProducts()) {
                PreparedStatement preparedStatement2 = connection.prepareStatement("UPDATE product SET `quantity` =(`quantity` - ?) WHERE id =?");
                preparedStatement2.setInt(1, product.getQuantity());
                preparedStatement2.setLong(2, product.getId());
                preparedStatement2.execute();
            }
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
    public boolean update(Order order, long id) {
        return false;
    }
}
