CREATE TABLE Person (
    id SERIAL PRIMARY KEY,
    firstName VARCHAR(255),
    lastName VARCHAR(255),
    age INT
);

CREATE TABLE Address (
    ownerId INT,
    street VARCHAR,
    zip INT
);
