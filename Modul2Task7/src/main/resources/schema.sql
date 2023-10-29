CREATE DATABASE IF NOT EXISTS ListExpenses;

USE ListExpenses;

CREATE TABLE IF NOT EXISTS receivers (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(256) NOT NULL
);

CREATE TABLE IF NOT EXISTS expenses (
  id INT PRIMARY KEY AUTO_INCREMENT,
 payment_date DATE NOT NULL,
  receiver_id INT,
  amount DECIMAL(10,2),
  FOREIGN KEY (receiver_id) REFERENCES receivers (id)
);

INSERT INTO receivers(name) VALUES ('MTC');
INSERT INTO receivers(name) VALUES ('A1');
INSERT INTO receivers (name)VALUES ('Life');
INSERT INTO receivers (name)VALUES ('Telekom');



INSERT INTO expenses (payment_date,receiver_id, amount)VALUES ('2022-05-10', 1, 20000);
INSERT INTO expenses (payment_date,receiver_id, amount) VALUES ('2022-06-23', 2,48000);
INSERT INTO expenses (payment_date,receiver_id, amount) VALUES ('2022-05-11', 4,30000);
INSERT INTO expenses (payment_date,receiver_id, amount) VALUES ('2022-03-12', 1, 70000);
INSERT INTO expenses (payment_date,receiver_id, amount)VALUES ('2022-04-12',3,90000);