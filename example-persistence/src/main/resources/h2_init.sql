CREATE TABLE IF NOT EXISTS users (
  id IDENTITY PRIMARY KEY,
  username VARCHAR(127) NOT NULL,
  encoded_password VARCHAR(255) NOT NULL
);

CREATE SEQUENCE IF NOT EXISTS seq_users
START WITH 1
INCREMENT BY 1;

INSERT INTO users (
  id,
  username,
  encoded_password
) VALUES (
  seq_users.nextval,
  'admin',
  '$2a$10$n6c3oi7iMmnTFULdo08yd.NL2JW00HxIUOcayFi9iOR7K/x./PLmy'
);

CREATE TABLE IF NOT EXISTS customers (
  id IDENTITY PRIMARY KEY,
  first_name VARCHAR(127) NOT NULL,
  last_name VARCHAR(127) NOT NULL
);

CREATE SEQUENCE IF NOT EXISTS seq_customers
START WITH 1
INCREMENT BY 1;

COMMIT;
