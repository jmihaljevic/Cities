CREATE TABLE Member
(
	id SERIAL PRIMARY KEY,
    name varchar(20),
	email varchar(30) UNIQUE,
    pass varchar(20)
)

CREATE TABLE City
(
	id SERIAL PRIMARY KEY,
	CityName varchar(20),
	Description varchar(100),
	Population int,
	CreatedDate timestamp
)
CREATE TABLE Member_City
(
	id SERIAL PRIMARY KEY,
	member_id INTEGER,
	city_id INTEGER,
	FOREIGN KEY (member_id) REFERENCES Member (id),
	FOREIGN KEY (city_id) REFERENCES City (id)
)

INSERT INTO City (CityName, Description, Population, CreatedDate)
VALUES ('Berlin', 'Many sights such as Berlin Wall and Brandenburg Gate', 3748148, current_timestamp);

INSERT INTO City (CityName, Description, Population, CreatedDate)
VALUES ('Moscow', 'One of the most expensive and most luxurious cities in the world', 12615279, current_timestamp);

INSERT INTO City (CityName, Description, Population, CreatedDate)
VALUES ('London', 'City is located on the River Thames and has many famous football clubs and great history', 9126366, current_timestamp);

INSERT INTO City (CityName, Description, Population, CreatedDate)
VALUES ('Barcelona', 'The capital of Catalonia and the city with the largest football stadium in Europe: Camp Nou', 3223334, current_timestamp);

INSERT INTO City (CityName, Description, Population, CreatedDate)
VALUES ('Istanbul', 'The largest city in Turkey and it is its cultural and economic center', 15067724, current_timestamp);

INSERT INTO City (CityName, Description, Population, CreatedDate)
VALUES ('Sofia', 'The capital of Bulgaria, one of the oldest cities in Europe', 1376461, current_timestamp);

INSERT INTO City (CityName, Description, Population, CreatedDate)
VALUES ('Budapest', 'The capital of Hungary, one of the most beautiful cities in Europe', 1749734, current_timestamp);

INSERT INTO City (CityName, Description, Population, CreatedDate)
VALUES ('Belgrade', 'Nice city, very good restaurants', 1166733, current_timestamp);

INSERT INTO City (CityName, Description, Population, CreatedDate)
VALUES ('Paris', 'One of the leading business and cultural centers in the world, many tourists come to see the sights', 2229621, current_timestamp);

INSERT INTO City (CityName, Description, Population, CreatedDate)
VALUES ('Kiev', 'A city of world-famous landmarks, it has excellently organized city transport network', 2950819, current_timestamp);
