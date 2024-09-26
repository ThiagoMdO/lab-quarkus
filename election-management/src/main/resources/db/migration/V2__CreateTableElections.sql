CREATE TABLE elections (
    id VARCHAR(40) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (id)
);

CREATE TABLE election_candidate (
    election_id VARCHAR(40) NOT NULL,
    candidate_id VARCHAR(40) NOT NULL,
    votes INTEGER DEFAULT 0,
PRIMARY KEY (election_id, candidate_id)
);

insert into candidates (id, photo, first_name, last_name, email, phone, job_title) values (66f55b21fc13ae41b141accc, 'CSCP', 'Sidnee', 'Bowater', 'sbowater0@seesaa.net', '(380) 8905605', 'Statistician III');
insert into candidates (id, photo, first_name, last_name, email, phone, job_title) values (66f55b21fc13ae41b141accd, 'JProfiler', 'Elinor', 'Stentiford', 'estentiford1@europa.eu', '(842) 9264424', 'Senior Quality Engineer');
insert into candidates (id, photo, first_name, last_name, email, phone, job_title) values (66f55b21fc13ae41b141acce, 'Hearings', 'Hardy', 'Casaccio', 'hcasaccio2@bravesites.com', '(830) 3743831', 'Occupational Therapist');
insert into candidates (id, photo, first_name, last_name, email, phone, job_title) values (66f55b21fc13ae41b141accf, 'Appeals', 'Riccardo', 'Crebo', 'rcrebo3@alibaba.com', '(940) 3374859', 'Account Coordinator');
insert into candidates (id, photo, first_name, last_name, email, phone, job_title) values (66f55b21fc13ae41b141acd0, 'Global Marketing', 'Huntington', 'Gerish', 'hgerish4@angelfire.com', '(327) 4783354', 'Software Engineer II');
insert into candidates (id, photo, first_name, last_name, email, phone, job_title) values (66f55b21fc13ae41b141acd1, 'Sustainable Agriculture', 'Liana', 'Cuddy', 'lcuddy5@mail.ru', '(332) 1096513', 'Civil Engineer');
insert into candidates (id, photo, first_name, last_name, email, phone, job_title) values (66f55b21fc13ae41b141acd2, 'NPDES', 'Pren', 'Hardinge', 'phardinge6@prnewswire.com', '(669) 2851497', 'Engineer II');
insert into candidates (id, photo, first_name, last_name, email, phone, job_title) values (66f55b21fc13ae41b141acd3, 'Utilities', 'Denni', 'Felix', 'dfelix7@usatoday.com', '(297) 1058725', 'Cost Accountant');
insert into candidates (id, photo, first_name, last_name, email, phone, job_title) values (66f55b21fc13ae41b141acd4, 'IFW', 'Davis', 'Trenchard', 'dtrenchard8@surveymonkey.com', '(255) 8289885', 'General Manager');
insert into candidates (id, photo, first_name, last_name, email, phone, job_title) values (66f55b21fc13ae41b141acd5, 'SDS-PAGE', 'Lorinda', 'Wellington', 'lwellington9@xrea.com', '(117) 6573994', 'Marketing Manager');

