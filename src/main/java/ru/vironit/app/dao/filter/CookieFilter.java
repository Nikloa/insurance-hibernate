package ru.vironit.app.dao.filter;

import ru.vironit.app.dao.implementation.ClientImplementation;
import ru.vironit.app.dao.interfaces.ConnectionPool;
import ru.vironit.app.dao.utils.DatabasePool;
import ru.vironit.app.entities.Client;
import ru.vironit.app.entities.Role;
import ru.vironit.app.entities.User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "cookieFilter", urlPatterns = { "/*" })
public class CookieFilter implements Filter {
    public CookieFilter() {
    }

    @Override
    public void init(FilterConfig fConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();

        User userInSession = ServletUtils.getLoggedUser(session);
        //
        if (userInSession != null) {
            session.setAttribute("COOKIE_CHECKED", "CHECKED");
            chain.doFilter(request, response);
            System.out.println("cookie filter do filter get logged user in session " + userInSession.toString());
            return;
        }

        // Connection создан в JDBCFilter.
        //Connection conn = ServletUtils.getStoredConnection(request);

        Connection conn = null;
        ConnectionPool pull = null;
        try {
            pull = DatabasePool.getConnectionPool();
            conn = pull.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Флаг(flag) для проверки Cookie.
        String checked = (String) session.getAttribute("COOKIE_CHECKED");
        String email = ServletUtils.getUserEmailInCookie(req);
        String role = ServletUtils.getUserRoleInCookie(req);
        System.out.println(checked + conn + email + role);
        if (checked == null && conn != null && email != null && role != null) {
            System.out.println("GO TO STORED");
            ServletUtils.storeLoggedUser(session, email, role);
            // Отметить проверенные Cookie.
            session.setAttribute("COOKIE_CHECKED", "CHECKED");
            System.out.println("CHECKED FILTER");
        }
        pull.releaseConnection(conn);
        chain.doFilter(request, response);
    }
}
