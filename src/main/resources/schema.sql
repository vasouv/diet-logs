/**
 * Author:  vasou
 * Created: Mar 22, 2018
 */

-- create table FOODHABITS (
--     foodHabits_id int primary key,
--     doesntEat varchar(255),
--     favouriteFoods varchar(255),
--     milk boolean,
--     yoghurt boolean,
--     whiteCheese boolean,
--     yellowCheese boolean,
--     fruit boolean,
--     veggies boolean,
--     legumes boolean,
--     bread boolean,
--     meat boolean,
--     eggs boolean,
--     fish boolean,
--     sweets boolean,
--     nuts boolean,
--     honey boolean,
--     soda boolean,
--     coffee boolean,
--     alcohol boolean,
--     water boolean,
--     notes varchar(255)
-- );

create table PERSONS (
    person_id int primary key,
    fname varchar(150) not null,
    address varchar(150) not null,
    phone varchar(20) not null,
    age int not null,
    height double not null,
    targetKg double not null,
    illness varchar(255),
    medication varchar(255),
    allergies varchar(255),
--     foodHabits_id int not null,
--     foreign key (foodHabits_id) references FOODHABITS (foodHabits_id)
);

create table MEASUREMENTS (
    measure_id int primary key,
    measureDate date not null,
    weightKg double not null,
    bmi double not null,
    person_id int not null,
    foreign key (person_id) references PERSONS (person_id)
);

-- create table PERSONS_MEASUREMENTS (
--     person_fk int not null,
--     measure_fk int not null,
--     primary key (person_fk, measure_fk),
--     foreign key (person_fk) references PERSONS (person_id),
--     foreign key (measure_fk) references MEASUREMENTS (measure_id)
-- );