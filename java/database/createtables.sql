DROP TABLE IF EXISTS attendees;
DROP TABLE IF EXISTS guardians;


CREATE TABLE guardians(
guardian_id serial primary key,
guardian_name varchar(90) NOT NULL,
email varchar(255) NOT NULL,
address varchar(100) NOT NULL,
guardian_phone varchar(16) NOT NULL,
emergency_name varchar(90) NOT NULL,
emergency_phone varchar(16) NOT NULL  
);


CREATE TABLE attendees(
attendee_id serial primary key,  
guardian_id bigint,
user_id bigint,
attendee_name varchar(90) NOT NULL,
date_of_birth date NOT NULL,
gender varchar(45) NOT NULL, 
age_group int NOT NULL,
payment_status varchar(10) NOT NULL, 
notes varchar(255),
registrar varchar(45) NOT NULL, 

constraint fk_guardian_id foreign key (guardian_id) references guardians(guardian_id),
constraint fk_user_id foreign key (user_id) references users(user_id)
); 

INSERT INTO guardians(guardian_id, guardian_name, email, address, guardian_phone, emergency_name, emergency_phone) VALUES (DEFAULT, 'Rachelle Rauh', 'rachelle123@gmail.com', '123 tech road, columbus, ohio, 43213', '614-111-2222', 'Jone Rauh', '614-111-9876');
INSERT INTO attendees (attendee_id, guardian_id, user_id, attendee_name, date_of_birth, gender, age_group, payment_status, notes, registrar)
VALUES (DEFAULT, 1, 1, 'Nikki Rauh', '2011-01-15', 'Female', 2, 'paid', 'nothing', 'Dora');
INSERT INTO attendees (attendee_id, guardian_id, user_id, attendee_name, date_of_birth, gender, age_group, payment_status, notes, registrar)
VALUES (DEFAULT, 1, 1, 'Andy Rauh', '2016-05-17', 'Male', 1, 'paid', 'nothing', 'Dora');
                
INSERT INTO guardians(guardian_id, guardian_name, email, address, guardian_phone, emergency_name, emergency_phone) VALUES (DEFAULT, 'Hanna Smith', 'hanna123@gmail.com', '456 tech road, columbus, ohio, 43213', '614-789-2328', 'Eva Smith', '614-888-2428');
INSERT INTO attendees (attendee_id, guardian_id, user_id, attendee_name, date_of_birth, gender, age_group, payment_status, notes, registrar)
VALUES (DEFAULT, 2, 1, 'Garcia Smith', '2010-07-15', 'Female', 2, 'unpaid', 'allergic to peanuts', 'Mike');