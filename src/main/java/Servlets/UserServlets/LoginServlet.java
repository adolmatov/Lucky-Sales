package Servlets.UserServlets;

import Service.AuthenticationManager;
import Service.impl.UserServiceImpl;
import ServiceObjects.Basket;
import dto.ProductDTO;
import dto.UserDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aleksandrdolmatov on 21.01.17.
 */
public class LoginServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {

        try

        {


            String login = request.getParameter("userName");
            String password = request.getParameter("password");




            if (AuthenticationManager.Authentication(login, password))
            {


                UserServiceImpl userService = new UserServiceImpl();
                UserDTO userDTO = userService.findByLogin(login);
                HttpSession session = request.getSession(true);
               session.setAttribute("currentSessionUser", userDTO);
                Basket basket = new Basket();
                basket.setUserID(userDTO.getId());
                List<ProductDTO> productDTOList = new ArrayList<>();
                basket.setProducts(productDTOList);
                session.setAttribute("basket", basket);
                response.sendRedirect("UserLogged.jsp"); //logged-in page
            }

            else
                response.sendRedirect("InvalidLogin.jsp"); //error page
        }


        catch (Throwable theException)
        {
            System.out.println(theException);
        }
    }

}


