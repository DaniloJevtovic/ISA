--korisnik
insert into User (user_name, user_surname, user_email, user_password, user_phone, user_city, user_type, user_verified) values ('Danilo', 'Jevtovic', 'danilo_jevtovic@hotmail.com', 'lemur12', '333-333', 'NS', '0', TRUE)
insert into User (user_name, user_surname, user_email, user_password, user_phone, user_city, user_type, user_verified) values ('Lemur', 'Pilicar', 'lemur@hotmail.com', 'lemur12', '132-322', 'ddd', '0', TRUE)
insert into User (user_name, user_surname, user_email, user_password, user_phone, user_city, user_type, user_verified) values ('Stefa', 'Safari', 'stefa@hotmail.com', 'stefa12', '336-342', 'bbb', '0', TRUE)
insert into User (user_name, user_surname, user_email, user_password, user_phone, user_city, user_type, user_verified) values ('Govece', 'Jeftanovic', 'govece@hotmail.com', 'govece12', '325-234', 'sss', '2', TRUE)

--pozorista
insert into cinema_theatre (ct_name, ct_adress, ct_description, ct_grade, ct_type) values ('SNP', 'Pozorisni trg 1', 'Srpsko narodno pozoriste',  '4.9','1')
insert into cinema_theatre (ct_name, ct_adress, ct_description, ct_grade, ct_type) values ('Pozoriste mladih', 'Ignjata Pavlasa 4 i 8', 'Opis...', '4.5', '1')
insert into cinema_theatre (ct_name, ct_adress, ct_description, ct_grade, ct_type) values ('Novosadsko pozoriste', 'Jovana Subotica 3-5', 'Opis...', '4.2', '1')

--bioskopi
insert into cinema_theatre (ct_name, ct_adress, ct_description, ct_grade, ct_type) values ('Arena Cinaplex', 'Bulevar Mihajla Pupina 3', 'Opis...', '4.5', '0')
insert into cinema_theatre (ct_name, ct_adress, ct_description, ct_grade, ct_type) values ('CineStar', 'Sentandrejski put 11', 'Opis ...', '4.3', '0')
insert into cinema_theatre (ct_name, ct_adress, ct_description, ct_grade, ct_type) values ('5D Cinema', 'Zeleznicka 24', 'Nova i spektakularna zabava u Novom Sadu je 5D bioskop!!!', '4.7', '0')
insert into cinema_theatre (ct_name, ct_adress, ct_description, ct_grade, ct_type) values ('Lemurov bioskop', 'xxx', 'Dobrodosli u lemurov bioskop, mjesto gdje se pustaju pravi filmovi', '4.8', '0')

--repertoar (1)
insert into repertoire (cinema_theatre_id) values (1)

--filmovi (repertoar 1)
insert into movie_show (ms_type, ms_name, ms_genre, ms_description, ms_actors, ms_duration, ms_rating, ms_director, ms_poster, ms_repertoire, cinema_theatre_id ) values ('0', 'Dumb and dumber', '0', 'opis...', 'Jim Carrey, Jeff Daniels', '1.47', '7.3', 'Bobby Farrelly, Peter Farrelly', 'images/dumb.jpg', 1, 4 )
insert into movie_show (ms_type, ms_name, ms_genre, ms_description, ms_actors, ms_duration, ms_rating, ms_director, ms_poster, ms_repertoire, cinema_theatre_id ) values ('0', 'Nueve reinas', '3', 'opis...', ' Ricardo Darín, Gastón Pauls', '1.54', '7.9', 'Fabian Bielinsky', 'images/neuve.jpg', 1, 4 )
insert into movie_show (ms_type, ms_name, ms_genre, ms_description, ms_actors, ms_duration, ms_rating, ms_director, ms_poster, ms_repertoire, cinema_theatre_id ) values ('0', 'Contratiempo', '4', 'opis...', '  Mario Casas, Ana Wagener', '1.46', '8.1', 'Oriol Paulo', 'images/contratiempo.jpg', 1, 4 )

