package part1.lesson17.task01.model;

import lombok.*;

import java.sql.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class User {

    private int id;
    private String name;
    private Date birthday;
    private int loginId;
    private String city;
    private String email;
    private String description;

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name='" + name + '\'' + ", birthday=" + birthday + ", loginId=" + loginId + ", city='" + city + '\'' + ", email='" + email + '\'' + ", description='" + description + '\'' + '}';
    }
}
