--korisnik
insert into User (user_name, user_surname, user_email, user_password, user_phone, user_city, user_type, user_verified) values ('Lemur', 'Pilicar', 'lemur@hotmail.com', 'lemur12', '132-322', 'ddd', '0', TRUE)
insert into User (user_name, user_surname, user_email, user_password, user_phone, user_city, user_type, user_verified) values ('Stefa', 'Safari', 'stefa@hotmail.com', 'stefa12', '336-342', 'bbb', '0', TRUE)
insert into User (user_name, user_surname, user_email, user_password, user_phone, user_city, user_type, user_verified) values ('Govece', 'Jeftanovic', 'govece@hotmail.com', 'govece12', '325-234', 'sss', '2', TRUE)

--pozorista
insert into cinema_theatre (ct_name, ct_adress, ct_description, ct_type) values ('SNP', 'Pozorisni trg 1', 'Srpsko narodno pozoriste', '1')
insert into cinema_theatre (ct_name, ct_adress, ct_description, ct_type) values ('Pozoriste mladih', 'Ignjata Pavlasa 4 i 8', 'Opis...', '1')
insert into cinema_theatre (ct_name, ct_adress, ct_description, ct_type) values ('Novosadsko pozoriste', 'Jovana Subotica 3-5', 'Opis...', '1')

--bioskopi
insert into cinema_theatre (ct_name, ct_adress, ct_description, ct_type) values ('Arena Cinaplex', 'Bulevar Mihajla Pupina 3', 'Opis...', '0')
insert into cinema_theatre (ct_name, ct_adress, ct_description, ct_type) values ('CineStar', 'Sentandrejski put 11', 'Opis ...', '0')
insert into cinema_theatre (ct_name, ct_adress, ct_description, ct_type) values ('5D Cinema', 'Zeleznicka 24', 'Nova i spektakularna zabava u Novom Sadu je 5D bioskop!!!', '0')

--repertoar (1)
insert into repertoire (cinema_theatre_id) values (1)

--filmovi (repertoar 1)
insert into movie_show (ms_type, ms_name, ms_genre, ms_description, ms_actors, ms_duration, ms_rating, ms_director, ms_poster, ms_repertoire, cinema_theatre_id ) values ('0', 'Dumb and dumber', '0', 'opis...', 'Jim Carrey, Jeff Daniels', '1.47', '7.3', 'Bobby Farrelly, Peter Farrelly', 'poster', 1, 4 )
insert into movie_show (ms_type, ms_name, ms_genre, ms_description, ms_actors, ms_duration, ms_rating, ms_director, ms_poster, ms_repertoire, cinema_theatre_id ) values ('0', 'Nueve reinas', '3', 'opis...', ' Ricardo Darín, Gastón Pauls', '1.54', '7.9', 'Fabian Bielinsky', 'poster', 1, 4 )
insert into movie_show (ms_type, ms_name, ms_genre, ms_description, ms_actors, ms_duration, ms_rating, ms_director, ms_poster, ms_repertoire, cinema_theatre_id ) values ('0', 'Contratiempo', '4', 'opis...', '  Mario Casas, Ana Wagener', '1.46', '8.1', 'Oriol Paulo', 'poster', 1, 4 )

--repertoar
insert into cinema_theatre_movie_shows(cinema_theatre_id, movie_shows_id) values (4, 1)
insert into cinema_theatre_movie_shows(cinema_theatre_id, movie_shows_id) values (4, 2)
insert into cinema_theatre_movie_shows(cinema_theatre_id, movie_shows_id) values (4, 3)

