CREATE TABLE person
(
    id         INT NOT NULL AUTO_INCREMENT,
    name       VARCHAR(250),
    birth_date DATE
);

CREATE TABLE user
(
    id         INT NOT NULL AUTO_INCREMENT,
    login      VARCHAR(250),
    password   VARCHAR(250),
    role       VARCHAR(250)
);

INSERT INTO person (name, birth_date) VALUES ( 'Mark', '1994-04-23' ), ( 'Max', '1882-11-14'), ('Vadim', '1989-01-22');
INSERT INTO user (login, password, role) VALUES ( 'admin', 'admin', 'ADMIN'), ( 'user', 'user', 'USER');