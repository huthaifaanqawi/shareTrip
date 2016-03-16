function getVechile(vechile_id){
	var contextRoot = "/" + window.location.pathname.split( '/' )[1];
	var dataToSend = {"id":vechile_id};
	$.ajax({
		type: 'GET',
		url: contextRoot + "/getVechile",
		dataType: "json",    
 		data:dataToSend,
 		contentType: 'application/json',
		success: function( vechile ) {
			          
			$('#vechileNameRent').append( vechile.firstName);
			$("#myModal").modal("show") 
		},

		error: function(errorObject){
		}
	});
}