--lemurovi filmovi
insert into movie_show (ms_type, ms_name, ms_genre, ms_description, ms_actors, ms_duration, ms_rating, ms_director, ms_poster, ms_repertoire, cinema_theatre_id ) values ('0', 'Lock, Stock and Two Smoking Barrels', '0', 'A botched card game in London triggers four friends, thugs, weed-growers, hard gangsters, loan sharks and debt collectors to collide with each other in a series of unexpected events, all for the sake of weed, cash and two antique shotguns.', 'Jason Flemyng, Dexter Fletcher,  Nick Moran', '1.47', '8.2', 'Guy Ritchie', 'images/lock.jpg', 1, 7 )
insert into movie_show (ms_type, ms_name, ms_genre, ms_description, ms_actors, ms_duration, ms_rating, ms_director, ms_poster, ms_repertoire, cinema_theatre_id ) values ('0', 'The Green Mile', '2', 'The lives of guards on Death Row are affected by one of their charges: a black man accused of child murder and rape, yet who has a mysterious gift.', ' Tom Hanks, Michael Clarke Duncan, David Morse', '3h 9min', '8.5', 'Frank Darabont', 'images/green.jpg', 1, 4 )
insert into movie_show (ms_type, ms_name, ms_genre, ms_description, ms_actors, ms_duration, ms_rating, ms_director, ms_poster, ms_repertoire, cinema_theatre_id ) values ('0', 'The Shawshank Redemption', '2', 'Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.', ' Tim Robbins, Morgan Freeman, Bob Gunton', '2h 22min', '9.3', 'Frank Darabont', 'images/shawshank.jpg', 1, 4 )
insert into movie_show (ms_type, ms_name, ms_genre, ms_description, ms_actors, ms_duration, ms_rating, ms_director, ms_poster, ms_repertoire, cinema_theatre_id ) values ('0', 'La migliore offerta', '4', 'A lonely art expert working for a mysterious and reclusive heiress finds not only her art worth examining.', ' Geoffrey Rush, Jim Sturgess, Sylvia Hoeks', '2h 11min', '7.8', 'Giuseppe Tornatore', 'images/offer.jpg', 1, 4 )
insert into movie_show (ms_type, ms_name, ms_genre, ms_description, ms_actors, ms_duration, ms_rating, ms_director, ms_poster, ms_repertoire, cinema_theatre_id ) values ('0', 'Perfetti sconosciuti', '0', 'Seven long-time friends get together for a dinner. When they decide to share with each other the content of every text message, email and phone call they receive, many secrets start to unveil and the equilibrium trembles.', ' Giuseppe Battiston, Anna Foglietta, Marco Giallini ', '1h 37min ', '7.8', 'Paolo Genovese', 'images/perfetti.jpg', 1, 4 )

--repertoar za bioskope
insert into cinema_theatre_movie_shows(cinema_theatre_id, movie_shows_id) values (4, 1)
insert into cinema_theatre_movie_shows(cinema_theatre_id, movie_shows_id) values (4, 2)
insert into cinema_theatre_movie_shows(cinema_theatre_id, movie_shows_id) values (4, 3)

--lemurov repertorar
insert into cinema_theatre_movie_shows(cinema_theatre_id, movie_shows_id) values (7, 4)
insert into cinema_theatre_movie_shows(cinema_theatre_id, movie_shows_id) values (7, 5)
insert into cinema_theatre_movie_shows(cinema_theatre_id, movie_shows_id) values (7, 6)
insert into cinema_theatre_movie_shows(cinema_theatre_id, movie_shows_id) values (7, 7)
insert into cinema_theatre_movie_shows(cinema_theatre_id, movie_shows_id) values (7, 8)


--sale za arena cinaplex
insert into hall (hall_number, hall_rows, hall_seatrows, cinema_theatre_id) values ('1', 4, 10, 4)	
insert into hall (hall_number, hall_rows, hall_seatrows, cinema_theatre_id) values ('2', 2, 2, 4)	
insert into hall (hall_number, hall_rows, hall_seatrows, cinema_theatre_id) values ('3', 5, 5, 4)
insert into hall (hall_number, hall_rows, hall_seatrows, cinema_theatre_id) values ('4', 5, 5, 4)
insert into hall (hall_number, hall_rows, hall_seatrows, cinema_theatre_id) values ('5', 5, 5, 4)
insert into hall (hall_number, hall_rows, hall_seatrows, cinema_theatre_id) values ('6', 5, 5, 4)


