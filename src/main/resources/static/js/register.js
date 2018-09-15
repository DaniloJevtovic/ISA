register_url="../api/users/register"

$(document).on('submit','.register-form', function(e) {
	e.preventDefault();
	var flag = false;
	var p = $('#password').val();
	var cp = $('#password-confirm').val();
	if(p == cp){
		$.ajax({
			type : 'POST',
			url : register_url,
			contentType : 'application/json',
			dataType : "json",
			data:formToJSON(),
			success : function(data) {
				toastr.success("Uspješna registracija");
				$('.register-form').empty();
				$('.register-form').append(`<h3>Uspješno ste se registrovali! 
					Neophodno je da potvrdite registraciju kako biste mogli da se prijavite.
					Link za potvrdu registracije Vam je poslat na email adresu.
					</h3><hr><i><a href="index.html">Povratak na pocetnu stranu.</a></i>`);
				//window.location.href = 'index.html';
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				toastr.error("Greska prilikom registracije!");
			}
		});
	}else{
		toastr.error("Lozinke se moraju poklapati!");
	}
});


function formToJSON() {
	return JSON.stringify({
    "email":$('#email').val(),
    "password":$('#password').val(),
    "name":$('#name').val(),
    "surname":$('#surname').val(),
    "city":$('#city').val(),
    "phone":$('#phone').val()
	});
}