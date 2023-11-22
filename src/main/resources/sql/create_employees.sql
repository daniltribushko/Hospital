create table employees
(
	id Serial PRIMARY KEY NOT NULL,
	sureName varchar(255) NOT NULL,
	name varchar(255) NOT NULL,
	age INTEGER NOT NULL,
	type VARCHAR(255) NOT NULL
);