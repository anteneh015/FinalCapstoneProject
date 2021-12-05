DROP TABLE IF EXISTS parents;
DROP TABLE IF EXISTS emergency_contacts;
DROP TABLE IF EXISTS attendees;

CREATE TABLE parents(
parent_id serial primary key,
first_name varchar(45) NOT NULL,
last_name varchar(45) NOT NULL,
email varchar(255) NOT NULL,
address varchar(100) NOT NULL,
phone varchar(16) NOT NULL 
);

CREATE TABLE emergency_contacts(
emergency_contact_id serial primary key,
first_name varchar(45) NOT NULL,
last_name varchar(45) NOT NULL,
email varchar(255) NOT NULL,
address varchar(100) NOT NULL,
phone varchar(16) NOT NULL 
);

CREATE TABLE attendees(
attendee_id serial primary key,  
parent_id bigint,
user_id bigint,
emergency_contact_id bigint,
first_name varchar(45) NOT NULL,
last_name varchar(45) NOT NULL,
date_of_birth date NOT NULL,
gender varchar(45) NOT NULL, 
age_group int NOT NULL,
allergies varchar(124),
payment_status boolean NOT NULL, 
additonal_information varchar(255),
assigned_registrar varchar(45) NOT NULL, 

constraint fk_parent_id foreign key (parent_id) references parents(parent_id),
constraint fk_user_id foreign key (user_id) references users(user_id),
constraint fk_emergency_contact_id foreign key (emergency_contact_id) references emergency_contacts(emergency_contact_id)
); 

INSERT INTO parents(parent_id, first_name, last_name, email, address, phone) VALUES (DEFAULT, 'Rachelle', 'Rauh', 'rechelle123@gmail.com', '123 tech road, columbus, ohio, 43213', '614-111-2222');
INSERT INTO emergency_contacts(emergency_contact_id, first_name, last_name, email, address, phone) VALUES (DEFAULT, 'Eva', 'Rauh', 'eva123@gmail.com', '123 tech road, columbus, ohio, 43213', '614-111-3333');
INSERT INTO attendees (attendee_id, parent_id, user_id, emergency_contact_id, first_name, last_name, date_of_birth, gender, age_group, allergies, payment_status, additonal_information, assigned_registrar) 
VALUES (DEFAULT, 1, 1, 1, 'Nikki', 'Rauh', '2011-01-15', 'Female', 2, '', TRUE, '', 'Dora');
INSERT INTO attendees (attendee_id, parent_id, user_id, emergency_contact_id, first_name, last_name, date_of_birth, gender, age_group, allergies, payment_status, additonal_information, assigned_registrar) 
VALUES (DEFAULT, 1, 1, 1, 'Andy', 'Rauh', '2016-05-17', 'Male', 1, '', TRUE, '', 'Dora');