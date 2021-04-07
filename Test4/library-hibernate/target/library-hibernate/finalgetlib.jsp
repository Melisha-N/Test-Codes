<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<style>
table, th, td {
  border: 1px solid black;
}
</style>
<meta charset="ISO-8859-1">
<title>Final Get Library</title>
</head>
<body>
<form action="finalgetlib">
	<table>
		<tbody>	
		<tr>
			<th>Library Id</th>
			<th>LibraryName</th>
   			<th>NoOfBooks</th>
   			<th>BookName</th>
		</tr>
				<c:forEach var="library" items="${libraryList}">
				<tr>
				<td>${library.getLibraryId()}</td>
				<td>${library.getLibraryName()}</td>
				<td>${library.getNoOfBooks()}</td>
				<td>${library.getBookName()}</td>
				<td><a href="updatelib.jsp">Update Library</a></td>
				<td><a href="deletelib.jsp">Delete Library</a></td>
				</tr>
				</c:forEach>
				</tbody>	
				</table>
				</form>
			
</body>
</html>