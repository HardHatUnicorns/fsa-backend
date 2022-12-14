INSERT INTO movie (id, title, description, duration_in_minutes, release_date, production_country, director)
VALUES (2, 'The Shawshank Redemption',
        'Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.',
        142, '1994-09-23', 'USA', 'Frank Darabont');

INSERT INTO movie_genres(movie_entity_id, genres_id)
VALUES (2, 3);
INSERT INTO movie_genres(movie_entity_id, genres_id)
VALUES (2, 4);

INSERT INTO score (id, user_id, movie_id, score)
VALUES (4, 2, 2, 7);
INSERT INTO score (id, user_id, movie_id, score)
VALUES (5, 3, 2, 7);
INSERT INTO score (id, user_id, movie_id, score)
VALUES (6, 1, 2, 9);
