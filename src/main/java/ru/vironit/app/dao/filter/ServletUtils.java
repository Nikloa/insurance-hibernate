package ru.vironit.app.dao.filter;

import ru.vironit.app.dao.implementation.AdminImplementation;
import ru.vironit.app.dao.implementation.ClientImplementation;
import ru.vironit.app.dao.implementation.InsurerImplementation;
import ru.vironit.app.entities.*;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.SQLException;

public class ServletUtils {
    public static final String ATT_NAME_CONNECTION = "ATTRIBUTE_FOR_CONNECTION";
    private static final String ATT_NAME_USER_EMAIL = "ATTRIBUTE_FOR_STORE_EMAIL_IN_COOKIE";
    private static final String ATT_NAME_USER_PASSWORD = "ATTRIBUTE_FOR_STORE_PASSWORD_IN_COOKIE";
    private static final String ATT_NAME_USER_ROLE = "ATTRIBUTE_FOR_STORE_USER_ROLE_IN_COOKIE";

    // Сохранить Connection в attribute в request.
    // Данная информация хранения существует только во время запроса (request)
    // до тех пор, пока данные возвращаются приложению пользователя.
    public static void storeConnection(ServletRequest request, Connection conn) {
        request.setAttribute(ATT_NAME_CONNECTION, conn);
    }


    // Получить объект Connection сохраненный в attribute в request.
    public static Connection getStoredConnection(ServletRequest request) {
        Connection conn = (Connection) request.getAttribute(ATT_NAME_CONNECTION);
        return conn;
    }

    // Сохранить информацию пользователя, который вошел в систему (login) в Session.
    public static void storeLoggedUser(HttpSession session, String email, String password, String role) {
        // В JSP можно получить доступ через ${loggedUser}

        try {
            switch (role) {
                case "ADMIN": {
                    Admin loggedUser = new AdminImplementation().loginAdmin(email, password);
                    loggedUser.setRole(Role.ADMIN);
                    session.setAttribute("loggedUser", loggedUser);
                    if(loggedUser != null) {
                        System.out.println("ServletUtils -admin- ----- " + loggedUser.toString());}
                    break;
                }
                case "INSURER": {
                    Insurer loggedUser = new InsurerImplementation().loginInsurer(email, password);
                    loggedUser.setRole(Role.INSURER);
                    session.setAttribute("loggedUser", loggedUser);
                    if(loggedUser != null) {
                        System.out.println("ServletUtils -insurer- ----- " + loggedUser.toString());}
                    break;
                }
                case "CLIENT": {
                    Client loggedUser = new ClientImplementation().loginClient(email, password);
                    if(loggedUser != null) {
                    System.out.println(loggedUser);
                    loggedUser.setRole(Role.CLIENT);
                        System.out.println("ServletUtils -client- ----- " + loggedUser.toString());}
                    session.setAttribute("loggedUser", loggedUser);
                    break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void deleteLoggedUser(HttpSession session) {
        // В JSP можно получить доступ через ${loggedUser}
        session.setAttribute("loggedUser", null);
            System.out.println("ServletUtils ----- DELETED");
    }

    // Получить информацию пользователя, сохраненная в Session.
    public static User getLoggedUser(HttpSession session) {
        User loggedUser = (User) session.getAttribute("loggedUser");
        return loggedUser;
    }

    // Сохранить информацию пользователя в Cookie.
    public static void storeUserCookie(HttpServletResponse response, String email, String password, String role) {
        System.out.println("Store user cookie");
        Cookie cookieUserEmail = new Cookie(ATT_NAME_USER_EMAIL, email);
        Cookie cookieUserPassword = new Cookie(ATT_NAME_USER_PASSWORD, password);
        Cookie cookieUserRole = new Cookie(ATT_NAME_USER_ROLE, role);
        // 1 день (Конвертированный в секунды)
        cookieUserEmail.setMaxAge(/*24 */ 60 * 60);
        cookieUserPassword.setMaxAge(/*24 */ 60 * 60);
        cookieUserRole.setMaxAge(/*24 */ 60 * 60);
        response.addCookie(cookieUserEmail);
        response.addCookie(cookieUserPassword);
        response.addCookie(cookieUserRole);
    }

    public static String getUserEmailInCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (ATT_NAME_USER_EMAIL.equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    public static String getUserRoleInCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (ATT_NAME_USER_ROLE.equals(cookie.getName())) {
                    System.out.println("GetCookie " + cookie.getValue());
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    public static String getUserPasswordInCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (ATT_NAME_USER_PASSWORD.equals(cookie.getName())) {
                    System.out.println("GetCookie " + cookie.getValue());
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    // Удалить Cookie пользователя
    public static void deleteUserCookie(HttpServletResponse response, HttpSession session) {
        session.setAttribute("COOKIE_CHECKED", null);
        Cookie cookieUserEmail = new Cookie(ATT_NAME_USER_EMAIL, null);
        Cookie cookieUserPassword = new Cookie(ATT_NAME_USER_PASSWORD, null);
        Cookie cookieUserRole = new Cookie(ATT_NAME_USER_ROLE, null);
        // 0 секунд. (Данный Cookie будет сразу недействителен)
        cookieUserEmail.setMaxAge(0);
        cookieUserPassword.setMaxAge(0);
        cookieUserRole.setMaxAge(0);
        response.addCookie(cookieUserEmail);
        response.addCookie(cookieUserPassword);
        response.addCookie(cookieUserRole);
    }

}
