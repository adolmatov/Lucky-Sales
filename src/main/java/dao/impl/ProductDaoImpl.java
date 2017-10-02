package dao.impl;

import Entity.Order;
import Entity.Product;
import dao.api.ProductDao;
import db_util.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by aleksandrdolmatov on 26.01.17.
 */
public class ProductDaoImpl implements ProductDao {
    private static ProductDao productDao;
    private static final String SELECT_ALL_PRODUCTS = "select * from product";
    private static final String SELECT_PRODUCT_BY_ID = "select * from product where id = ?";
    private static final String SELECT_PRODUCT_BY_ORDERID = "SELECT * FROM product INNER JOIN order_product ON order_product.productId=product.id WHERE order_product.orderId = ?";

    private DataSource dataSource;

    private ProductDaoImpl() {
        dataSource = DataSource.getInstance();
    }

    public static ProductDao getInstance() {
        if (productDao == null) {
            synchronized (UserDaoImpl.class) {
                if (productDao == null) {
                    productDao = new ProductDaoImpl();
                }
            }
        }
        return productDao;
    }
    @Override
    public List<Product> findAll() {
        Connection connection = dataSource.createConnection();
        List<Product> products = new LinkedList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL_PRODUCTS);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Product product = new Product();
                //TODO dbTables according to Entities
                product.setId(resultSet.getLong("id"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getString("price"));
                product.setQuantity(resultSet.getInt("quantity"));
                products.add(product);
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
        return products;
    }

    @Override
    public Product findById(long id) {
        Connection connection = dataSource.createConnection();
        Product product = new Product();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                product.setId(id);
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getString("price"));
                product.setQuantity(resultSet.getInt("quantity"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{
                if(connection!= null){
                    connection.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return product;
    }

    @Override
    public List<Product> findByOrder(Order order) {
        Connection connection = dataSource.createConnection();
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ORDERID);
            preparedStatement.setLong(1, order.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getLong("id"));
                product.setName(resultSet.getString("name"));
                product.setQuantity(resultSet.getInt("quantity"));
                products.add(product);
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
            return products;
        }
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public boolean create(Product product) {
        return false;
    }

    @Override
    public boolean update(Product product, long id) {
        return false;
    }
}
