INSERT INTO movie (id, title, description, duration_in_minutes, release_date, production_country, director)
VALUES (1, 'The Incredibles',
        'The Incredibles is a 2004 American computer-animated superhero film written and directed by Brad Bird. The film is set in an alternate version of the 1960s, where superheroes are forced to live in secrecy due to public backlash. The story follows Bob Parr (Mr. Incredible), a superhero who is forced to live a normal life as a suburban insurance claims adjuster. His wife, Helen (Elastigirl), and their three children also have superpowers, but they must keep them hidden to avoid being discovered.',
        115, '2004-11-05', 'USA',
        'Brad Bird');

INSERT INTO movie_genres(movie_entity_id, genres_id)
VALUES (1, 1);
INSERT INTO movie_genres(movie_entity_id, genres_id)
VALUES (1, 2);

INSERT INTO score (id, user_id, movie_id, score)
VALUES (1, 1, 1, 8);
INSERT INTO score (id, user_id, movie_id, score)
VALUES (2, 2, 1, 9);
INSERT INTO score (id, user_id, movie_id, score)
VALUES (3, 3, 1, 8);
