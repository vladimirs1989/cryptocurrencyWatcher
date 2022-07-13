/*
DROP TABLE IF EXISTS users;
*/

CREATE TABLE IF NOT EXISTS users(
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(255),
    userchosesymbol VARCHAR(255),
    pricecurrency DECIMAL (6,2) DEFAULT 0.0 NOT NULL
);

/*
TRUNCATE users CASCADE
*/

INSERT INTO users (username, userchosesymbol, pricecurrency)
VALUES ('Volkov', 'BTC', 12.25),
       ('Zaycev', 'ETH', 5.65),
       ('Gusev', 'BTC', 65.21),
       ('Kotov', 'SOL', 10.5);








/*
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS roles;
*/


CREATE TABLE IF NOT EXISTS roles(
    id BIGSERIAL PRIMARY KEY,
    role VARCHAR(255)
);

CREATE TABLE  IF NOT EXISTS users(
    id BIGSERIAL PRIMARY KEY,
    lastName VARCHAR(255) NOT NULL,
    firstName VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    login VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    age INTEGER,
    roles INTEGER,
    deleted BOOLEAN DEFAULT false NOT NULL,
    "active" BOOLEAN DEFAULT true NOT NULL
);

/*
TRUNCATE users CASCADE;
TRUNCATE roles CASCADE;
*/

INSERT INTO roles (role)
VALUES ('ADMIN'),
       ('MANAGER'),
       ('CUSTOMER');

INSERT INTO users (lastName, firstName, email, login, password, age, roles)
VALUES ('Ivanov', 'Ivan', 'Ivanov@gmail.com', 'Ivan1', 'I1', 33, 0),
       ('Petrov', 'Petr', 'Petrov@gmail.com', 'Petr1', 'P1', 30, 1),
       ('Sidorov', 'Ivan', 'Sidorov@gmail.com', 'Ivan2', 'I2', 25, 1),
       ('Volkov', 'Gena', 'Volkov@gmail.com', 'Gena1', 'G1', 41, 1),
       ('Zaycev', 'Vasya', 'Zaycev@gmail.com', 'Vasya', 'IV1', 63, 1),
       ('Gusev', 'John', 'Gusev@gmail.com', 'John1', 'J1', 12, 2),
       ('Lisov', 'Yan', 'Lisov@gmail.com', 'Yan1', 'Y1', 62, 2),
       ('Krotov', 'Pavel', 'Krotov@gmail.com', 'Pavel1', 'P1', 11, 2),
       ('Ladov', 'Sahsa', 'Ladov@gmail.com', 'Sahsa1', 'S1', 25, 2),
       ('Dubov', 'Dima', 'Dubov@gmail.com', 'Dima1', 'D1', 16, 2),
       ('Sadov', 'Kolya', 'Sadov@gmail.com', 'Kolya1', 'K1', 25, 2),
       ('Medov', 'Vitia', 'Medov@gmail.com', 'Vitia1', 'V1', 36, 2),
       ('Hudov', 'Jane', 'Hudov@gmail.com', 'Jane1', 'J1', 23, 2),
       ('Kotov', 'Murzik', 'Kotov@gmail.com', 'Murzik1', 'M1', 453,2),
       ('Somov', 'Dima', 'Somov@gmail.com', 'Dima2', 'D2', 12, 2),
       ('Urov', 'Ivan', 'Urov@gmail.com', 'Ivan3', 'I3', 56, 2),
       ('Saharov', 'Gena', 'Saharov@gmail.com', 'Gena2', 'G2', 573, 2),
       ('Podov', 'Misha', 'Podov@gmail.com', 'Misha1', 'M1', 52, 2),
       ('Futov', 'Sasha', 'Futov@gmail.com', 'Sasha2', 'S2', 22, 2),
	   ('Klimov', 'Oleg', 'Klimov@gmail.com', 'Oleg1', 'O1', 42, 2);

/*
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS statuses;
*/


CREATE TABLE IF NOT EXISTS statuses(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS orders(
    id BIGSERIAL PRIMARY KEY,
    user_id BIGSERIAL REFERENCES users,
    total_cost DECIMAL (6,2) DEFAULT 0.0 NOT NULL,
    timestamp DATE NOT NULL,
    status INTEGER,
    deleted BOOLEAN DEFAULT false NOT NULL
);

/*
TRUNCATE orders CASCADE;
TRUNCATE statuses CASCADE;
*/

INSERT INTO statuses (name)
VALUES ('CANCEL'),
       ('PAID'),
       ('NOT_PAID');

INSERT INTO orders (user_id, total_cost, timestamp, status)
VALUES ('5', 179.29, '2021-12-02', 2),
       ('8', 175.25, '2022-01-12', 1),
       ('9', 105.00, '2022-03-15', 2),
       ('1', 13.00, '2022-04-08', 1),
       ('12', 63.46, '2022-05-11', 0);

/*
DROP TABLE IF EXISTS order_items;
*/


CREATE TABLE IF NOT EXISTS order_items(
    id BIGSERIAL PRIMARY KEY,
    order_id BIGSERIAL REFERENCES orders,
    book_id BIGSERIAL REFERENCES books,
    quantity BIGINT DEFAULT 1,
    price DECIMAL (6,2)
);

/*
TRUNCATE order_items CASCADE;
*/


INSERT INTO order_items (order_id, book_id, quantity,  price)
VALUES (1, 12, 1, (SELECT price FROM books WHERE id = 12)),
       (1, 2, 1, (SELECT price FROM books WHERE id = 2)),
       (2, 6, 2, (SELECT price FROM books WHERE id = 6)),
       (2, 4, 1, (SELECT price FROM books WHERE id = 4)),
       (2, 1, 1, (SELECT price FROM books WHERE id = 1)),
       (3, 4, 2, (SELECT price FROM books WHERE id = 4)),
       (3, 9, 1, (SELECT price FROM books WHERE id = 9)),
       (4, 11, 1, (SELECT price FROM books WHERE id = 11)),
       (5, 16, 1, (SELECT price FROM books WHERE id = 16));