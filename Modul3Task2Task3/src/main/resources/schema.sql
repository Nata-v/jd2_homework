CREATE DATABASE IF NOT EXISTS ListExpenses;

USE ListExpenses;

CREATE TABLE IF NOT EXISTS receivers (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(256) NOT NULL
);

CREATE TABLE IF NOT EXISTS expenses (
  id INT PRIMARY KEY AUTO_INCREMENT,
 payment_date DATE NOT NULL,
  receivers_id INT,
  amount DECIMAL(10,2),
  FOREIGN KEY (receivers_id) REFERENCES receivers (id)
);


CREATE TABLE IF NOT EXISTS deleted_expenses (
  id INT PRIMARY KEY AUTO_INCREMENT,
 payment_date DATE NOT NULL,
  receiver_id INT,
  total_amount DECIMAL(10,2)
);

INSERT INTO receivers(name) VALUES ('MTC');
INSERT INTO receivers(name) VALUES ('A1');
INSERT INTO receivers (name)VALUES ('Life');
INSERT INTO receivers (name)VALUES ('Telekom');



INSERT INTO expenses (payment_date,receivers_id, amount)VALUES ('2022-05-10', 1, 20000);
INSERT INTO expenses (payment_date,receivers_id, amount) VALUES ('2022-06-23', 2,48000);
INSERT INTO expenses (payment_date,receivers_id, amount) VALUES ('2022-05-11', 4,30000);
INSERT INTO expenses (payment_date,receivers_id, amount) VALUES ('2022-03-12', 1, 70000);
INSERT INTO expenses (payment_date,receivers_id, amount)VALUES ('2022-04-12',3,90000);

CREATE TRIGGER expenses_trigger
BEFORE DELETE ON expenses
FOR EACH ROW
BEGIN
    DECLARE total_amount DECIMAL(10, 2);
    DECLARE receiver_name VARCHAR(256);

    SELECT SUM(amount) INTO total_amount FROM expenses WHERE receivers_id = OLD.receivers_id;
    SELECT name INTO receiver_name FROM receivers WHERE id = OLD.receivers_id;


    INSERT INTO deleted_expenses (payment_date, receiver_name, total_amount) VALUES (OLD.payment_date, receiver_name, total_amount);
END;