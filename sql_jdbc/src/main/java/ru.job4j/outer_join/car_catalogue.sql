create table engine (
id serial primary key,
name varchar(100)
);

create table carbody (
id serial primary key,
name varchar(100)
);

create table transmission (
id serial primary key,
name varchar(100)
);

create table car (
id serial primary key,
	model varchar(100),
	engine_id int references engine(id),
	carbody_id int references carbody(id),
transmission_id int references transmission(id)
);

insert into engine(name) values('engine1');
insert into engine(name) values('engine2');
insert into engine(name) values('engine3');
insert into engine(name) values('engine4');

insert into carbody(name) values('hatchback');
insert into carbody(name) values('sedan');
insert into carbody(name) values('van');
insert into carbody(name) values('suv');

insert into transmission(name) values('manual');
insert into transmission(name) values('automatic');
insert into transmission(name) values('robotic');
insert into transmission(name) values('variator');

insert into car(model, engine_id, carbody_id, transmission_id) values('ford', 1, 2, 3);
insert into car(model, engine_id, carbody_id, transmission_id) values('seat', 2, 1, 2);
insert into car(model, engine_id, carbody_id, transmission_id) values('mini', 3, 3, 1);


select car.model, engine.name, carbody.name, transmission.name from
(((car inner join engine on car.engine_id = engine.id)
inner join carbody on car.carbody_id = carbody.id)
inner join transmission on car.transmission_id = transmission.id);

select engine.name from engine left outer join car on car.engine_id = engine.id
where car.id is null;
select carbody.name from carbody left outer join car on car.carbody_id = carbody.id
where car.id is null;
select transmission.name from transmission left outer join car on car.transmission_id = transmission.id
where car.id is null;

select(select engine.name as unused_engines from engine
 left outer join car on car.engine_id = engine.id where car.id is null),
(select carbody.name as unused_carbodies from carbody
 left outer join car on car.carbody_id = carbody.id where car.id is null),
(select transmission.name as unused_transmissions from transmission
 left outer join car on car.transmission_id = transmission.id where car.id is null);

