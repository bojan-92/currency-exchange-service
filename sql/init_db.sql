CREATE DATABASE IF NOT EXISTS ces_db;

CREATE TABLE IF NOT EXISTS ces_db.currency_exchange
(
    id INT NOT NULL PRIMARY KEY auto_increment,
    currency_from VARCHAR (255) NOT NULL ,
    currency_to VARCHAR (255) NOT NULL ,
    environment VARCHAR (255)  ,
    conversation_multiple DOUBLE NOT NULL
);

INSERT INTO ces_db.currency_exchange (id, currency_from, currency_to, conversation_multiple, environment)
values (1, 'USD', 'INR', 65, '');

insert into ces_db.currency_exchange (id, currency_from, currency_to, conversation_multiple, environment)
values (2, 'EUR', 'INR', 75, '');

insert into ces_db.currency_exchange (id, currency_from, currency_to, conversation_multiple, environment)
values (3, 'AUD', 'INR', 25, '');