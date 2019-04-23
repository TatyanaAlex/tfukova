--create new database
create database applications_system;


--start using database applications_system
 \c applications_system

--create new table of users with the fields: name, role, rights
create table users(
name character varying (50),
role character varying (50),
rights character varying (50),
	primary key(name)
);

-- Create new table "aplications", with fields: name, comments, status,
-- categories, responsibility, role, permission. Primary key "name".
CREATE TABLE aplications (
	name character varying (50),
	comments character varying (250),
	status boolean,
	categories character varying (50),
	responsibility character varying (50)
	references users(name),
	role character varying (50),
	permission boolean,
	PRIMARY KEY(name)
);

-- Add new data into table "users".
INSERT INTO users(name, role, rights)
VALUES ('maria', 'doctor', 'treatment');

-- Add new data into table "aplications".
INSERT INTO aplications(name, comments, status, categories, responsibility, role,
permission)
VALUES ('aplic 1', 'first application', TRUE, 'sql', 'maria', 'doctor', TRUE);