DROP TABLE IF EXISTS "user";

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    uuid varchar(255) NOT NULL,
    email varchar(255) NOT NULL,
    password varchar(255) NOT NULL,
    name varchar(255),
    image varchar(255),
    level INT DEFAULT 1
);

INSERT INTO users(email, password, name, image) VALUES ('asd.asd@asd.asd', 'asd', 'asd', '//');

{
    "loginName": "asd",
    "email": "asd.asd@asd.asd",
    "password": "asd123",
    "name": "asdasd",
    "image": "//",
    "level": "0"
}