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


