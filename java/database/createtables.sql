DROP TABLE IF EXISTS attendees;
DROP TABLE IF EXISTS guardians;
DROP TABLE IF EXISTS dorms;

CREATE TABLE dorms(
dorm_id serial primary key,
dorm_name varchar(20)NOT NULL
);

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
dorm_id bigint,
user_id bigint,
attendee_name varchar(90) NOT NULL,
date_of_birth date NOT NULL,
gender varchar(45) NOT NULL, 
age_group int NOT NULL,
payment_status varchar(10) NOT NULL, 
notes varchar(255),
registrar varchar(45) NOT NULL, 
img_url varchar NOT NULL,

constraint fk_guardian_id foreign key (guardian_id) references guardians(guardian_id),
constraint fk_user_id foreign key (user_id) references users(user_id),
constraint fk_dorm_id foreign key (dorm_id) references dorms(dorm_id)
); 

INSERT INTO dorms(dorm_id, dorm_name) VALUES (DEFAULT, 'Wall-E');
INSERT INTO dorms(dorm_id, dorm_name) VALUES (DEFAULT, 'Eve');



INSERT INTO guardians(guardian_id, guardian_name, email, address, guardian_phone, emergency_name, emergency_phone) VALUES (DEFAULT, 'Rachelle Rauh', 'rachelle123@gmail.com', '123 tech road, columbus, ohio, 43213', '614-121-4456', 'Jone Rauh', '614-122-9876');
INSERT INTO attendees (attendee_id, guardian_id, dorm_id, user_id, attendee_name, date_of_birth, gender, age_group, payment_status, notes, registrar, img_url)
VALUES (DEFAULT, 1, 2, 1, 'Nikki Rauh', '2011-01-15', 'Female', 2, 'received', 'N/A', 'Dora', 'RandomGirl1.jpg');
INSERT INTO attendees (attendee_id, guardian_id, dorm_id, user_id, attendee_name, date_of_birth, gender, age_group, payment_status, notes, registrar, img_url)
VALUES (DEFAULT, 1, 1, 1, 'Andy Rauh', '2016-05-17', 'Male', 1, 'received', 'N/A', 'Mike', 'RachelleBoy1.jpg');
                
INSERT INTO guardians(guardian_id, guardian_name, email, address, guardian_phone, emergency_name, emergency_phone) VALUES (DEFAULT, 'Hanna Smith', 'hanna123@gmail.com', '8665 Gary Ave, Columbus, Ohio, 43098', '614-789-2328', 'Eva Smith', '614-898-2428');
INSERT INTO attendees (attendee_id, guardian_id, dorm_id, user_id, attendee_name, date_of_birth, gender, age_group, payment_status, notes, registrar, img_url)
VALUES (DEFAULT, 2, 2, 1, 'Garcia Smith', '2010-07-15', 'Female', 2, 'unpaid', 'Allergic to peanuts', 'Dora', 'RachelleGirl.jpg');

INSERT INTO guardians(guardian_id, guardian_name, email, address, guardian_phone, emergency_name, emergency_phone) VALUES (DEFAULT, 'John William', 'john123@gmail.com', '748 Ferry St, Columbus, Ohio, 43645', '614-785-6877', 'April William', '614-113-3456');
INSERT INTO attendees (attendee_id, guardian_id, dorm_id, user_id, attendee_name, date_of_birth, gender, age_group, payment_status, notes, registrar, img_url)
VALUES (DEFAULT, 3, 1, 1, 'Tom William', '2015-07-22', 'Male', 1, 'unpaid', 'Loves to play soccer', 'Mike', 'RandomBoy1.jpg');
INSERT INTO guardians(guardian_id, guardian_name, email, address, guardian_phone, emergency_name, emergency_phone) VALUES (DEFAULT, 'Vivian Brown ', 'Vivian123@gmail.com', '987 Tech Blvd, columbus, ohio, 43889', '614-091-2512', 'Taylor Lewis', '614-153-9026');
INSERT INTO attendees (attendee_id, guardian_id, dorm_id, user_id, attendee_name, date_of_birth, gender, age_group, payment_status, notes, registrar, img_url)
VALUES (DEFAULT, 4, 1, 1, 'Jack Brown', '2008-11-03', 'Male', 3, 'received', 'Allergic to kiwies', 'Mike', 'brian90.jpg');

INSERT INTO guardians(guardian_id, guardian_name, email, address, guardian_phone, emergency_name, emergency_phone) VALUES (DEFAULT, 'Lauren Heath', 'LHeAtH@gmail.com', '78 High St, Columbus, Ohio, 43137', '614-894-0034', 'Max Heath', '614-807-9233');
INSERT INTO attendees (attendee_id, guardian_id, dorm_id, user_id, attendee_name, date_of_birth, gender, age_group, payment_status, notes, registrar, img_url)
VALUES (DEFAULT, 5, 1, 1, 'Theodore Heath', '2012-04-07', 'Male', 2, 'received', 'Has slight asthma', 'Mike', 'RachelleBoy2.jpg');

INSERT INTO guardians(guardian_id, guardian_name, email, address, guardian_phone, emergency_name, emergency_phone) VALUES (DEFAULT, 'Lauren Heath', 'LHeAtH@gmail.com', '78 High St, Columbus, Ohio, 43137', '614-894-0034', 'Max Heath', '614-807-9233');
INSERT INTO attendees (attendee_id, guardian_id, dorm_id, user_id, attendee_name, date_of_birth, gender, age_group, payment_status, notes, registrar, img_url)
VALUES (DEFAULT, 5, 2, 1, 'Tammy Heath', '2008-11-14', 'Female', 2, 'received', 'N/A', 'Dora', 'RandomGirl2.jpg');

INSERT INTO guardians(guardian_id, guardian_name, email, address, guardian_phone, emergency_name, emergency_phone) VALUES (DEFAULT, 'Thomas Sikes', 'tomSike@gmail.com', '889 Main St, Columbus, Ohio, 43226', '877-227-4669', 'Mary Jane', '688-548-3113');
INSERT INTO attendees (attendee_id, guardian_id, dorm_id, user_id, attendee_name, date_of_birth, gender, age_group, payment_status, notes, registrar, img_url)
VALUES (DEFAULT, 6, 2, 1, 'Sarah Sikes', '2006-03-22', 'Female', 3, 'received', 'N/A', 'Dora', 'RandomGirl3.jpg');

SELECT attendees.attendee_id, attendees.attendee_name, attendees.date_of_birth, attendees.gender, attendees.age_group, attendees.payment_status, attendees.notes, attendees.registrar, 
                guardians.guardian_name, guardians.email, guardians.address, guardians.guardian_phone, guardians.emergency_name, guardians.emergency_phone, dorm_name From attendees JOIN guardians ON attendees.guardian_id = guardians.guardian_id 
                JOIN dorms ON attendees.dorm_id = dorms.dorm_id 



