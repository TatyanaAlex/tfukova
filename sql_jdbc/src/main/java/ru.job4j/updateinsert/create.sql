CREATE DATABASE system_of_items;

CREATE TABLE roles(
	id serial primary key,
	role_name varchar(100)
);

CREATE TABLE users(
	id serial primary key,
	user_name varchar(100),
	role_id int references roles(id)
);

CREATE TABLE rules(
	id serial primary key,
	rule_name varchar(100)
);

CREATE TABLE states(
	id serial primary key,
	state_name varchar(100)
);

CREATE TABLE categories(
	id serial primary key,
	cat_name varchar(100)
);

CREATE TABLE items(
	id serial primary key,
	item_name varchar(100),
	user_id int references users(id),
	category_id int references categories(id),
	state_id int references states(id)
);

CREATE TABLE commentaries(
	id serial primary key,
	comm_text varchar(3000)
);

CREATE TABLE attachments(
	id serial primary key,
	attach_path varchar(2000)
);

CREATE TABLE role_rules(
	id serial primary key,
	id_role int references roles(id),
    id_rule int references rules(id)
);

CREATE TABLE item_comments(
	id serial primary key,
	id_item int references items(id),
    id_comment int references commentaries(id)
);

CREATE TABLE item_attachments(
	id serial primary key,
	id_item int references items(id),
    id_attachment int references attachments(id)
);
