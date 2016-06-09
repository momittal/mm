  //Function to create textbox based on regular expressions
  	function acceptRegExOnly(event, regex)  
  	{   
  	    var keyCode = event.which ? event.which : event.keyCode;
  	    
  	    var keyPressed = String.fromCharCode(keyCode);
  	    return regex.test(keyPressed);
  	}; 
  	