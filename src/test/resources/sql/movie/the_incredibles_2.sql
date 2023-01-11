INSERT INTO movie (id, title, description, duration_in_minutes, release_date, production_country, director)
VALUES (4, 'The Incredibles 2',
        'While the Parr family has accepted its collective calling as superheroes, the fact remains that their special heroism is still illegal. After they are arrested after unsuccessfully trying to stop the Underminer, their future seems bleak. However, the wealthy Deavor siblings of Devtech offer new hope with a bold project to rehabilitate the public image and legal status of Supers, with Elastigirl being assigned on point to be the shining example. Having agreed for now to stay home to look after the kids, Mr. Incredible finds domestic life a daunting challenge, especially when baby Jack-Jack''s newly-emerged powers make him almost impossible to manage. However, Elastigirl has her own concerns dealing with the menace of a new supervillain, Screenslaver, who is wreaking havoc with his mind-control abilities. Elastigirl must solve the mystery of this enemy who has malevolent designs on the world, with the Parr family and friends key targets of this evil.',
        118, '2018-06-05', 'USA',
        'Brad Bird');

INSERT INTO movie_genres(movie_entity_id, genres_id)
VALUES (4, 1);
INSERT INTO movie_genres(movie_entity_id, genres_id)
VALUES (4, 2);

INSERT INTO score (id, user_id, movie_id, score)
VALUES (7, 1, 4, 8);
INSERT INTO score (id, user_id, movie_id, score)
VALUES (8, 2, 4, 9);
INSERT INTO score (id, user_id, movie_id, score)
VALUES (9, 3, 4, 8);
