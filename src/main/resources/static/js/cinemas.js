var cinemas="../api/cinemastheatres/getCinemas"
	
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

	function generateRepertoire(id){
		$.ajax({
			url: "../api/cinemastheatres/" +id+ "/getMoviesShows",
			method: "GET",
			success: function(data){
				$("#movies").empty();
				for(i=0; i<data.length; i++){
					$("#movies").append(`<p id=`+data[i].id+`> Naziv: `+data[i].name+` <br> Zanr: `+data[i].genre+` 
					<br> Trajanje: `+data[i].duration+`  <br> Rejting: `+data[i].rating+` <hr> </p>`);
				}
			},
			error: function(){
				alert("greska greska greska");
			}
		});
	
	}
	
	