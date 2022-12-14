create table genre
(
    id   bigserial not null,
    name varchar(64),
    primary key (id)
);

create table movie
(
    id                  bigserial not null,
    created             timestamp,
    description         varchar(1024),
    director            varchar(255),
    duration_in_minutes int4      not null,
    production_country  varchar(255),
    release_date        date      not null,
    title               varchar(64),
    updated             timestamp,
    primary key (id)
);

create table movie_genres
(
    movie_entity_id int8 not null,
    genres_id       int8 not null
);

create table score
(
    id       bigserial not null,
    score    numeric(2, 0) check (score >= 1 AND score <= 10),
    movie_id int8      not null,
    user_id  int8      not null,
    primary key (id)
);


alter table movie_genres
    add constraint con_movie_genres_genres_id_fk foreign key (genres_id) references genre;

alter table movie_genres
    add constraint con_movie_genres_movie_entity_id_fk foreign key (movie_entity_id) references movie;

alter table score
    add constraint con_score_movie_movie_id_fk foreign key (movie_id) references movie;

alter table score
    add constraint con_score_movie_user_id_fk foreign key (user_id) references "user";

