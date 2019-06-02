package part1.lesson17.task01;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import part1.lesson17.task01.dao.UserDAO;
import part1.lesson17.task01.model.User;

import java.sql.Date;
import java.text.ParseException;

/**
 * Класс для демонстрации.
 * @author  Овчинников Евгений
 */
public class Application {

    private static final Logger logger = LogManager.getLogger(Application.class);

    public static void main(String[] args) throws ParseException, ClassNotFoundException {
        UserDAO userDAO = new UserDAO();
        User user = User.builder()
                .id(10)
                .name("Martin")
                .birthday(Date.valueOf("2019-02-22"))
                .city("Vladivostok")
                .email("martin@yandex.ru")
                .description("User 10")
                .build();
        logger.info("Пункт 2.а");
        userDAO.insertUser(user);
        logger.info("Пункт 2.б");
        userDAO.insertFixedUsersByBatch();
        logger.info("Пункт 3");
        userDAO.getUsersByLoginIdAndName(10, "Martin");
        logger.info("Пункт 4.а");
        userDAO.insertFixDataWithFalseAutoCommitAndSetSavePointOk();
        logger.info("Пункт 4.б");
        userDAO.insertFixDataWithFalseAutoCommitAndSetSavePointError();
    }

}
