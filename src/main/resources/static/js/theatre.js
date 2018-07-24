var theaters="../api/cinemastheatres/getTheaters"
	
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
                              <td align="center"><button type="button" class="btn btn-info btn-sm" data-toggle="modal" data-target="#theatreModal">Pogledaj</button></td>
                           </tr>`);
			 }
		 },
		 error: function(){
			 alert("Greska");
		 }
	});
	}

