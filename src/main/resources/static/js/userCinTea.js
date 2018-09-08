var cinemas = "../api/cinemastheatres/getCinemas"
var theaters = "../api/cinemastheatres/getTheaters"
	
var loggeduser = JSON.parse(sessionStorage.getItem('loggedUser'));
var edit_url="../api/users/" + loggeduser.id
var reservations_url = "../api/reservations/getAllForLogged"
var visits_url = "../api/reservations/getVisitsForLogged"
var islogged_url = "../api/users/isLoggedIn"
	
	function getCinemas(){
	$.ajax({
		 url: cinemas,
		 method: "GET",
		 success: function(data){
			 $(".cinemasTable").empty();
			 for(i=0;i<data.length;i++){
				 $(".cinemasTable").append(`<tr>
                              <td>`+data[i].name+`</td>
                              <td>`+data[i].adress+`</td>
                              <td>`+data[i].description+`</td>
                              <td align="center"><button type="button" onclick="generateRepertoire(`+data[i].id+`, '`+data[i].name+`')" id=`+data[i].id+` class="btn btn-info btn-sm" data-toggle="modal" data-target="#cinemaModal">Pogledaj</button></td>
                          </tr>`);
			 }
		 },
		 error: function(){
			 alert("Greska");
		 }
	});
	
	}

	
	function generateRepertoire(id, naziv){
		$.ajax({
			url: "../api/cinemastheatres/"+id+"/getMoviesShows",
			method: "GET",
			success: function(data){
				$("#movies").empty();
				$("#events").empty();
				$("#naslov").empty();
				$("seatsdiv").empty();
				$("#naslov").append("Repertoar za : " + naziv);
				for(i=0; i<data.length; i++){
					$("#movies").append(`
							<div class="column left" style="background-color: orange;">
								<p> <img src="`+ data[i].poster + `"></p> <hr>
							</div>
							
							<div class="column right" style="background-color: orange;">
								<p id=`+data[i].id+`>
									<b>Naziv: `+data[i].name+` </b> <br> 
									Zanr: `+data[i].genre+` <br>
									Glumci: ` +data[i].actors+ ` <br>
									Trajanje: `+data[i].duration+` <br>  
									Rejting: `+data[i].rating+` <br> 
									Direktor: ` + data[i].director+ ` <br>
									Opis : ` +data[i].description+` <br>
									id : `+data[i].id+`
								</p>
								
								<button type="button" onclick="reservation(`+data[i].id+`, '`+data[i].name+`')" id="film`+data[i].id+`" class="btn btn-info btn-sm">Rezervisi</button> 
							
							</div>
					`);				
				}
			},
			error: function(){
				alert("greska greska greska");
			}
		});
	
	}

	//DATUM PROJEKCIJE
	function reservation(id, naziv){
		
		$.ajax({
			url: "../api/movieshows/"+id+"/projections",
			method: "GET",
			success: function(data){

					$('#cinemaModal').modal('toggle');
					$('#modalReservation2').modal('show');	//otvara drugi dijalog
					
					$("#film").empty();
					$("#dates").empty();
					$("#times").empty();
					$("seatsdiv").empty();
					//$("#film").append(naziv);
					$("#film").append(`<option id=`+id+`>`+naziv+`</option>`);
					
					
					$("#dates").empty();
					//$("#dates").append(`<option>odaberite datum</option>`);
					for(i=0;i<data.length;i++){
						 $("#dates").append(`<option id=`+data[i].id+`>`+data[i].date+`</option>`);
						 

					}
					
					/*
					$.ajax({
						 url: "../api/movieshows/"+id+"/projections/"+id+"/projectionTimes",
						 method: "GET",
						 success: function(data){
							 $("#time").empty();
							 for(i=0;i<data.length;i++){
								 $("#time").append(`<option name=`+data[i].id+` id=`+data[i].id+`>`+data[i].time+`* `+data[i].hallDto.id+`* `+data[i].price+`</option>`);	//halldto ispravi
							 }
						 },
						 error: function(){
							 alert("Error while getting projectiontimes!");
						 }
					});
					
					*/
					

			},
			error: function(){
				alert("Error!!");
			}
		});
		
	}
	
	//VRIJEME I SALA PROJEKCIJE
 	$(document).on('change','#dates',function(e){
		var eventId = $('#film option:selected').attr('id')
		var projectionId = $('#dates option:selected').attr('id')
		$.ajax({
			 url: "../api/movieshows/"+eventId+"/projections/"+projectionId+"/projectionTimes",
			 method: "GET",
			 success: function(data){
				 $("#time").empty();
				 //$("#time").append(`<option>odaberite salu</option>`);
				 for(i=0;i<data.length;i++){
					 
					 $("#time").append(`<option name=`+data[i].id+` id=`+data[i].id+`>`+data[i].time+` *`+data[i].hallDto.id+` *`+data[i].price+`</option>`);	//halldto ispravi
				 }
			 },
			 error: function(){
				 alert("Error while getting projectiontimes!");
			 }
		});
	});

	
	$("#events" ).change(function() {
		  alert( "Handler for .select() called." );
	});
	
	//SJEDISTA
	$(document).on('change','#time',function(e){
		var list=[];
		var eventId = $('#film option:selected').attr('id')
		var projectionId = $('#dates option:selected').attr('id')
		var timeId = $('#time option:selected').attr('id')

		$.ajax({
			 url: "../api/movieshows/"+eventId+"/projections/"+projectionId+"/projectionTimes/"+timeId+"/seats",
			 method: "GET",
			 async : false,
			 success: function(data){
				 $("#seatsdiv").empty();
				 $("#seatsdiv").append(`<div id="seat-map"></div>`);
				 if(data.length != 0){
					 
				 }
				 
				var hallrows = data[0].hallDto.hallRows;
				var seatsperrow = data[0].hallDto.seatsPerRow;
				
				for(i=0;i<hallrows;i++){
					var row ='';
					for(j=0;j<seatsperrow;j++){
							row+='a';
					}
					list.push(row);
				}
				flag = true;
				$("#timesdiv").hide();
			 },
			 error: function(){
				 alert("Error while getting seats!");
			 }
		});

		var sc = $('#seat-map').seatCharts({
			map:list,
			seats: {
				a: {
					price   : 99.99,
					classes : 'front-seat'
				}
			
			},
			click: function () {
				if (this.status() == 'available') {
					//do some stuff, i.e. add to the cart
					return 'selected';
				} else if (this.status() == 'selected') {
					//seat has been vacated
					return 'available';
				} else if (this.status() == 'unavailable') {
					//seat has been already booked
					return 'unavailable';
				} else {
					return this.style();
				}
			}
		});
		
		generateTakenSeats();
		
		sc.find('c.available').status('unavailable');
		
		
	});
	
	function generateTakenSeats(){
		var eventId = $('#film option:selected').attr('id')
		var projectionId = $('#dates option:selected').attr('id')
		var timeId = $('#time option:selected').attr('id')
		var sc = $('#seat-map').seatCharts();
		$.ajax({
			 url: "../api/movieshows/"+eventId+"/projections/"+projectionId+"/projectionTimes/"+timeId+"/takenSeats",
			 method: "GET",
			 success: function(data){
				 for(i=0;i<data.length;i++){
					 var temp = data[i].seatRow+"_"+data[i].seatNumber;		
					 sc.get(temp).status('unavailable');
				 }
			 },
			 error: function(){
				 alert("Error while getting taken seats!");
			 }
		});
	}

	
	//REZERVACIJA
	$(document).on('click','#reserveProjection',function(e){
		var eventId = $('#film option:selected').attr('id')
		var projectionId = $('#dates option:selected').attr('id')
		var timeId = $('#time option:selected').attr('id')
		var sc = $('#seat-map').seatCharts();
		$.ajax({
			 url: "../api/movieshows/"+eventId+"/projections/"+projectionId+"/projectionTimes/"+timeId+"/seats",
			 method: "POST",
			 contentType : 'application/json',
			 dataType : "json",
			 data:JSON.stringify(sc.find('a.selected').seatIds),
			 success: function(res){
				 sc.find('a.selected').status('unavailable');
				 //getReservations();
				 window.location.href = 'userReservations.html';
			 },
			 error: function(){
				 alert("Greska u rezervaciji sjedista!");
				 //location.reload();
			 }
		});
	    
	});

	
	function getReservations(){
		$.ajax({
			 url: reservations_url,
			 method: "GET",
			 success: function(data){
				 $(".reservationsTable").empty();
				 for(i=0;i<data.length;i++){
					 $(".reservationsTable").append(`<tr>
	                              <td><span class="font-weight-bold">`+data[i].projectionTimeDto.projectionDto.date+`</span></td>
	                              <td><span class="font-weight-bold">`+data[i].projectionTimeDto.time+`</span></td>
	                              <td><span class="font-weight-bold">`+data[i].projectionTimeDto.hallDto.cinemaTheatreDto.name+`</span></td>
	                              <td><span class="font-weight-bold">`+data[i].projectionTimeDto.projectionDto.movieShowDto.name+`</span></td>
	                              <td><span class="font-weight-bold">`+data[i].projectionTimeDto.projectionDto.movieShowDto.name+`</span></td>
	                              <td align="center"><button onclick="cancelReservation(`+data[i].id+`)" type="button" class="btn btn-danger btn-sm" >Otkazi</button></td>
	                              
	                          </tr>`);
				 }
			 },
			 error: function(){
				 alert("Error while getting reservations!");
			 }
		});
	}
	
	