var cinemas="../api/cinemastheatres/getCinemas"
var islogged_url = "../api/users/isLoggedIn"
var reservations_url = "../api/reservations/getAllForLogged"	
	
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
                              <td align="center"><button type="button" onclick="generateRepertoire(`+data[i].id+`)" id=`+data[i].id+` class="btn btn-info btn-xs" data-toggle="modal" data-target="#cinemaModal">Pogledaj</button></td>
                          </tr>`);
			 }
		 },
		 error: function(){
			 alert("Greska");
		 }
	});
	
	}


	function generateRepertoire(id){
		$.ajax({
			url: "../api/cinemastheatres/"+id+"/getMoviesShows",
			method: "GET",
			success: function(data){
				$("#movies").empty();
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
								</p>
								
								<button type="button" onclick="reservation(`+data[i].id+`)" class="btn btn-info btn-sm">Rezervisi</button> 
							</div>
							
						</div>
							
					`);	
					//<button type="button" onclick="reservation(`+data[i].id+`)" class="btn btn-info btn-sm">Rezervisi</button> <hr> </p>`);	
				}
				

			},
			error: function(){
				alert("greska greska greska");
			}
		});
	
	}
	
	function reservation(){
		$.ajax({
			url: islogged_url,
			method: "GET",
			success: function(data){
				var user = data;
				if(user.email != null){
					$('#cinemaModal').modal('hide');
					$('#modalReservation2').modal('show');	//otvara drugi dijalog
					
					
				}
				else{
					window.location.href = "login.html";
				}
			},
			error: function(){
				alert("Error!!");
			}
		});
		
	}
	
	