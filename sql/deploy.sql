/*
DROP TABLE IF EXISTS users;
*/

CREATE TABLE IF NOT EXISTS users(
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(255),
    userchosesymbol VARCHAR(255),
    pricecurrency DECIMAL
);

/*
TRUNCATE users CASCADE
*/

INSERT INTO users (username, userchosesymbol, pricecurrency)
VALUES ('Volkov', 'BTC', 20528.30),
       ('Zaycev', 'ETH', 1175.13),
       ('Gusev', 'BTC', 20527.10),
       ('Kotov', 'SOL', 35.98);

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




