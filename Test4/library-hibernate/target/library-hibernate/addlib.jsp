<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="library.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Add Library</title>
</head>
<body background="library.jpg">
<div class="header">
    <h1><b>Welcome To The Add Section</b></h1>
</div>

<!-- <script type="text/javascript">
	function validateLibraryName(){
		var libname = document.validation.lnm.value;
		var status = false;
		if(libname = ""){
			document.getElementById("libraryName").innerHTML = "Please enter valid Library Name";
			status = false;
		}
		else{
			document.getElementById("libraryName").innerHTML ="Valid Libary Name";
			status = true;
		}
		return status;
	}
</script>
 -->

	<div class="align">
	<form action="addlib">
		Library Id:<input type="text" name="lid"><br><br>
		Library Name:<input type="text" name="lnm"/><br><br> <!-- <span id ="libraryName" style="color:red"></span><br> -->
		No. Of Books:<input type="text" name="nbks"><br><br>
		Book Name:<input type="text" name="bnm"><br><br><br>
		<input type="submit" value="Submit">
	</form>
	</div>
</body>
</html>