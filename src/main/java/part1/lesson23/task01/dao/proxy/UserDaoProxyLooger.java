package part1.lesson23.task01.dao.proxy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import part1.lesson23.task01.dao.UserDAO;
import part1.lesson23.task01.entity.User;
import part1.lesson23.task01.listener.AppContextListener;

public class UserDaoProxyLooger implements UserDAO {

    private static final Logger logger = LogManager.getLogger(UserDaoProxyLooger.class.getName());

    private UserDAO userDAO;

    public UserDaoProxyLooger(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public User getById(int id) {
        logger.info(id);
        return userDAO.getById(id);
    }

    @Override
    public User getUserByLogin(String login) {
        logger.info(login);
        return userDAO.getUserByLogin(login);
    }

    @Override
    public boolean loginAndPasswordIsTrue(String login, String password) {
        logger.info(login, password);
        return userDAO.loginAndPasswordIsTrue(login, password);
    }
}
