package Helper;

import Entity.Order;
import Entity.Product;
import Entity.User;
import dto.OrderDTO;
import dto.ProductDTO;
import dto.UserDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aleksandrdolmatov on 23.01.17.
 */
public class Transformer {
    public static User transformUserDTOtoUser(UserDTO userDTO){
        User user = new User();
        user.setId(user.getId());
        user.setName(userDTO.getName());
        user.setLogin(userDTO.getLogin());
        user.setPassword(userDTO.getPassword());

        return user;
    }
    public static UserDTO transfomUsertoUserDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setLogin(user.getLogin());
        userDTO.setPassword(user.getPassword());
        userDTO.setOrders(transformOrderListtoOrderDTOlist(user.getOrdersList()));
        return userDTO;
    }
    public static ProductDTO transformProductToProductDTO(Product product){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        productDTO.setQuantity(product.getQuantity());
        return productDTO;
    }
    public static Product transformProductDTOtoProduct(ProductDTO productDTO){
        return null;
    }

    public static List<ProductDTO> transformProductListToProductDTOlist(List<Product> list){
        List<ProductDTO> productDTOs = new ArrayList<>();
        for (Product product: list) {
            ProductDTO productDTO = transformProductToProductDTO(product);
            productDTOs.add(productDTO);

        }
     return productDTOs;
    }
    public static OrderDTO transformOrdertoOrderDTO(Order order){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setUserID(order.getUserID());
        orderDTO.setProducts(transformProductListToProductDTOlist(order.getProducts()));
        return orderDTO;
    }
    public static List<OrderDTO> transformOrderListtoOrderDTOlist(List<Order> orders){
        List<OrderDTO> orderDTOs = new ArrayList<>();
        for(Order order: orders){
            OrderDTO orderDTO = transformOrdertoOrderDTO(order);
            orderDTOs.add(orderDTO);

        }
        return orderDTOs;
    }


}
