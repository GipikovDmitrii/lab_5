CREATE DATABASE task_manager ENCODING 'UTF8';

CREATE TABLE IF NOT EXISTS roles (
  role_id SERIAL PRIMARY KEY,
  role VARCHAR(5) NOT NULL
);

INSERT INTO roles (role_id, role) VALUES (DEFAULT, 'admin');
INSERT INTO roles (role_id, role) VALUES (DEFAULT, 'user');

CREATE TABLE IF NOT EXISTS users (
  user_id SERIAL PRIMARY KEY,
  login VARCHAR (20) NOT NULL UNIQUE ,
  password VARCHAR (20) NOT NULL,
  role INTEGER NOT NULL,
  FOREIGN KEY (role) REFERENCES roles(role_id)
);

INSERT INTO users (user_id, login, password, role) VALUES (DEFAULT, 'admin', 'ytrewq', 1);

CREATE TABLE IF NOT EXISTS tasks (
  task_id SERIAL PRIMARY KEY,
  title VARCHAR(100) NOT NULL,
  description VARCHAR(250),
  createdDate TIMESTAMP NOT NULL,
  endDate TIMESTAMP NOT NULL
);

CREATE TABLE IF NOT EXISTS user_task (
  user_id INTEGER,
  task_id INTEGER,
  FOREIGN KEY (user_id) REFERENCES users(user_id),
  FOREIGN KEY (task_id) REFERENCES tasks(task_id)
);

--test data

INSERT INTO users (user_id, login, password, role) VALUES (DEFAULT, 'user', 'qwerty', 2);

INSERT INTO tasks (task_id, title, description, createddate, enddate) VALUES (DEFAULT, 'testtitle', 'testdescription', TO_TIMESTAMP('2018/04/25 10:13', 'YYYY/MM/DD HH:MI'), TO_TIMESTAMP('2019/04/25 10:13', 'YYYY/MM/DD HH:MI'));
INSERT INTO tasks (task_id, title, description, createddate, enddate) VALUES (DEFAULT, 'testtite2', 'testdescription2', TO_TIMESTAMP('2018/04/25 10:13', 'YYYY/MM/DD HH:MI'), TO_TIMESTAMP('2019/04/25 10:13', 'YYYY/MM/DD HH:MI'));

INSERT INTO user_task (user_id, task_id) VALUES (2, 1);
INSERT INTO user_task (user_id, task_id) VALUES (2, 2);