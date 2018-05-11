drop table MEASUREMENTS;
drop table APPOINTMENTS;
drop table PERSONS;

create table PERSONS (
    person_id integer primary key,
    full_name varchar(150) not null,
	home_address varchar(150) not null,
	phone varchar(20) not null,
	age integer not null,
	height double precision not null,
	targetKg double precision not null,
	illness text,
	medication text,
	allergies text
);

create table MEASUREMENTS (
    measure_id integer primary key,
    measure_date date not null,
    weightKg double precision not null,
    bmi double precision not null,
	person_id integer not null,
	foreign key (person_id) references PERSONS (person_id)
);

create table APPOINTMENTS (
	app_id integer primary key,
	app_date date not null,
	app_time time not null,
	person_id integer not null,
	foreign key (person_id) references PERSONS (person_id)
);