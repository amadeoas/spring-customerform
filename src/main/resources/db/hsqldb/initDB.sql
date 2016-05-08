DROP TABLE customers IF EXISTS;


CREATE TABLE customers (
  id         	INTEGER IDENTITY PRIMARY KEY,
  first_name 	VARCHAR(30),
  last_name  	VARCHAR(30)
);
CREATE INDEX customers_last_name ON customers (last_name);
