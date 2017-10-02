package Servlets.UserServlets;

import Service.impl.ProductServiceImpl;
import dto.ProductDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by aleksandrdolmatov on 06.02.17.
 */

public class ProductServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException{


        ProductServiceImpl productService = new ProductServiceImpl();
        Long productID;
        String uri = request.getRequestURL().toString();
        System.out.println(uri);

        String test = uri.substring(30);
        productID = Long.valueOf( test);
        ProductDTO productDTO = productService.findById(productID);
        request.setAttribute("product", productDTO);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("Product.jsp");
        requestDispatcher.include(request, response);


    }
}
