var cinemas = "../api/cinemastheatres/getCinemas"
var theaters = "../api/cinemastheatres/getTheaters"
	
var loggeduser = JSON.parse(sessionStorage.getItem('loggedUser'));
var edit_url="../api/users/" + loggeduser.id
var reservations_url = "../api/reservations/getAllForLogged"
var visits_url = "../api/reservations/getVisitsForLogged"
var islogged_url = "../api/users/isLoggedIn"
	
var inv_counter = 0;
	
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
                              <td align="center">`+data[i].grade+`</td>
                              <td align="center"><button type="button" onclick="generateRepertoire(`+data[i].id+`, '`+data[i].name+`')" id=`+data[i].id+` class="btn btn-info btn-xs" data-toggle="modal" data-target="#cinemaModal">Pogledaj</button></td>
                          </tr>`);
				}
			},
			error: function(){
				toastr.error("greska u prikazivanju bioskopa");
			}
		});
	
	}

	function getTheaters(){
		$.ajax({
			url: theaters,
			method: "GET",
			success: function(data){
				$(".theatersTable").empty();
				for(i=0;i<data.length;i++){
					$(".theatersTable").append(`<tr>
							<td>`+data[i].name+`</td>
							<td>`+data[i].adress+`</td>
							<td>`+data[i].description+`</td>
							<td align="center">`+data[i].grade+`</td>
							<td align="center"><button type="button" onclick="generateRepertoire(`+data[i].id+`, '`+data[i].name+`')" id=`+data[i].id+` class="btn btn-info btn-xs" data-toggle="modal" data-target="#cinemaModal">Pogledaj</button></td>
                          	</tr>`);
				}
			},
			error: function(){
				toastr.error("greska u prikazivanju pozorista");
			}
	});
	
	}

	//PRIKAZ REPERTOARA
	function generateRepertoire(id, naziv){
		$.ajax({
			url: "../api/cinemastheatres/"+id+"/getMoviesShows",
			method: "GET",
			success: function(data){
				$("#movies").empty();
				$("#naslov").empty();
				$("seatsdiv").empty();
				$("#naslov").append("Repertoar za : " + naziv);
				
				for(i=0; i<data.length; i++){
					$("#movies").append(`
						<div class="row">
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
								
								<button type="button" onclick="reservation(`+data[i].id+`, '`+data[i].name+`')" id="film`+data[i].id+`" class="btn btn-info btn-xs">Rezervisi</button> 
							
							</div>
						 </div>
					`);				
				}
			},
			error: function(){
				toastr.error("nije moguce prikazati repertoar");
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
					$("#dates").append(`<option disabled selected value>odaberite datum</option>`);
					for(i=0;i<data.length;i++){
						 $("#dates").append(`<option id=`+data[i].id+`>`+data[i].date+`</option>`);
					}
					
			},
			error: function(){
				toastr.error("nije moguce prikazati datume projekcija!");
			}
		});
		
	}
	
	//VRIJEME I SALA PROJEKCIJE
 	$(document).on('change','#dates',function(e){
		var msId = $('#film option:selected').attr('id')
		var projectionId = $('#dates option:selected').attr('id')
		$.ajax({
			 url: "../api/movieshows/"+msId+"/projections/"+projectionId+"/projectionTimes",
			 method: "GET",
			 success: function(data){
				 $("#seatsdiv").empty();
				 $("#time").empty();
				 $("#time").append(`<option disabled selected value>odaberite vrijeme</option>`);
				 for(i=0;i<data.length;i++){
					 $("#time").append(`<option name=`+data[i].id+` id=`+data[i].id+`>`+data[i].time+` *`+data[i].hallDto.id+` *`+data[i].price+`</option>`);	//halldto ispravi
				 }
			 },
			 error: function(){
				 toastr.error("nije moguce prikazati vrijeme i salu!");
			 }
		});
	});

	
	$("#events" ).change(function() {
		  alert( "Handler for .select() called." );
	});
	
	//SJEDISTA
	$(document).on('change','#time',function(e){
		var list=[];
		var msId = $('#film option:selected').attr('id')
		var projectionId = $('#dates option:selected').attr('id')
		var timeId = $('#time option:selected').attr('id')

		$.ajax({
			 url: "../api/movieshows/"+msId+"/projections/"+projectionId+"/projectionTimes/"+timeId+"/seats",
			 method: "GET",
			 async : false,
			 success: function(data){
				 $("#seatsdiv").empty();
				 $("#seatsdiv").append(`<div id="seat-map"></div>`);
				 if(data.length != 0){
					 
				 }
				 
				 var hallrows = data[0].hallDto.hallRows;
				 var seatsperrow = data[0].hallDto.seatsPerRow;
				
				 for(i=0; i<hallrows; i++){
					 var row ='';
					 for(j=0; j<seatsperrow; j++){
							row+='a';
					 }
					 list.push(row);
				 }
				 flag = true;
			 },
			 error: function(){
				 toastr.error("greska u prikazu sjedista!");
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
	
	
	//REZERVACIJA
	$(document).on('click','#reserveProjection',function(e){
		var msId = $('#film option:selected').attr('id')
		var projectionId = $('#dates option:selected').attr('id')
		var timeId = $('#time option:selected').attr('id')
		var sc = $('#seat-map').seatCharts();
		$.ajax({
			 url: "../api/movieshows/"+msId+"/projections/"+projectionId+"/projectionTimes/"+timeId+"/seats",
			 method: "POST",
			 contentType : 'application/json',
			 dataType : "json",
			 data:JSON.stringify(sc.find('a.selected').seatIds),
			 success: function(res){
				 $("#invitediv").empty();
				 $("#invitediv").attr("name",res.id)
				 inv_counter = res.hallSeatDtos.length;
				 
				 if(res.hallSeatDtos.length > 1){
					 generateFriendsForInv();
				 }
				 
				 sc.find('a.selected').status('unavailable');
				 //window.location.href = 'userReservations.html';
				 
				 $('#modalReservation2').modal('toggle');
				 toastr.success("uspjesna rezervacija");
				 
				 getReservations();
				 getVisits();
			 },
			 error: function(){
				 toastr.error("greska u rezervaciji sjedista!");
			 }
		});
	    
	});
	
	
	function generateTakenSeats(){
		var msId = $('#film option:selected').attr('id')
		var projectionId = $('#dates option:selected').attr('id')
		var timeId = $('#time option:selected').attr('id')
		var sc = $('#seat-map').seatCharts();
		$.ajax({
			 url: "../api/movieshows/"+msId+"/projections/"+projectionId+"/projectionTimes/"+timeId+"/takenSeats",
			 method: "GET",
			 success: function(data){
				 for(i=0; i<data.length; i++){
					 var temp = data[i].seatRow+"_"+data[i].seatNumber;		
					 sc.get(temp).status('unavailable');
				 }
			 },
			 error: function(){
				 toastr.error("greska u prikazu rezervisanih sjedista!");
			 }
		});
	}

	
	
	function generateFriendsForInv(){
		//$('#modalReservation2').modal('hide');
		$('#inviteModal').modal('show');
		$.ajax({
			 url: "../api/users/getFriends/"+loggeduser.id,
			 method: "GET",
			 success: function(data){
				 $("#inviteFriend").append(`<table class="table table-hover table-striped">
						 <thead class="thead-dark">
							<tr>
								<th scope="col">Ime</th>
								<th scope="col">Prezime</th>
								<th scope="col">Email</th>
								<th scope="col">Grad</th>
							</tr>
						 </thead>
						<tbody id ="invtable"></tbody>
				 	</table>`);
				 
				 if(data.length > 0){
					 for(i=0; i<data.length; i++){
						 $("#invtable").append(`<tr>
								 <td>`+data[i].name+`</td>
								 <td>`+data[i].surname+`</td>
								 <td>`+data[i].email+`</td>
								 <td>`+data[i].city+`</td>
								 <td><button type="button" id=`+data[i].id+` class="btn btn-primary btn-xs invbutton">Pozovi</button></td></tr>`);
					 }
				 }else{
					 toastr.info("nemate prijatelja")
				 }
			 },
			 error: function(){
				 toastr.error("greska u pozivanju prijatelja");
			 }
		});
	}
	
	$(document).on('click','.invbutton',function(e){
		var resId = $("#invitediv").attr("name");
		var userId = $(this).attr("id");
		$(this).attr('disabled',true);
		if(inv_counter-1 > 0){
			$.ajax({
				 url: "../api/reservations/"+resId+"/sendInvite/"+userId,
				 method: "GET",
				 success: function(data){
					 toastr.success("prijatelj pozvan");
					 inv_counter-=1;
				 },
				 error: function(){
					 alert("greska");
				 }
			});
			
		}else{
			toastr.error("nema vise sjedista")
		}
	});

	