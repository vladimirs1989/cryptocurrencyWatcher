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
DROP TABLE IF EXISTS prices;
*/

CREATE TABLE IF NOT EXISTS prices(
    id BIGSERIAL PRIMARY KEY,
    request_time DATE NOT NULL,
    price_btc DECIMAL (6,2) DEFAULT 0.0 NOT NULL,
    price_eth DECIMAL (6,2) DEFAULT 0.0 NOT NULL,
    price_sol DECIMAL (6,2) DEFAULT 0.0 NOT NULL
);

/*
TRUNCATE prices CASCADE
*/

INSERT INTO prices (request_time, price_btc, price_eth, price_sol)
VALUES ('2021-12-02', 10.4, 8.6, 12.25),
       ('2021-12-02', 10.2, 8.4, 12.0),
       ('2021-12-02', 10.0, 8.4, 12.1),
       ('2021-12-02', 10.1, 8.45, 12.05);

/*
DROP TABLE IF EXISTS crypto;
*/

CREATE TABLE IF NOT EXISTS crypto(
    id INTEGER PRIMARY KEY,
    symbol VARCHAR(255)
);

/*
TRUNCATE crypto CASCADE
*/

INSERT INTO crypto (id, symbol)
VALUES (90, 'BTC'),
       (80, 'ETH'),
       (48543, 'SOL');

/*
DROP TABLE IF EXISTS price_btc;
*/

CREATE TABLE IF NOT EXISTS price_btc(
    id BIGSERIAL PRIMARY KEY,
    request_time TIMESTAMP,
    price_btc DECIMAL
);

/*
TRUNCATE price_btc CASCADE
*/

/*
DROP TABLE IF EXISTS price_eth;
*/

CREATE TABLE IF NOT EXISTS price_eth(
    id BIGSERIAL PRIMARY KEY,
    request_time TIMESTAMP,
    price_eth DECIMAL
);

/*
TRUNCATE price_eth CASCADE
*/

/*
DROP TABLE IF EXISTS price_sol;
*/

CREATE TABLE IF NOT EXISTS price_sol(
    id BIGSERIAL PRIMARY KEY,
    request_time TIMESTAMP,
    price_sol DECIMAL
);

/*
TRUNCATE price_sol CASCADE
*/




