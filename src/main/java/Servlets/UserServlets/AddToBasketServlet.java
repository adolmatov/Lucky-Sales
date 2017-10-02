package Servlets.UserServlets;

import Service.impl.ProductServiceImpl;
import ServiceObjects.Basket;
import dto.ProductDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aleksandrdolmatov on 15.02.17.
 */
public class AddToBasketServlet  extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        Basket basket = new Basket();
        List<ProductDTO> productDTOList = new ArrayList<>();
        if(session.isNew()){
            session.setAttribute("basket", basket);

            basket.setProducts(productDTOList);
        }else basket = (Basket)session.getAttribute("basket");
        String productID = request.getRequestURI().substring(5);
        int id = Integer.valueOf(productID);
        ProductServiceImpl productService = new ProductServiceImpl();
        basket.getProducts().add(productService.findById(id));



    }
}
