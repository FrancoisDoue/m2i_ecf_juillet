create schema ecf_gestion_personnel;
use ecf_gestion_personnel;

create table position
(
    id        int auto_increment
        primary key,
    job_title varchar(255) not null,
    constraint UK_k72b2tnymre2ybj6a4nlnf0xg
        unique (job_title)
);

INSERT INTO ecf_gestion_personnel.position (id, job_title) VALUES (1, 'Développeur junior');
INSERT INTO ecf_gestion_personnel.position (id, job_title) VALUES (2, 'Développeur senior');
INSERT INTO ecf_gestion_personnel.position (id, job_title) VALUES (3, 'Expert comptable');
INSERT INTO ecf_gestion_personnel.position (id, job_title) VALUES (4, 'Administrateur système');

create table department
(
    id   int auto_increment
        primary key,
    name varchar(255) not null,
    constraint UK_biw7tevwc07g3iutlbmkes0cm
        unique (name)
);

INSERT INTO ecf_gestion_personnel.department (id, name) VALUES (1, 'Recherche et développement');
INSERT INTO ecf_gestion_personnel.department (id, name) VALUES (2, 'Informatique');
INSERT INTO ecf_gestion_personnel.department (id, name) VALUES (3, 'Administration');

create table employee
(
    id            int auto_increment
        primary key,
    email         varchar(255) not null,
    firstname     varchar(255) not null,
    lastname      varchar(255) not null,
    phone         varchar(255) null,
    department_id int          null,
    position_id   int          null,
    constraint fk_employee_department
        foreign key (department_id) references department (id)
            on delete set null,
    constraint fk_employee_position
        foreign key (position_id) references position (id)
            on delete set null
);

INSERT INTO ecf_gestion_personnel.employee (id, email, firstname, lastname, phone, department_id, position_id) VALUES (1, 'jdupont@test.fr', 'Jean', 'Dupont', '0101010101', 3, 3);
INSERT INTO ecf_gestion_personnel.employee (id, email, firstname, lastname, phone, department_id, position_id) VALUES (3, 'g.abitbol@test.fr', 'Georges', 'abitbol', '0102010101', 1, 4);
INSERT INTO ecf_gestion_personnel.employee (id, email, firstname, lastname, phone, department_id, position_id) VALUES (4, 'je.albert@test.fr', 'Jean-Eude', 'Albert', '0102010101', 2, 1);
INSERT INTO ecf_gestion_personnel.employee (id, email, firstname, lastname, phone, department_id, position_id) VALUES (5, 't.tata@test.fr', 'Toto', 'Tata', '0102012301', 2, 1);
INSERT INTO ecf_gestion_personnel.employee (id, email, firstname, lastname, phone, department_id, position_id) VALUES (6, 'b.foo@test.fr', 'Bertrand', 'Foo', '0102012391', 2, 2);
