<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="library.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Delete Library</title>
</head>
<body background="library.jpg">
<div class="header">
    <h1><b>Welcome To The Delete Section!</b></h1>
</div>

<script type="text/javascript">
	function validateLibraryName(){
		var libname = document.validation.lnm.value;
		var status = false;
		if(libname == "" || libname == null){
			document.getElementById("libraryName").innerHTML = alert("Please enter valid Library Name");
			status = false;
		}
		else{
			document.getElementById("libraryName").innerHTML =alert("Valid Libary Name");
			status = true;
		}
		return status;
	}
</script>

	<div class="align">
	<form name="validation" action="deletelib" onsubmit="return validateLibraryName()">
		Library Name:<input type="text" name="lnm"><span id ="libraryName" style="color:red"></span><br>
		<input type="submit" value="Submit"/>
	</form>
	</div>
</body>
</html>