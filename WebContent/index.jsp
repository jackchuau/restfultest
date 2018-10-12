



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<script src="jquery/jquery-3.3.1.min.js"></script>
	
<script type="text/javascript">
	
	
	function question(id) {
		var str = $('#str'+id).val();
		if(id==1){
			name = 'stringClean';
		}else if(id==2){
			name = 'maxBlock';
		}else{
			name=' reorderBlock';
		}

	    $.ajax({
	    	type: "GET",
	        url: 'http://localhost:8080/test/rest/findAnswer/'+name+"/"+str,
	        dataType: 'text',
	        success: function(text) {
	        	$('#answer'+id).html(text);
	        },
	        error: function(text) {
	        	alert("error");
	        }
    	});
	}
	


</script>

</head>
<body>
	<h3>Oracle Technical Test Answer From ZE(Jack) CHU</h3>
	
	<p>To find answers please type the url: </p>
	<p>http://localhost:8080/test/rest/findAnswer/stringClean/<input type="text" placeholder="yourString" id="str1">  <button onclick="question(1);">Answer 1</button><span id='answer1'></span></p>
	<p>http://localhost:8080/test/rest/findAnswer/maxBlock/<input type="text" placeholder="yourString" id="str2"> <button onclick="question(2);">Answer 2</button><span id='answer2'></span></p>
	<p>http://localhost:8080/test/rest/findAnswer/reorderBlock/<input type="text" placeholder="yourString" id="str3"> <button onclick="question(3);">Answer 3</button><span id='answer3'></span></p>
	<p></p>
	<p>Wish you all the best, thank you.</p>

</body>
</html>