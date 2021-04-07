<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false" %>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="get.mel">
<h1>Get Data</h1>
<table>
<tbody>
<tr>
		<th>Team ID</th>
		<th>Team Name</th>
		<th>Home Ground</th>
		<th>Captain</th>
</tr>

	<c:forEach var = "team" items = "${tlist}">
	
		<tr>
			<td> ${team.getTeamId()} </td>
			<td> ${team.getTeamName()} </td>
			<td> ${team.getHomeGround()} </td>
			<td> ${team.getCaptain()} </td>
		</tr>
	</c:forEach>
	</tbody>
</table>	

</form>

</body>
</html>



