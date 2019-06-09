<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
Information page..!

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>information</title>
<script type="text/javascript">
function add() {
	alert("***Add employee***")
	document.myform.action="register.jsp"
	document.myform.submit();
	
}

</script>
</head>
<body>

<form name="myform">
   <table border="2">
      <tr>
      <th>select</th>
      <th>Employee ID</th>
      <th>Name</th>
      <th>Address</th>
      <th>Mobile no</th>
      <th>User name</th>
      <th>Password</th>

      </tr>
      
      <c:forEach items="${data}" var="e">
      <tr>
      <td><input type="radio" name="id" value="${e.empid}"></td>
      <td><c:out value="${e.empid}"></c:out></td>
      <td><c:out value="${e.name}"></c:out></td>
      <td><c:out value="${e.address}"></c:out></td>
      <td><c:out value="${e.mono}"></c:out></td>
      <td><c:out value="${e.uname}"></c:out></td>
      <td><c:out value="${e.pass}"></c:out></td>
      
      </tr>
      
      </c:forEach>
      <tr>
      <td><input type="submit" onclick="add()" value="Add">
      <td><input type="submit" onclick="del()" value="Delete">
      </tr>
      
      
      


</table>

</form>

</body>
</html>