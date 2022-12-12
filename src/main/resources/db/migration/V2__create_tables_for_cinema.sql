create table cinema
(
    id      int8 not null,
    created timestamp,
    name    varchar(64),
    updated timestamp,
    url     varchar(64),
    primary key (id)
);

create table cinema_facility
(
    id          bigserial not null,
    address     varchar(128),
    created     timestamp,
    description varchar(1024),
    email       varchar(64),
    name        varchar(255),
    telephone   varchar(32),
    updated     timestamp,
    cinema_id   int8      not null,
    primary key (id)
);

alter table cinema_facility
    add constraint con_cinema_facility_cinema_id_fk foreign key (cinema_id) references cinema;