/**
 * Author:  vasouv
 * Created: Mar 21, 2018
 */

-- insert into FOODHABITS(foodHabits_id,doesntEat,favouriteFoods,milk,yoghurt,whiteCheese,yellowCheese,fruit,veggies,legumes,bread,meat,eggs,fish,sweets,nuts,honey,soda,coffee,alcohol,water,notes) values
-- (1,'none','none',true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,'Trwei ta panta'),
-- (2,'none','none',true,true,true,true,true,true,false,true,true,true,true,false,true,true,true,true,true,true,'Kati sxolia oeo'),
-- (3,'Laxanika','Sokolates',true,true,true,true,false,false,true,true,true,true,false,true,true,true,true,true,true,true,'Megalos glykatzis');

-- insert into persons(person_id,fname,address,phone,age,height,targetkg,illness,medication,allergies,foodHabits_id) values
-- (1,'Mixalis','Paulou Mela','62422',29,1.82,85,'xazomara','lipodialites','nero',1),
-- (2,'Giorgos','Tynnered','souidiko',30,1.80,73,'kamia','vegan','kamia',2),
-- (3,'Xristos','Geitonas','tsampa zei',30,1.78,110,'polles','no idea','melisses',3);

insert into persons(person_id,fname,address,phone,age,height,targetkg,illness,medication,allergies) values
(1,'Mixalis','Paulou Mela','62422',29,1.82,85,'xazomara','lipodialites','nero'),
(2,'Giorgos','Tynnered','souidiko',30,1.80,73,'kamia','vegan','kamia'),
(3,'Xristos','Geitonas','tsampa zei',30,1.78,110,'polles','no idea','melisses');

insert into measurements(measure_id,measuredate,weightkg,bmi,person_id) values
(1,'2017-05-01',90.2,25.7,1),
(2,'2017-05-10',89.3,25,1),
(3,'2017-05-20',87,24,1),
(4,'2017-06-01',88.6,24.8,1),
(5,'2016-12-25',83,21.2,1),
(6,'2017-01-10',90,26,2),
(7,'2017-01-20',93,30.2,2),
(8,'2017-01-30',97,34.32,2),
(9,'2017-06-03',90,27,3),
(10,'2017-06-10',89,26.4,3),
(11,'2017-06-15',88,25,3),
(12,'2017-06-23',85,23,3);