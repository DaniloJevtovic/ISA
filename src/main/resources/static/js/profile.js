var cinemas="../api/cinemastheatres/getCinemas"
var theaters="../api/cinemastheatres/getTheaters"

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
                              <td align="center"><button type="button" onclick="generateRepertoire(`+data[i].id+`)" id=`+data[i].id+` class="btn btn-info btn-sm" data-toggle="modal" data-target="#exampleModalR">Pogledaj</button></td>
                          </tr>`);
			 }
		 },
		 error: function(){
			 alert("Greska");
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
                              <td align="center"><button type="button" class="btn btn-info btn-sm" data-toggle="modal" data-target="#exampleModalR">Rezervisi</button></td>
                           </tr>`);
			 }
		 },
		 error: function(){
			 alert("Greska");
		 }
	});
}
	
$(document).on('submit','#editform', function(e) {
	e.preventDefault();
	var p = $('#password').val();
	var cp = $('#password-confirm').val();
	if(p == cp){
		$.ajax({
			type : 'PUT',
			url : edit_url,
			contentType : 'application/json',
			dataType : "json",
			data:formToJSON(),
			success : function(data) {
				//location.reload();
				
				sessionStorage.setItem('loggedUser',JSON.stringify(data));
				window.location.href = "profile.html"
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert("AJAX ERROR: " + errorThrown + "load profile");
			}
		});
	}else{
		alert("Lozinke se moraju poklapati!");
	}
});


function formToJSON() {
	return JSON.stringify({
	"id":loggeduser.id,
	"email":loggeduser.email,
    "name":$('#name').val(),
    "surname":$('#surname').val(),
    "city":$('#city').val(),
    "phone":$('#phone').val(),
    "password":$('#password').val()
	});
}

function generateUserInfo(){
	document.getElementById("name").value = loggeduser.name;
	document.getElementById("surname").value = loggeduser.surname;
	document.getElementById("city").value = loggeduser.city;
	document.getElementById("phone").value = loggeduser.phone;
	document.getElementById("password").value = loggeduser.password;
	document.getElementById("password-confirm").value = loggeduser.password;
	//document.getElementById("email").value = loggeduser.email;
}

function generateProfile(){
	$("#emaildata").append(`<td>`+loggeduser.email+`</td>`);
	$("#namedata").append(`<td>`+loggeduser.name+`</td>`);
	$("#surnamedata").append(`<td>`+loggeduser.surname+`</td>`);
	$("#citydata").append(`<td>`+loggeduser.city+`</td>`);
	$("#phonedata").append(`<td>`+loggeduser.phone+`</td>`);
}

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

function generateRepertoire(id){
	$.ajax({
		url: "../api/cinemastheatres/"+id+"/getMoviesShows",
		 method: "GET",
		 success: function(data){
			 $("#events").empty();
			 $("#projectiondiv").empty();
			 $("#timesdiv").empty();
			 $("#seatsdiv").empty();
			 for(i=0;i<data.length;i++){
				 $("#events").append(`<option id=`+data[i].id+`>`+data[i].name+`</option>`);
			 }
		 },
		 error: function(){
			 alert("Error while getting repertoire!");
		 }
	});
	
}


$(document).on('click','#genProjectionDates',function(e){
	e.preventDefault();
	var id = $('#events option:selected').attr('id')
	$.ajax({
		url: "../api/movieshows/"+id+"/projections",
		 method: "GET",
		 success: function(data){
			 $("#projectiondiv").empty();
			 $("#timesdiv").empty();
			 $("#seatsdiv").empty();
			 if(data.length != 0){
				 //$("#projectiondiv").append(`<label for="projectiondates">Datum: </label>`);
				 $("#projectiondiv").append(`<select id="projectiondates">
	                              	</select>
	                              	<button type="button" class="btn btn-info btn-sm" id="genProjectionTimes">Nastavi</button>`);
				 
			 }
			 for(i=0;i<data.length;i++){
				 $("#projectiondates").append(`<option id=`+data[i].id+`>Datum: `+data[i].date+`</option>`);
			 }
			 $("#eventslabel").hide();
			 $("#events").hide();
			 $("#genProjectionDates").hide();
		 },
		 error: function(){
			 alert("Error while getting projections!");
		 }
	});
});



$(document).on('click','#genProjectionTimes',function(e){
	var eventId = $('#events option:selected').attr('id')
	var projectionId = $('#projectiondates option:selected').attr('id')
	$.ajax({
		 url: "../api/movieshows/"+eventId+"/projections/"+projectionId+"/projectionTimes",
		 method: "GET",
		 success: function(data){
			 $("#projectiondiv").empty();
			 $("#timesdiv").empty();
			 $("#seatsdiv").empty();
			 if(data.length != 0){
				 //$("#timesdiv").append(`<label for="projectiontimes">Vrijeme i sala: </label>`);
				 $("#timesdiv").append(`<select id="projectiontimes"></select>
	                              		<button type="button" class="btn btn-info btn-sm" id="genSeats">Nastavi</button>`);
			 }
			 for(i=0;i<data.length;i++){
				 $("#projectiontimes").append(`<option name=`+data[i].id+` id=`+data[i].id+`>Vrijeme: `+data[i].time+` Sala:`+data[i].hallDto.id+` Cijena:`+data[i].price+`</option>`);	//halldto ispravi
			 }
		 },
		 error: function(){
			 alert("Error while getting projectiontimes!");
		 }
	});
});



function cancelReservation(id){
	$.ajax({
		 url: "../api/reservations/cancel/"+id,
		 method: "DELETE",
		 success: function(data){
			 getReservations();
		 },
		 error: function(){
			 alert("Greska!");
		 }
	});
}

var user = JSON.parse(sessionStorage.getItem('loggedUser'));

$(document).on('click','#genSeats',function(e){
	var list=[];
	var eventId = $('#events option:selected').attr('id')
	var projectionId = $('#projectiondates option:selected').attr('id')
	var timeId = $('#projectiontimes option:selected').attr('id')

	$.ajax({
		 url: "../api/movieshows/"+eventId+"/projections/"+projectionId+"/projectionTimes/"+timeId+"/seats",
		 method: "GET",
		 async : false,
		 success: function(data){
			 $("#seatsdiv").empty();
			 $("#seatsdiv").append(`<div id="seat-map"></div>
									<button type="button" id="reserveProjection" class="btn btn-primary">Rezervisi</button>`);
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

$(document).on('click','#reserveProjection',function(e){
	var eventId = $('#events option:selected').attr('id')
	var projectionId = $('#projectiondates option:selected').attr('id')
	var timeId = $('#projectiontimes option:selected').attr('id')
	var sc = $('#seat-map').seatCharts();
	$.ajax({
		 url: "../api/movieshows/"+eventId+"/projections/"+projectionId+"/projectionTimes/"+timeId+"/seats",
		 method: "POST",
		 contentType : 'application/json',
		 dataType : "json",
		 data:JSON.stringify(sc.find('a.selected').seatIds),
		 success: function(res){
			 sc.find('a.selected').status('unavailable');
			 getReservations();
			 getVisits();
		 },
		 error: function(){
			 //alert("Greska u rezervaciji sjedista!");
			 location.reload();
		 }
	});
    
});

//generisi zauzeta sjedista
function generateTakenSeats(){
	var eventId = $('#events option:selected').attr('id')
	var projectionId = $('#projectiondates option:selected').attr('id')
	var timeId = $('#projectiontimes option:selected').attr('id')
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
