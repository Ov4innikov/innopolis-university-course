package part1.lesson22.task01.servlet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import part1.lesson22.task01.dao.ConnectionManager;
import part1.lesson22.task01.dao.jdbc.DBConnectionManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.SQLException;

@WebListener
public class AppContextListener implements ServletContextListener {
    private static final Logger logger = LogManager.getLogger(AppContextListener.class.getName());
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext ctx = sce.getServletContext();

        String dbURL = ctx.getInitParameter("dbURL");
        String user = ctx.getInitParameter("dbUser");
        String pwd = ctx.getInitParameter("dbPassword");

        try {
            final String dbInit = ";INIT=RUNSCRIPT FROM '" + ctx.getRealPath("/db/data.sql").replace("\\", "/") + "';";
            ConnectionManager connectionManager = new DBConnectionManager(dbURL + dbInit, user, pwd);
            ctx.setAttribute("DBConnection", connectionManager.getConnection());
            System.out.println("DB Connection initialized successfully.");
        } catch (ClassNotFoundException | SQLException e) {
            logger.error("An error occurred while initializing the database connection.", e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        Connection con = (Connection) sce.getServletContext().getAttribute("DBConnection");
        try {
            con.close();
        } catch (SQLException e) {
            logger.error("An error occurred while closing the database connection.", e);
        }
    }
}
