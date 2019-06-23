package part1.lesson23.task01.filter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import part1.lesson23.task01.dao.UserDAO;
import part1.lesson23.task01.dao.jdbc.UserDAOImpl;
import part1.lesson23.task01.dao.proxy.UserDaoProxyLooger;
import part1.lesson23.task01.entity.Role;
import part1.lesson23.task01.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;

import static java.util.Objects.nonNull;

/**
 * Фильтр для аутентификации.
 *
 * @autor Овчинников Евгений
 */
@WebFilter(displayName = "AuthFilter", urlPatterns = "/*")
public class AuthFilter implements Filter {

    private static final Logger logger = LogManager.getLogger(AuthFilter.class);

    private UserDAO userDAO;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        userDAO = new UserDaoProxyLooger(new UserDAOImpl((Connection) filterConfig.getServletContext().getAttribute("DBConnection")));
    }

    @Override
    public void doFilter(final ServletRequest request,
                         final ServletResponse response,
                         final FilterChain filterChain)

            throws IOException, ServletException {

        final HttpServletRequest req = (HttpServletRequest) request;
        final HttpServletResponse res = (HttpServletResponse) response;

        final String login = req.getParameter("login");
        final String password = req.getParameter("password");
        final HttpSession session = req.getSession();

        logger.info("login:{}, password:{}", login, password);
        //Logged user.
        if (nonNull(session) &&
                nonNull(session.getAttribute("login")) &&
                nonNull(session.getAttribute("password"))) {
            logger.info("Success session");
            final Role role = (Role) session.getAttribute("role");

            filterChain.doFilter(req, res);
        } else if (userDAO.loginAndPasswordIsTrue(login, password)) {
            logger.info("Create session");
            final Role role = userDAO.getUserByLogin(login).getRole();
            req.getSession().setAttribute("password", password);
            req.getSession().setAttribute("login", login);
            req.getSession().setAttribute("role", role);

            filterChain.doFilter(req, res);
        } else {
            logger.info("Fail session");
            moveToMenu(req, res, Role.UNKNOWN);
        }
    }

    /**
     * Move user to menu.
     * If access 'admin' move to admin menu.
     * If access 'user' move to user menu.
     */
    private void moveToMenu(final HttpServletRequest req,
                            final HttpServletResponse res,
                            final Role role)
            throws ServletException, IOException {
            req.getRequestDispatcher("/login.jsp").forward(req, res);
    }

    @Override
    public void destroy() {
    }
}