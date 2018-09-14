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
                              <td align="center"><button type="button" onclick="generateRepertoire(`+data[i].id+`)" id=`+data[i].id+` class="btn btn-info btn-sm" data-toggle="modal" data-target="#cinemaModal">Pogledaj</button></td>
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
			 
			 for(i=0; i<data.length; i++){		
				 

				 $(".reservationsTable").append(`<tr>
                              <td><span class="font-weight-bold">`+data[i].projectionTimeDto.projectionDto.date+`</span></td>
                              <td><span class="font-weight-bold">`+data[i].projectionTimeDto.time+`</span></td>
                              <td><span class="font-weight-bold">`+data[i].projectionTimeDto.hallDto.cinemaTheatreDto.name+`</span></td>
                              <td><span class="font-weight-bold">`+data[i].projectionTimeDto.projectionDto.movieShowDto.name+`</span></td>
                              <td align="center"><span class="font-weight-bold">`+data[i].projectionTimeDto.hallDto.hallNumber+`</span></td>
                           
                              <td align="center"><button onclick="projectionDetail(`+data[i].id+`)" type="button" class="btn btn-info btn-xs" >Detaljnije</button></td>
                              <!-- <td align="center"><button onclick="cancelReservation(`+data[i].id+`)" type="button" class="btn btn-danger btn-xs" >Otkazi</button></td> -->
                              
                          </tr>`);
			 }
		 },
		 error: function(){
			 alert("Error while getting reservations!");
		 }
	});
}

function projectionDetail(id){
	$('#projectionModal').modal('show');
	
	$.ajax({
		 url: "../api/reservations/"+id,
		 method: "GET",
		 success: function(data){
			 var seats = [];
			 for(i=0; i<data.hallSeatDtos.length; i++){
				 var seat = "R" + data.hallSeatDtos[i].seatRow + "B" +data.hallSeatDtos[i].seatNumber;
				 seats.push(seat);
			 }
			 
			 $("#titleProjection").empty();
			 $("#titleProjection").append(data.projectionTimeDto.projectionDto.movieShowDto.name);
			 $("#seatsss").empty();
			 $("#seatsss").append(`
					<div class="row">
					 		<div class="column left" style="background-color: rgb(12, 191, 219);">
								<p> <img src="`+data.projectionTimeDto.projectionDto.movieShowDto.poster+`"></p> <hr>
							</div>
							
							<div class="column right" style="background-color: rgb(12, 191, 219);">
								<p id=`+data.id+`>
									<b>Naziv: `+data.projectionTimeDto.projectionDto.movieShowDto.name+`  <br> 
									Trajanje: `+data.projectionTimeDto.projectionDto.movieShowDto.duration+` h <br>
									Datum: `+data.projectionTimeDto.projectionDto.date+` <br>
									Vrijeme: ` +data.projectionTimeDto.time+ ` <br>
									Bioskop: ` +data.projectionTimeDto.projectionDto.movieShowDto.cinemaTheatre.name+ ` <br>
									Adresa: ` +data.projectionTimeDto.projectionDto.movieShowDto.cinemaTheatre.adress+ ` <br>
									Sala: ` +data.projectionTimeDto.hallDto.hallNumber+ ` <br>
									Sjedište: ` +seats+  ` <br>
									
									</b>
								</p>
								
								<button onclick="cancelReservation(`+id+`)" type="button" class="btn btn-danger btn-xs" >Otkaži</button>
							
							</div>
					<div>
			 `);
		 },
		 error: function(){
			 alert("Error while getting reservation!");
		 }
	});
	
}

function cancelReservation(id){
	$.ajax({
		 url: "../api/reservations/cancel/"+id,
		 method: "DELETE",
		 success: function(data){
			 $('#projectionModal').modal('toggle');
			 getReservations();
		 },
		 error: function(){
			 alert("Greska!");
		 }
	});
}

