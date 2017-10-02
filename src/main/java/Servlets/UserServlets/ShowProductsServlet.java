package Servlets.UserServlets;

import Service.impl.ProductServiceImpl;
import dto.ProductDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by aleksandrdolmatov on 05.02.17.
 */
public class ShowProductsServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        ProductServiceImpl productService = new ProductServiceImpl();
        List<ProductDTO> productDTOList;
        productDTOList = productService.findAllProducts();
        if(productDTOList!=null){
            HttpSession session = request.getSession(true);
            session.setAttribute("products", productDTOList);
            response.sendRedirect("Products.jsp");
        }else System.out.println("asdf");


    }
}
