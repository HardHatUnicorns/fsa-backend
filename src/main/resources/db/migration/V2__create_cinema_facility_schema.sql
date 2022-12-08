CREATE TABLE facility
(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    location_id BIGINT NOT NULL,
    active BOOLEAN
);

CREATE TABLE location
(
    id BIGSERIAL PRIMARY KEY CONSTRAINT fk_facility
        REFERENCES facility(id),
    city VARCHAR(255),
    street VARCHAR(255),
    house_number VARCHAR(20),
    latitude FLOAT,
    longitude FLOAT
);