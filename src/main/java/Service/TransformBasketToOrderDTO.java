package Service;


import ServiceObjects.Basket;
import dto.OrderDTO;

import java.util.Date;

public class TransformBasketToOrderDTO {
    public static OrderDTO transformBasketToOrderDTO(Basket basket){
        Date date = new Date();
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setUserID(basket.getUserID());
        orderDTO.setProducts(basket.getProducts());
        orderDTO.setSummaryPrice(basket.getSummaryPrice());
        orderDTO.setDateOfCreation(date);
        return orderDTO;
    }
}
