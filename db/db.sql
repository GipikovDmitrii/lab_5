CREATE DATABASE task_manager ENCODING 'UTF8';

CREATE TABLE IF NOT EXISTS roles (
  role_id SERIAL PRIMARY KEY,
  role VARCHAR(5) NOT NULL
);

CREATE TABLE IF NOT EXISTS users (
  user_id SERIAL PRIMARY KEY,
  login VARCHAR (20) NOT NULL UNIQUE,
  email VARCHAR (30) NOT NULL UNIQUE,
  password VARCHAR (20) NOT NULL,
  role INTEGER NOT NULL,
  FOREIGN KEY (role) REFERENCES roles(role_id)
);

CREATE TABLE IF NOT EXISTS tasks (
  task_id SERIAL PRIMARY KEY,
  title VARCHAR(100) NOT NULL,
  description VARCHAR(250),
  createdDate TIMESTAMP NOT NULL,
  endDate TIMESTAMP NOT NULL,
  user_id INTEGER NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);

INSERT INTO roles (role_id, role) VALUES (DEFAULT, 'admin');
INSERT INTO roles (role_id, role) VALUES (DEFAULT, 'user');

--test data

INSERT INTO users (user_id, login, email, password, role) VALUES (DEFAULT, 'admin', 'admin@ya.ru', 'admin', 1);

