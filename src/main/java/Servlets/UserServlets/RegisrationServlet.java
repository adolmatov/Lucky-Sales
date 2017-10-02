package Servlets.UserServlets;

import dao.impl.UserDaoImpl;
import dto.UserDTO;
import Helper.Transformer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by aleksandrdolmatov on 21.01.17.
 */
public class RegisrationServlet extends HttpServlet {

        public void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, java.io.IOException {

           try {

                UserDTO userDTO = new UserDTO();
                userDTO.setName(request.getParameter("name"));
                userDTO.setLogin(request.getParameter("login"));
                userDTO.setPassword(request.getParameter("password"));


             UserDaoImpl.getInstance().create(Transformer.transformUserDTOtoUser(userDTO));
               response.sendRedirect("RegistrationComplete.jsp");

            }


            catch(Throwable theException)
            {
                System.out.println(theException);
            }

        }

    }
