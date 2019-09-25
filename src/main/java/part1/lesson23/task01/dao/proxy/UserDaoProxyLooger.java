package part1.lesson23.task01.dao.proxy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import part1.lesson23.task01.dao.UserDAO;
import part1.lesson23.task01.entity.User;
import part1.lesson23.task01.service.StrategyOfLogging;

public class UserDaoProxyLooger implements UserDAO {

    private static final Logger logger = LogManager.getLogger(UserDaoProxyLooger.class.getName());

    private UserDAO userDAO;

    private StrategyOfLogging strategyOfLogging;

    public UserDaoProxyLooger(UserDAO userDAO, StrategyOfLogging strategyOfLogging) {
        this.userDAO = userDAO;
        this.strategyOfLogging = strategyOfLogging;
    }

    @Override
    public User getById(int id) {
        strategyOfLogging.log(logger, Integer.valueOf(id).toString());
        return userDAO.getById(id);
    }

    @Override
    public User getUserByLogin(String login) {
        logger.info(login);
        strategyOfLogging.log(logger, login);
        return userDAO.getUserByLogin(login);
    }

    @Override
    public boolean loginAndPasswordIsTrue(String login, String password) {
        strategyOfLogging.log(logger, login + " " + password);
        return userDAO.loginAndPasswordIsTrue(login, password);
    }
}
