package part1.lesson15.task01;

import part1.lesson15.task01.dao.UserDAO;
import part1.lesson15.task01.model.User;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Класс для демонстрации.
 * @author  Овчинников Евгений
 */
public class Application {

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
        System.out.println("Пункт 2.а");
        userDAO.insertUser(user);
        System.out.println("Пункт 2.б");
        userDAO.insertFixedUsersByBatch();
        System.out.println("Пункт 3");
        userDAO.getUsersByLoginIdAndName(10, "Martin");
        System.out.println("Пункт 4.а");
        userDAO.insertFixDataWithFalseAutoCommitAndSetSavePointOk();
        System.out.println("Пункт 4.б");
        userDAO.insertFixDataWithFalseAutoCommitAndSetSavePointError();
    }

}