--sale za lemurov bioskop
insert into hall (hall_number, hall_rows, hall_seatrows, cinema_theatre_id) values ('11', 7, 15, 7)	
insert into hall (hall_number, hall_rows, hall_seatrows, cinema_theatre_id) values ('22', 6, 15, 7)	
insert into hall (hall_number, hall_rows, hall_seatrows, cinema_theatre_id) values ('33', 5, 10, 7)
insert into hall (hall_number, hall_rows, hall_seatrows, cinema_theatre_id) values ('44', 4, 10, 7)
insert into hall (hall_number, hall_rows, hall_seatrows, cinema_theatre_id) values ('55', 3, 7, 7)
insert into hall (hall_number, hall_rows, hall_seatrows, cinema_theatre_id) values ('66', 3, 5, 7)


--sala-kino	arena cinaplex
insert into cinema_theatre_halls (cinema_theatre_id, halls_id) values (4, 1)
insert into cinema_theatre_halls (cinema_theatre_id, halls_id) values (4, 2)
insert into cinema_theatre_halls (cinema_theatre_id, halls_id) values (4, 3)
insert into cinema_theatre_halls (cinema_theatre_id, halls_id) values (4, 4)
insert into cinema_theatre_halls (cinema_theatre_id, halls_id) values (4, 5)
insert into cinema_theatre_halls (cinema_theatre_id, halls_id) values (4, 6)

--sala-kino	lemurov bioskop
insert into cinema_theatre_halls (cinema_theatre_id, halls_id) values (7, 7)
insert into cinema_theatre_halls (cinema_theatre_id, halls_id) values (7, 8)
insert into cinema_theatre_halls (cinema_theatre_id, halls_id) values (7, 9)
insert into cinema_theatre_halls (cinema_theatre_id, halls_id) values (7, 10)
insert into cinema_theatre_halls (cinema_theatre_id, halls_id) values (7, 11)
insert into cinema_theatre_halls (cinema_theatre_id, halls_id) values (7, 12)



--projekcije za prvi film (datum projekcije)
insert into projection (prj_date, movie_show_id) values ('2018-09-15', '1')
insert into projection (prj_date, movie_show_id) values ('2018-09-22', '1')
insert into projection (prj_date, movie_show_id) values ('2018-04-17', '1')
insert into projection (prj_date, movie_show_id) values ('2008-05-12', '1')
--projekcije za drugi film
insert into projection (prj_date, movie_show_id) values ('2011-04-12', '2')
insert into projection (prj_date, movie_show_id) values ('2012-04-12', '2')
--projekcije za treci film
insert into projection (prj_date, movie_show_id) values ('2011-04-12', '3')

--projekcija za lock-stock 
insert into projection (prj_date, movie_show_id) values ('2018-09-15', '4')
insert into projection (prj_date, movie_show_id) values ('2018-09-16', '4')
insert into projection (prj_date, movie_show_id) values ('2018-09-20', '4')
insert into projection (prj_date, movie_show_id) values ('2018-09-26', '4')
insert into projection (prj_date, movie_show_id) values ('2018-09-27', '4')
insert into projection (prj_date, movie_show_id) values ('2018-09-28', '4')
insert into projection (prj_date, movie_show_id) values ('2018-09-29', '4')


--projekcija-film - prvi film (datum projekcije) - arena cinaplex
insert into movie_show_projections (movie_show_id, projections_id) values (1, 1)
insert into movie_show_projections (movie_show_id, projections_id) values (1, 2)
insert into movie_show_projections (movie_show_id, projections_id) values (1, 3)
insert into movie_show_projections (movie_show_id, projections_id) values (1, 4)
--projekcija-film - drugi film film (datum projekcije) - arena cinaplex
insert into movie_show_projections (movie_show_id, projections_id) values (2, 5)
insert into movie_show_projections (movie_show_id, projections_id) values (2, 6)
--projekcija-film -treci ifilm (datum projekcije) - arena cinaplex
insert into movie_show_projections (movie_show_id, projections_id) values (3, 7)