function getFriendRequests(){
	$.ajax({
		 url: "../api/users/getFriendRequests/"+loggeduser.id,
		 method: "GET",
		 success: function(data){
			 $(".requestFriendsTable").empty();
			 for(i=0;i<data.length;i++){
				 $(".requestFriendsTable").append(`<tr>
                                
                                   <td>`+data[i].name+`</td>
                                   <td>`+data[i].surname+`</td>
                                   <td>`+data[i].email+`</td>
                                   <td>`+data[i].city+`</td>
                                   <td>`+data[i].phone+`</td>
                                   <td>
                                   		<button type="button" name=`+data[i].id+` class="btn btn-success btn-xs acceptFriendReq">Prihvati</button>
                                   		<button type="button" name=`+data[i].id+` class="btn btn-danger btn-xs declineFriendReq">Odbij</button>
                                   </td>
                            </tr>`);
			 }
		 },
		 error: function(){
			 alert("Error while getting friend requests!");
		 }
	});
}

function getFriends(){
	$.ajax({
		 url: "../api/users/getFriends/"+loggeduser.id,
		 method: "GET",
		 success: function(data){
			 $(".listFriendsTable").empty();
			 for(i=0;i<data.length;i++){
				 $(".listFriendsTable").append(`<tr>
                                  <td>`+data[i].name+`</td>
                                  <td>`+data[i].surname+`</td>
                                  <td>`+data[i].email+`</td>
                                  <td>`+data[i].city+`</td>
                                  <td>`+data[i].phone+`</td>
                                  <td><button class="btn btn-danger btn-xs" onclick="removeFriend(`+data[i].id+`)">Ukloni</button></td>
                           </tr>`);
			 }
		 },
		 error: function(){
			 alert("Error while getting Friends!");
		 }
	});
}


$(document).on('click','#searchFriends',function(e){
	e.preventDefault();
	var name = $('#friendName').val();
	var surname = $('#friendSurname').val();
	var loggedId = loggeduser.id;
	if(name == ''){
		name = "nema";
	}
	if(surname ==''){
		surname="nema";
	}
	
	$.ajax({
		 url: "../api/users/search/"+name+"/"+surname,
		 method: "GET",
		 success: function(data){
			 $(".friendsTable").empty();
			 for(i=0;i<data.length;i++){
				 if(data[i].id != loggedId){
					 $(".friendsTable").append(`<tr>
	                         <td>`+data[i].name+`</td>
	                         <td>`+data[i].surname+`</td>
	                         <td>`+data[i].email+`</td>
	                         <td><button class="btn btn-success btn-xs" onclick="sendFriendRequest(`+data[i].id+`)">Dodaj</button></td>
	                     </tr>`);
				 }
			 }
				 
		 },
		 error: function(){
			 toastr.error("nije pronadjen korisnik");
		 }
	});
});

function sendFriendRequest(receiverid){
	$.ajax({
		 url: "../api/users/sendFriendRequest/"+receiverid,
		 method: "GET",
		 success: function(){
			 toastr.success("zahtjev poslat");
				 
		 },
		 error: function(){
			 toastr.error("vec poslat zahtjev");
		 }
	});
}

$(document).on('click','.acceptFriendReq', function(e) {
	e.preventDefault();
	var id = $(this).attr('name');
	$.ajax({
		 url: "../api/users/approveFriendRequest/"+id,
		 method: "GET",
		 success: function(){
				 getFriendRequests();
				 getFriends();
		 },
		 error: function(){
			 alert("greska");
		 }
	});
});

$(document).on('click','.declineFriendReq', function(e) {
	e.preventDefault();
	var id = $(this).attr('name');
	$.ajax({
		 url: "../api/users/declineFriendRequest/"+id,
		 method: "GET",
		 success: function(){			 
				 getFriendRequests();
		 },
		 error: function(){
			 alert("greska");
		 }
	});
});

function removeFriend(removingId){
	$.ajax({
		 url: "../api/users/removeFriend/"+removingId,
		 method: "GET",
		 success: function(){
			 getFriends();
		 },
		 error: function(){
			 toastr.error("greska");
		 }
	});
}

