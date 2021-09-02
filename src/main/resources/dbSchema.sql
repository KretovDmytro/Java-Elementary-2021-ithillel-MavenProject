create table cities (
id TEXT PRIMARY KEY,
name TEXT UNIQUE
);

create table city_detals(
city_id TEXT PRIMARY KEY,
population INTEGER
);