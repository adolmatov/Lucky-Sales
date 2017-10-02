package Servlets.UserServlets;

import dto.UserDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by aleksandrdolmatov on 26.01.17.
 */
public class RightsCheck extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {
        HttpSession session = request.getSession(false);
        System.out.println(request.isRequestedSessionIdFromCookie());
        System.out.println(request.isRequestedSessionIdValid());
        if(session!=null){


        if(session.getAttribute("currentSessionUser").getClass().equals(UserDTO.class)) {
            response.sendRedirect("RigthsCheck.jsp");
        }
        }else response.sendRedirect("invalidation.jsp");



    }
}
