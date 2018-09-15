package com.isa.projekat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.annotation.PostConstruct;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.isa.projekat.model.CinemaTheatre;
import com.isa.projekat.model.CinemaTheatreType;
import com.isa.projekat.model.Hall;
import com.isa.projekat.model.MovieShow;
import com.isa.projekat.model.MovieShowGenre;
import com.isa.projekat.model.MovieShowType;
import com.isa.projekat.model.Projection;
import com.isa.projekat.model.User;
import com.isa.projekat.model.UserType;
import com.isa.projekat.service.CinemaTheatreService;
import com.isa.projekat.service.HallService;
import com.isa.projekat.service.MovieShowService;
import com.isa.projekat.service.ProjectionService;
import com.isa.projekat.service.UserService;

@Component
public class Data {

	@Autowired
	private UserService userService;
	
	@Autowired
	private CinemaTheatreService ctService;
	
	@Autowired
	private HallService hallService;
	
	@Autowired
	private MovieShowService msService;
	
	@Autowired
	private ProjectionService prService;

	@PostConstruct
	private void add() throws ParseException {

	/*	
		User user = new User();
		user.setName("Ime");
		user.setSurname("Prezime");
		user.setCity("Grad");
		user.setEmail("email@email.com");
		user.setPassword("password");
		user.setPhone("000");
		user.setUserType(UserType.REGISTROVAN);
		user.setVerified(true);
		userService.save(user);
		
		Hall sala1CK = new Hall();
		sala1CK.setNumber(1);
		sala1CK.setRows(2);	//2 reda
		sala1CK.setSeatsPerRow(5);	//4 sjedista u redu (kolone)
		
		Hall sala2CK = new Hall();
		sala2CK.setNumber(2);
		sala2CK.setRows(3);	//3 reda - 3 vrste
		sala1CK.setSeatsPerRow(8);	//8 sjedista u redu (kolone)
		
		hallService.save(sala1CK);
		hallService.save(sala2CK);
		
		Projection prCK1 = new Projection();
		prCK1.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2018-04-27"));
		prService.save(prCK1);
		
		Projection prCK2 = new Projection();
		prCK2.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2018-10-27"));
		prService.save(prCK2);
		//prCK1.setMovieShow(film1CK);
		
		Projection prCK3 = new Projection();
		prCK3.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2018-11-13"));
		prService.save(prCK3);
		
		MovieShow film1CK = new MovieShow();
		film1CK.setName("Fast & Furious");
		film1CK.setActors("Vin Diesel, Paul Walker, Michelle Rodriguez");
		film1CK.setDescription("Brian O'Conner, back working for the FBI in Los Angeles, teams up with Dominic Toretto to bring down a heroin importer by infiltrating his operation.");
		film1CK.setDirector("Justin Lin");
		film1CK.setDuration("1h 47min");
		film1CK.setGenre(MovieShowGenre.ACTION);
		film1CK.setPoster("images/fast.jpg");
		film1CK.setType(MovieShowType.MOVIE);
		film1CK.setRating("3");
		//film1CK.setCinemaTheatre(centarZaKulturu);
		msService.save(film1CK);
		
		MovieShow film2CK = new MovieShow();
		film2CK.setName("Tesko je biti fin");
		film2CK.setActors("Sasa Petrovic, Daria Lorenci, Damir Savic");
		film2CK.setDescription("Taxidriver Fudo wants a happy life with his wife an son. But he has depts. He decides to plan a last coup with his gangster friends.");
		film2CK.setDirector("Srdjan Vuletic");
		film2CK.setDuration("1h 42min");
		film2CK.setGenre(MovieShowGenre.DRAMA);
		film2CK.setPoster("images/tesko.jpg");
		film2CK.setType(MovieShowType.MOVIE);
		film2CK.setRating("5");
		//film1CK.setCinemaTheatre(centarZaKulturu);
		
		film1CK.setProjections(new ArrayList<Projection>());
		film1CK.getProjections().add(prCK1);
		
		msService.save(film2CK);
		
		
		
		CinemaTheatre centarZaKulturu = new CinemaTheatre();
		centarZaKulturu.setName("Centar za kulturu");
		centarZaKulturu.setAdress("Trg pravosljavlja");
		centarZaKulturu.setDescription("Nalazi se u derventi");
		centarZaKulturu.setType(CinemaTheatreType.CINEMA);
		centarZaKulturu.setGrade("4");


		centarZaKulturu.setMovieShows(new ArrayList<MovieShow>());
		centarZaKulturu.getMovieShows().add(film1CK);
		centarZaKulturu.getMovieShows().add(film2CK);
		
		
		ctService.save(centarZaKulturu);
		
		Hibernate.initialize(film1CK.getCinemaTheatre());
		film1CK.setCinemaTheatre(centarZaKulturu);
		msService.save(film1CK);
		
		Hibernate.initialize(film2CK.getCinemaTheatre());
		film2CK.setCinemaTheatre(centarZaKulturu);
		msService.save(film2CK);
		
		Hibernate.initialize(prCK1.getMovieShow());
		prCK1.setMovieShow(film1CK);
		prService.save(prCK1);
		
		Hibernate.initialize(prCK1.getMovieShow());
		prCK3.setMovieShow(film1CK);
		prService.save(prCK3);
		
		Hibernate.initialize(prCK2.getMovieShow());
		prCK2.setMovieShow(film2CK);
		prService.save(prCK2);

		
		*/
		
		
		
	}

}
