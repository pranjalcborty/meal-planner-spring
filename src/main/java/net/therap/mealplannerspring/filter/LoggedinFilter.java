package net.therap.mealplannerspring.filter;

import net.therap.mealplannerspring.helper.Constants;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author pranjal.chakraborty
 * @since 20-May-17
 */
public class LoggedinFilter implements Filter {

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws ServletException, IOException {

        HttpSession session = ((HttpServletRequest) req).getSession();
        String path = ((HttpServletRequest) req).getRequestURI();

        if (isLoggedIn(session) || (path.contains(Constants.ASSETS_PATH)) || path.contains(Constants.REGISTER_PATH)) {
            chain.doFilter(req, resp);
        } else {
            req.getRequestDispatcher(Constants.LOGIN_PATH).forward(req, resp);
        }
    }

    private boolean isLoggedIn(HttpSession session) {
        return session.getAttribute(Constants.USER_NAME) != null;
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
