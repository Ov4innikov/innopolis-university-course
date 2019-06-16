CREATE TABLE person
(
    id         INT NOT NULL AUTO_INCREMENT,
    name       VARCHAR(250),
    birth_date DATE,
    email      VARCHAR(250),
    phone      VARCHAR(30)
);

CREATE TABLE user
(
    id         INT NOT NULL AUTO_INCREMENT,
    login      VARCHAR(250),
    password   VARCHAR(250),
    role       VARCHAR(250)
);

INSERT INTO person (name, birth_date, email, phone) VALUES ( 'Mark', '1994-04-23', 'mark@mail.ru', '+323444' ), ( 'Max', '1882-11-14', 'max@yandex.ru', '+79812898' ), ('Vadim', '1989-01-22', 'vadim@gmail.com', '+789189');
INSERT INTO user (login, password, role) VALUES ( 'admin', 'admin', 'ADMIN'), ( 'user', 'user', 'USER');