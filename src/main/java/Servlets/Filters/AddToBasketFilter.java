package Servlets.Filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by aleksandrdolmatov on 15.02.17.
 */
public class AddToBasketFilter implements Filter {
    private ServletContext context;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.context = filterConfig.getServletContext();
        this.context.log("AddToBasketFilter initialized");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        String uri = httpServletRequest.getRequestURL().toString();
        this.context.log("Requested resource:"+uri);
        System.out.println(uri);
        RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher("/add");
        requestDispatcher.include(httpServletRequest, httpServletResponse);

    }

    @Override
    public void destroy() {

    }
}
