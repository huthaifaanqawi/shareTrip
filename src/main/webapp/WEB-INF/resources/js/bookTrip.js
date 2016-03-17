// pathname is contextRoot/path/path/ so we want to get [1] that is where contextRoot is
	// [0] has "" as a result of split 
	var contextRoot = "/" + window.location.pathname.split( '/' )[1]; 

function makeAjaxCall(code){
	//var dataToSend = JSON.stringify(serializeObject($('#employeeForm')));
	//var data= '{"id" :'+code+'}';
	//var dataToSend = JSON.stringify(data);
	
	$.ajax({
		type: 'POST',
		url: contextRoot + '/userDashBoard/addBook',
		//dataType: "json or html",
//		url: '/Book5Rest/addCategory',
 		data:({id:code}),
 		
		success: function(seats) {
			$('#errors').html("");
			$('#formInput').html("");
			$('#labelseat'+code).text(seats);
			if(seats==0){
				$('#div'+code).style.display='none';
			}
			
 			$("#formInput").append( '<H3 align="center"> Trip BOOKED!! </H3>');
 			$("#formInput").append( '<H4 align="center">'+ $('#labeltitle'+code).text()+'</H4>');
 			$("#formInput").append( '<h4 align="center"> <a href="#" onclick="toggle_visibility(\'formInput\');"><b>EXIT</b> </a> </h4>');
	 	    $('#formInput').show();
		},

		error: function(errorObject){	
			if (errorObject!=null){
				if (errorObject.responseJSON.errorType == "UserNotAvailable") {
		 			$('#success').html("");
		 			$('#errors').html("");
		 			$("#errors").append( '<H3 align="center"> Error(s)!! <H3>');                
		  			    $("#result").append( '<p>');
		  	
		  			    var errorList = errorObject.responseJSON.errors;
		 	 	        $.each(errorList,  function(i,error) {			   
		 		    		$("#errors").append( error.message + '<br>');
				    	});
		 	 	        $("#errors").append( '</p>');
		 	 	        $("#errors").append( '<h4 align="center"> <a href="#" onclick="toggle_visibility(\'result\');"><b>EXIT</b> </a> </h4>');
		 		 	    
		 	 	        $('#result').show();
				}
				else {
					alert(errorObject.responseJSON.errors(0));   // "non" Validation Error
				}
			}
		}
	
	});
}

toggle_visibility = function(id) {
    var element = document.getElementById(id);
//    if(element.style.display == 'block')
    	element.style.display = 'none';
//    else
//    	element.style.display = 'block';
 }	

make_hidden = function(id) {
    var element = document.getElementById(id);
    element.style.display = 'none';
        }	   

make_visible = function(id) {
    var element = document.getElementById(id);
    element.style.display = 'block';
 }	   

resetForm = function(id) {
    var element = document.getElementById(id);
    $(element)[0].reset();

    }	  

// Translate form to array
// Then put in JSON format
 function serializeObject (form)
{
    var jsonObject = {};
    var array = form.serializeArray();
    $.each(array, function() {
         	jsonObject[this.name] = this.value;
    });
    return jsonObject;

};

