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
insert into movie_show (ms_type, ms_name, ms_genre, ms_description, ms_actors, ms_duration, ms_rating, ms_director, ms_poster, ms_repertoire, cinema_theatre_id ) values ('0', 'Dumb and dumber', '0', 'opis...', 'Jim Carrey, Jeff Daniels', '1.47', '7.3', 'Bobby Farrelly, Peter Farrelly', 'images/dumb.jpg', 1, 4 )
insert into movie_show (ms_type, ms_name, ms_genre, ms_description, ms_actors, ms_duration, ms_rating, ms_director, ms_poster, ms_repertoire, cinema_theatre_id ) values ('0', 'Nueve reinas', '3', 'opis...', ' Ricardo Darín, Gastón Pauls', '1.54', '7.9', 'Fabian Bielinsky', 'poster', 1, 4 )
insert into movie_show (ms_type, ms_name, ms_genre, ms_description, ms_actors, ms_duration, ms_rating, ms_director, ms_poster, ms_repertoire, cinema_theatre_id ) values ('0', 'Contratiempo', '4', 'opis...', '  Mario Casas, Ana Wagener', '1.46', '8.1', 'Oriol Paulo', 'poster', 1, 4 )

--repertoar za bioskope
insert into cinema_theatre_movie_shows(cinema_theatre_id, movie_shows_id) values (4, 1)
insert into cinema_theatre_movie_shows(cinema_theatre_id, movie_shows_id) values (4, 2)
insert into cinema_theatre_movie_shows(cinema_theatre_id, movie_shows_id) values (4, 3)

--sale
insert into hall (hall_number, hall_rows, hall_seatrows, cinema_theatre_id) values ('1', 20, 10, 4)
insert into hall (hall_number, hall_rows, hall_seatrows, cinema_theatre_id) values ('2', 50, 20, 4)
insert into hall (hall_number, hall_rows, hall_seatrows, cinema_theatre_id) values ('3', 20, 10, 4)

--sala-kino
insert into cinema_theatre_halls (cinema_theatre_id, halls_id) values (1, 1)
insert into cinema_theatre_halls (cinema_theatre_id, halls_id) values (1, 2)
insert into cinema_theatre_halls (cinema_theatre_id, halls_id) values (1, 3)

--projekcije za prvi film
insert into projection (prj_date, movie_show_id) values ('2018-04-27', '1')
insert into projection (prj_date, movie_show_id) values ('2017-04-12', '1')
insert into projection (prj_date, movie_show_id) values ('2011-04-12', '1')
insert into projection (prj_date, movie_show_id) values ('2001-04-12', '1')
--projekcije za drugi film
insert into projection (prj_date, movie_show_id) values ('2011-04-12', '2')
insert into projection (prj_date, movie_show_id) values ('2012-04-12', '2')
--projekcije za treci film
insert into projection (prj_date, movie_show_id) values ('2011-04-12', '3')

--projekcija-film
insert into movie_show_projections (movie_show_id, projections_id) values (1, 1)

--sjediste
insert into hall_seat (seat_number, seat_row, hall_id) values (4, 15, 1)		--br sjedista 4, red 5.

--sjediste sala
--insert into hall_hall_seats (hall_id, hall_seats_id) values (1, 1)

--vrijeme projekcije
insert into projection_time (pt_time, pt_price, hall_id, projection_id) values ('16:30', '200', 1, 1)
insert into projection_time (pt_time, pt_price, hall_id, projection_id) values ('18:00', '200', 1, 1)
insert into projection_time (pt_time, pt_price, hall_id, projection_id) values ('18:45', '200', 1, 1)
insert into projection_time (pt_time, pt_price, hall_id, projection_id) values ('20:00', '350', 1, 1)
insert into projection_time (pt_time, pt_price, hall_id, projection_id) values ('21:15', '400', 1, 1)

--projekcija, vrijme projekcije
insert into projection_projection_times (projection_id, projection_times_id) values (1, 1)
insert into projection_projection_times (projection_id, projection_times_id) values (1, 2)
insert into projection_projection_times (projection_id, projection_times_id) values (1, 3)

--insert into projection_time_hall_seats (projection_time_id, hall_seats_id) values (1, 1)

--insert into reservation (user_id, projection_time_id, price, visited) values (1, 1, 200, 0)