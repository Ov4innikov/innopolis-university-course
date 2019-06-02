package part1.lesson16.task01.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class UserRole {

    private int id;
    private int userId;
    private int roleId;
}
