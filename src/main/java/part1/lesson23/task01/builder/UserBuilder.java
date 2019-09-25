package part1.lesson23.task01.builder;

import part1.lesson23.task01.entity.Role;
import part1.lesson23.task01.entity.User;

public class UserBuilder {

    private User user;

    private UserBuilder(User user) {
        this.user = user;
    };

    public static UserBuilder createUser() {
        return new UserBuilder(new User());
    }

    public UserBuilder withId(int id) {
        user.setId(id);
        return this;
    }

    public UserBuilder withLogin(String login) {
        user.setLogin(login);
        return this;
    }

    public UserBuilder withPassword(String password) {
        user.setPassword(password);
        return this;
    }

    public UserBuilder withPassword(Role role) {
        user.setRole(role);
        return this;
    }

    public User build(){
        return user;
    }
}
