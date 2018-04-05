var islogged_url = "../api/users/isLoggedIn"
var logout_url = "../api/users/logout"

function generateNavbar(){
	 $.ajax({
		 url: islogged_url,
		 method: "GET",
		 success: function(data){
			 var user = data;
			 
			 if(user.email != null){
				 $(".navitems").empty();
				 $(".navitems").append(`<li class="nav-item  active">
	                <a class="nav-link" href="reguser.html">` +user.name+ `</a>
	              </li>
	              <li class="nav-item">
	                <a class="nav-link" href="index.html" onclick="logout()">Odjava</a>
	              </li>`);
			 }else{
			    	$(".navitems").empty();
			    	$(".navitems").append(`<li class="nav-item active">
			                <a class="nav-link" href="register.html">Registracija</a>
			              </li>
			              <li class="nav-item">
			                <a class="nav-link" href="login.html">Prijava</a>
			              </li>`);
			 }
	        
	    },
	    error:function(data){
	    	
	    }
	 });
}

function logout(){
	$.ajax({
		 url: logout_url,
		 method: "GET",
		 success: function(){
			 sessionStorage.removeItem('loggedUser');
		 }
	});
}