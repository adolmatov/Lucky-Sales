package dao.api;

import Entity.Order;
import Entity.Product;

import java.util.List;

/**
 * Created by aleksandrdolmatov on 26.01.17.
 */
public interface ProductDao {
    List<Product> findAll();

    Product findById(long id);

    List<Product>  findByOrder(Order order);

    void delete(long id);

    boolean create(Product product);

    boolean update(Product product, long id);
}
