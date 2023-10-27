CREATE DATABASE IF NOT EXISTS paymentDB;

USE paymentDB;
CREATE TABLE IF NOT EXISTS recipients (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(128) NOT NULL
);

CREATE TABLE IF NOT EXISTS payments (
  id INT PRIMARY KEY AUTO_INCREMENT,
 payment_date DATE NOT NULL,
  recipients_id INT,
  amount DECIMAL(10,2),
  FOREIGN KEY (recipients_id) REFERENCES recipients (id)
);

INSERT INTO recipients(name) VALUES ('MTC');
INSERT INTO recipients(name) VALUES ('A1');
INSERT INTO recipients (name)VALUES ('Life');
INSERT INTO recipients (name)VALUES ('Telekom');



INSERT INTO payments (payment_date,recipients_id, amount)VALUES ('2022-05-10', 1, 20000);
INSERT INTO payments (payment_date,recipients_id, amount) VALUES ('2022-06-23', 2,48000);
INSERT INTO payments (payment_date,recipients_id, amount) VALUES ('2022-05-11', 4,30000);
INSERT INTO payments (payment_date,recipients_id, amount) VALUES ('2022-03-12', 1, 70000);
INSERT INTO payments (payment_date,recipients_id, amount)VALUES ('2022-04-12',3,90000);

