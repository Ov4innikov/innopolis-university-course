package part1.lesson15.task01.model;

import lombok.Builder;
import lombok.Data;
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