--projekcija-film - lock-stock (datum projekcije) - lemurov bioskop
insert into movie_show_projections (movie_show_id, projections_id) values (4, 8)
insert into movie_show_projections (movie_show_id, projections_id) values (4, 9)
insert into movie_show_projections (movie_show_id, projections_id) values (4, 10)
insert into movie_show_projections (movie_show_id, projections_id) values (4, 11)
insert into movie_show_projections (movie_show_id, projections_id) values (4, 12)
insert into movie_show_projections (movie_show_id, projections_id) values (4, 13)
insert into movie_show_projections (movie_show_id, projections_id) values (4, 14)



--sjediste -- broj sjedista u redu/ broj reda u kojem se sjediste nalazi
--SJEDISTAAA za salu 4x10 = 40 upita :(
--prvi red
insert into hall_seat (seat_number, seat_row, hall_id) values (1, 1, 1)	
insert into hall_seat (seat_number, seat_row, hall_id) values (2, 1, 1)	
insert into hall_seat (seat_number, seat_row, hall_id) values (3, 1, 1)	
insert into hall_seat (seat_number, seat_row, hall_id) values (4, 1, 1)
insert into hall_seat (seat_number, seat_row, hall_id) values (5, 1, 1)	
insert into hall_seat (seat_number, seat_row, hall_id) values (6, 1, 1)	
insert into hall_seat (seat_number, seat_row, hall_id) values (7, 1, 1)	
insert into hall_seat (seat_number, seat_row, hall_id) values (8, 1, 1)
insert into hall_seat (seat_number, seat_row, hall_id) values (9, 1, 1)	
insert into hall_seat (seat_number, seat_row, hall_id) values (10, 1, 1)	
--drugi red
insert into hall_seat (seat_number, seat_row, hall_id) values (1, 2, 1)	
insert into hall_seat (seat_number, seat_row, hall_id) values (2, 3, 1)	
insert into hall_seat (seat_number, seat_row, hall_id) values (3, 2, 1)	
insert into hall_seat (seat_number, seat_row, hall_id) values (4, 2, 1)
insert into hall_seat (seat_number, seat_row, hall_id) values (5, 2, 1)	
insert into hall_seat (seat_number, seat_row, hall_id) values (6, 2, 1)	
insert into hall_seat (seat_number, seat_row, hall_id) values (7, 2, 1)	
insert into hall_seat (seat_number, seat_row, hall_id) values (8, 2, 1)
insert into hall_seat (seat_number, seat_row, hall_id) values (9, 2, 1)	
insert into hall_seat (seat_number, seat_row, hall_id) values (10, 2, 1)
--treci red
insert into hall_seat (seat_number, seat_row, hall_id) values (1, 3, 1)	
insert into hall_seat (seat_number, seat_row, hall_id) values (2, 3, 1)	
insert into hall_seat (seat_number, seat_row, hall_id) values (3, 3, 1)	
insert into hall_seat (seat_number, seat_row, hall_id) values (4, 3, 1)
insert into hall_seat (seat_number, seat_row, hall_id) values (5, 3, 1)	
insert into hall_seat (seat_number, seat_row, hall_id) values (6, 3, 1)	
insert into hall_seat (seat_number, seat_row, hall_id) values (7, 3, 1)	
insert into hall_seat (seat_number, seat_row, hall_id) values (8, 3, 1)
insert into hall_seat (seat_number, seat_row, hall_id) values (9, 3, 1)	
insert into hall_seat (seat_number, seat_row, hall_id) values (10, 3, 1)	
--cetvrti red
insert into hall_seat (seat_number, seat_row, hall_id) values (1, 5, 1)	
insert into hall_seat (seat_number, seat_row, hall_id) values (2, 5, 1)	
insert into hall_seat (seat_number, seat_row, hall_id) values (3, 5, 1)	
insert into hall_seat (seat_number, seat_row, hall_id) values (4, 5, 1)
insert into hall_seat (seat_number, seat_row, hall_id) values (5, 5, 1)	
insert into hall_seat (seat_number, seat_row, hall_id) values (6, 5, 1)	
insert into hall_seat (seat_number, seat_row, hall_id) values (7, 5, 1)	
insert into hall_seat (seat_number, seat_row, hall_id) values (8, 5, 1)
insert into hall_seat (seat_number, seat_row, hall_id) values (9, 5, 1)	
insert into hall_seat (seat_number, seat_row, hall_id) values (10, 5, 1)	


--sejdista za salu broj 2 -  2x2
insert into hall_seat (seat_number, seat_row, hall_id) values (1, 1, 2)	
insert into hall_seat (seat_number, seat_row, hall_id) values (2, 1, 2)	
insert into hall_seat (seat_number, seat_row, hall_id) values (1, 2, 2)	
insert into hall_seat (seat_number, seat_row, hall_id) values (2, 2, 2)

--sjedista za salu broj 3 - 5x5
--prvi red
insert into hall_seat (seat_number, seat_row, hall_id) values (1, 1, 3)	
insert into hall_seat (seat_number, seat_row, hall_id) values (2, 1, 3)	
insert into hall_seat (seat_number, seat_row, hall_id) values (3, 1, 3)	
insert into hall_seat (seat_number, seat_row, hall_id) values (4, 1, 3)
insert into hall_seat (seat_number, seat_row, hall_id) values (5, 1, 3)
--drugi red
insert into hall_seat (seat_number, seat_row, hall_id) values (1, 2, 3)	
insert into hall_seat (seat_number, seat_row, hall_id) values (2, 2, 3)	
insert into hall_seat (seat_number, seat_row, hall_id) values (3, 2, 3)	
insert into hall_seat (seat_number, seat_row, hall_id) values (4, 2, 3)
insert into hall_seat (seat_number, seat_row, hall_id) values (5, 2, 3)
--treci red
insert into hall_seat (seat_number, seat_row, hall_id) values (1, 3, 3)	
insert into hall_seat (seat_number, seat_row, hall_id) values (2, 3, 3)	
insert into hall_seat (seat_number, seat_row, hall_id) values (3, 3, 3)	
insert into hall_seat (seat_number, seat_row, hall_id) values (4, 3, 3)
insert into hall_seat (seat_number, seat_row, hall_id) values (5, 3, 3)
--cetvrti red
insert into hall_seat (seat_number, seat_row, hall_id) values (1, 4, 3)	
insert into hall_seat (seat_number, seat_row, hall_id) values (2, 4, 3)	
insert into hall_seat (seat_number, seat_row, hall_id) values (3, 4, 3)	
insert into hall_seat (seat_number, seat_row, hall_id) values (4, 4, 3)
insert into hall_seat (seat_number, seat_row, hall_id) values (5, 4, 3)
--peti red
insert into hall_seat (seat_number, seat_row, hall_id) values (1, 5, 3)	
insert into hall_seat (seat_number, seat_row, hall_id) values (2, 5, 3)	
insert into hall_seat (seat_number, seat_row, hall_id) values (3, 5, 3)	
insert into hall_seat (seat_number, seat_row, hall_id) values (4, 5, 3)
insert into hall_seat (seat_number, seat_row, hall_id) values (5, 5, 3)

--sjediste -- broj sjedista u redu/ broj reda u kojem se sjediste nalazi
--SJEDISTAAA za salu 11 (lemurov bioskop) 7x15 
--prvi red
insert into hall_seat (seat_number, seat_row, hall_id) values (1, 1, 7)	
insert into hall_seat (seat_number, seat_row, hall_id) values (2, 1, 7)	
insert into hall_seat (seat_number, seat_row, hall_id) values (3, 1, 7)	
insert into hall_seat (seat_number, seat_row, hall_id) values (4, 1, 7)
insert into hall_seat (seat_number, seat_row, hall_id) values (5, 1, 7)	
insert into hall_seat (seat_number, seat_row, hall_id) values (6, 1, 7)	
insert into hall_seat (seat_number, seat_row, hall_id) values (7, 1, 7)	
insert into hall_seat (seat_number, seat_row, hall_id) values (8, 1, 7)
insert into hall_seat (seat_number, seat_row, hall_id) values (9, 1, 7)	
insert into hall_seat (seat_number, seat_row, hall_id) values (10, 1, 7)
insert into hall_seat (seat_number, seat_row, hall_id) values (11, 1, 7)
insert into hall_seat (seat_number, seat_row, hall_id) values (12, 1, 7)
insert into hall_seat (seat_number, seat_row, hall_id) values (13, 1, 7)
insert into hall_seat (seat_number, seat_row, hall_id) values (14, 1, 7)
insert into hall_seat (seat_number, seat_row, hall_id) values (15, 1, 7)
--drugi red
insert into hall_seat (seat_number, seat_row, hall_id) values (1, 2, 7)	
insert into hall_seat (seat_number, seat_row, hall_id) values (2, 2, 7)	
insert into hall_seat (seat_number, seat_row, hall_id) values (3, 2, 7)	
insert into hall_seat (seat_number, seat_row, hall_id) values (4, 2, 7)
insert into hall_seat (seat_number, seat_row, hall_id) values (5, 2, 7)	
insert into hall_seat (seat_number, seat_row, hall_id) values (6, 2, 7)	
insert into hall_seat (seat_number, seat_row, hall_id) values (7, 2, 7)	
insert into hall_seat (seat_number, seat_row, hall_id) values (8, 2, 7)
insert into hall_seat (seat_number, seat_row, hall_id) values (9, 2, 7)	
insert into hall_seat (seat_number, seat_row, hall_id) values (10, 2, 7)
insert into hall_seat (seat_number, seat_row, hall_id) values (11, 2, 7)
insert into hall_seat (seat_number, seat_row, hall_id) values (12, 2, 7)
insert into hall_seat (seat_number, seat_row, hall_id) values (13, 2, 7)
insert into hall_seat (seat_number, seat_row, hall_id) values (14, 2, 7)
insert into hall_seat (seat_number, seat_row, hall_id) values (15, 2, 7)
--treci red
insert into hall_seat (seat_number, seat_row, hall_id) values (1, 3, 7)	
insert into hall_seat (seat_number, seat_row, hall_id) values (2, 3, 7)	
insert into hall_seat (seat_number, seat_row, hall_id) values (3, 3, 7)	
insert into hall_seat (seat_number, seat_row, hall_id) values (4, 3, 7)
insert into hall_seat (seat_number, seat_row, hall_id) values (5, 3, 7)	
insert into hall_seat (seat_number, seat_row, hall_id) values (6, 3, 7)	
insert into hall_seat (seat_number, seat_row, hall_id) values (7, 3, 7)	
insert into hall_seat (seat_number, seat_row, hall_id) values (8, 3, 7)
insert into hall_seat (seat_number, seat_row, hall_id) values (9, 3, 7)	
insert into hall_seat (seat_number, seat_row, hall_id) values (10, 3, 7)
insert into hall_seat (seat_number, seat_row, hall_id) values (11, 3, 7)
insert into hall_seat (seat_number, seat_row, hall_id) values (12, 3, 7)
insert into hall_seat (seat_number, seat_row, hall_id) values (13, 3, 7)
insert into hall_seat (seat_number, seat_row, hall_id) values (14, 3, 7)
insert into hall_seat (seat_number, seat_row, hall_id) values (15, 3, 7)
--cetvrti red
insert into hall_seat (seat_number, seat_row, hall_id) values (1, 4, 7)	
insert into hall_seat (seat_number, seat_row, hall_id) values (2, 4, 7)	
insert into hall_seat (seat_number, seat_row, hall_id) values (3, 4, 7)	
insert into hall_seat (seat_number, seat_row, hall_id) values (4, 4, 7)
insert into hall_seat (seat_number, seat_row, hall_id) values (5, 4, 7)	
insert into hall_seat (seat_number, seat_row, hall_id) values (6, 4, 7)	
insert into hall_seat (seat_number, seat_row, hall_id) values (7, 4, 7)	
insert into hall_seat (seat_number, seat_row, hall_id) values (8, 4, 7)
insert into hall_seat (seat_number, seat_row, hall_id) values (9, 4, 7)	
insert into hall_seat (seat_number, seat_row, hall_id) values (10, 4, 7)
insert into hall_seat (seat_number, seat_row, hall_id) values (11, 4, 7)
insert into hall_seat (seat_number, seat_row, hall_id) values (12, 4, 7)
insert into hall_seat (seat_number, seat_row, hall_id) values (13, 4, 7)
insert into hall_seat (seat_number, seat_row, hall_id) values (14, 4, 7)
insert into hall_seat (seat_number, seat_row, hall_id) values (15, 4, 7)
--peti red
insert into hall_seat (seat_number, seat_row, hall_id) values (1, 5, 7)	
insert into hall_seat (seat_number, seat_row, hall_id) values (2, 5, 7)	
insert into hall_seat (seat_number, seat_row, hall_id) values (3, 5, 7)	
insert into hall_seat (seat_number, seat_row, hall_id) values (4, 5, 7)
insert into hall_seat (seat_number, seat_row, hall_id) values (5, 5, 7)	
insert into hall_seat (seat_number, seat_row, hall_id) values (6, 5, 7)	
insert into hall_seat (seat_number, seat_row, hall_id) values (7, 5, 7)	
insert into hall_seat (seat_number, seat_row, hall_id) values (8, 5, 7)
insert into hall_seat (seat_number, seat_row, hall_id) values (9, 5, 7)	
insert into hall_seat (seat_number, seat_row, hall_id) values (10, 5, 7)
insert into hall_seat (seat_number, seat_row, hall_id) values (11, 5, 7)
insert into hall_seat (seat_number, seat_row, hall_id) values (12, 5, 7)
insert into hall_seat (seat_number, seat_row, hall_id) values (13, 5, 7)
insert into hall_seat (seat_number, seat_row, hall_id) values (14, 5, 7)
insert into hall_seat (seat_number, seat_row, hall_id) values (15, 5, 7)
--sesti red
insert into hall_seat (seat_number, seat_row, hall_id) values (1, 6, 7)	
insert into hall_seat (seat_number, seat_row, hall_id) values (2, 6, 7)	
insert into hall_seat (seat_number, seat_row, hall_id) values (3, 6, 7)	
insert into hall_seat (seat_number, seat_row, hall_id) values (4, 6, 7)
insert into hall_seat (seat_number, seat_row, hall_id) values (5, 6, 7)	
insert into hall_seat (seat_number, seat_row, hall_id) values (6, 6, 7)	
insert into hall_seat (seat_number, seat_row, hall_id) values (7, 6, 7)	
insert into hall_seat (seat_number, seat_row, hall_id) values (8, 6, 7)
insert into hall_seat (seat_number, seat_row, hall_id) values (9, 6, 7)	
insert into hall_seat (seat_number, seat_row, hall_id) values (10, 6, 7)
insert into hall_seat (seat_number, seat_row, hall_id) values (11, 6, 7)
insert into hall_seat (seat_number, seat_row, hall_id) values (12, 6, 7)
insert into hall_seat (seat_number, seat_row, hall_id) values (13, 6, 7)
insert into hall_seat (seat_number, seat_row, hall_id) values (14, 6, 7)
insert into hall_seat (seat_number, seat_row, hall_id) values (15, 6, 7)
--sedmi red
insert into hall_seat (seat_number, seat_row, hall_id) values (1, 7, 7)	
insert into hall_seat (seat_number, seat_row, hall_id) values (2, 7, 7)	
insert into hall_seat (seat_number, seat_row, hall_id) values (3, 7, 7)	
insert into hall_seat (seat_number, seat_row, hall_id) values (4, 7, 7)
insert into hall_seat (seat_number, seat_row, hall_id) values (5, 7, 7)	
insert into hall_seat (seat_number, seat_row, hall_id) values (6, 7, 7)	
insert into hall_seat (seat_number, seat_row, hall_id) values (7, 7, 7)	
insert into hall_seat (seat_number, seat_row, hall_id) values (8, 7, 7)
insert into hall_seat (seat_number, seat_row, hall_id) values (9, 7, 7)	
insert into hall_seat (seat_number, seat_row, hall_id) values (10, 7, 7)
insert into hall_seat (seat_number, seat_row, hall_id) values (11, 7, 7)
insert into hall_seat (seat_number, seat_row, hall_id) values (12, 7, 7)
insert into hall_seat (seat_number, seat_row, hall_id) values (13, 7, 7)
insert into hall_seat (seat_number, seat_row, hall_id) values (14, 7, 7)
insert into hall_seat (seat_number, seat_row, hall_id) values (15, 7, 7)




--vrijeme projekcije - prva sala prvi datum
insert into projection_time (pt_time, pt_price, hall_id, projection_id) values ('07:35', '150', 1, 1)
insert into projection_time (pt_time, pt_price, hall_id, projection_id) values ('18:00', '200', 1, 1)
insert into projection_time (pt_time, pt_price, hall_id, projection_id) values ('21:15', '400', 1, 1)

--vrijeme projekcije - druga sala drugi datum
insert into projection_time (pt_time, pt_price, hall_id, projection_id) values ('18:45', '250', 2, 2)
insert into projection_time (pt_time, pt_price, hall_id, projection_id) values ('20:00', '350', 2, 2)

--vrijeme projekcije - treca sala treci datum
insert into projection_time (pt_time, pt_price, hall_id, projection_id) values ('18:45', '250', 3, 3)
insert into projection_time (pt_time, pt_price, hall_id, projection_id) values ('20:00', '350', 3, 3)
insert into projection_time (pt_time, pt_price, hall_id, projection_id) values ('20:45', '250', 3, 3)
insert into projection_time (pt_time, pt_price, hall_id, projection_id) values ('21:00', '350', 3, 3)

--moze i ovo
insert into projection_time (pt_time, pt_price, hall_id, projection_id) values ('22:00', '350', 1, 3)
insert into projection_time (pt_time, pt_price, hall_id, projection_id) values ('22:00', '350', 2, 1)
insert into projection_time (pt_time, pt_price, hall_id, projection_id) values ('22:00', '350', 3, 2)
insert into projection_time (pt_time, pt_price, hall_id, projection_id) values ('22:00', '350', 1, 3)

insert into projection_time (pt_time, pt_price, hall_id, projection_id) values ('22:00', '350', 1, 4)


--lock stock projection
insert into projection_time (pt_time, pt_price, hall_id, projection_id) values ('16:30', '150', 7, 8)
insert into projection_time (pt_time, pt_price, hall_id, projection_id) values ('18:00', '200', 7, 8)
insert into projection_time (pt_time, pt_price, hall_id, projection_id) values ('21:15', '300', 7, 8)
insert into projection_time (pt_time, pt_price, hall_id, projection_id) values ('23:15', '200', 7, 8)


--projekcija, vrijme projekcije
insert into projection_projection_times (projection_id, projection_times_id) values (1, 1)
insert into projection_projection_times (projection_id, projection_times_id) values (1, 2)
insert into projection_projection_times (projection_id, projection_times_id) values (1, 3)

insert into projection_projection_times (projection_id, projection_times_id) values (2, 4)
insert into projection_projection_times (projection_id, projection_times_id) values (2, 5)

insert into projection_projection_times (projection_id, projection_times_id) values (3, 6)
insert into projection_projection_times (projection_id, projection_times_id) values (3, 7)
insert into projection_projection_times (projection_id, projection_times_id) values (3, 8)
insert into projection_projection_times (projection_id, projection_times_id) values (3, 9)

--lock-stock
insert into projection_projection_times (projection_id, projection_times_id) values (8, 14)
insert into projection_projection_times (projection_id, projection_times_id) values (8, 15)
insert into projection_projection_times (projection_id, projection_times_id) values (8, 16)
insert into projection_projection_times (projection_id, projection_times_id) values (8, 17)



--insert into projection_time_hall_seats (projection_time_id, hall_seats_id) values (1, 1)
--ISTORIJA POSJETA
--insert into reservation (user_id, projection_time_id, price, visited) values (2, 6, 350, 1)
--insert into user_reservations(user_id, reservations_id) value (2, 1)
--insert into reservation_hall_seats(reservation_id, hall_seats_id) value (1, 41)

--insert into reservation (user_id, projection_time_id, price, visited) values (2, 7, 350, 1)
--insert into user_reservations(user_id, reservations_id) value (2, 2)
--insert into reservation_hall_seats(reservation_id, hall_seats_id) value (2, 52)

--insert into reservation (user_id, projection_time_id, price, visited) values (2, 8, 150, 1)
--insert into user_reservations(user_id, reservations_id) value (2, 3)
--insert into reservation_hall_seats(reservation_id, hall_seats_id) value (3, 13)
