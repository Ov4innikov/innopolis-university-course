package part1.lesson22.task01.dao;

import part1.lesson22.task01.entity.User;

public interface UserDAO {

    public User getById(int id);
    public User getUserByLogin(final String login);
    public boolean loginAndPasswordIsTrue(final String login, final String password);
}
