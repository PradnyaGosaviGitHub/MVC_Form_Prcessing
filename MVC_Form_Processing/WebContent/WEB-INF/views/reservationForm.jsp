<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reservation Requisition Form</title>
<style type="text/css">
.pageError{
color: red;
font-style: italic;
font-weight: bold;
}
.error {
color:maroon;
font-style: oblique;
font: bold;
}
</style>
</head>
<body>
<form:form method="post" modelAttribute="res">
    <form:errors path="*" cssClass="pageError" /> 
   <table>
   <tr>
      <td>CourtName</td>
      <td><form:input path="courtName"/></td>
      <td><form:errors path="courtName" cssClass="error" /></td>
   </tr>
   
   <tr>
      <td>Hour</td>
      <td><form:input path="hour"/></td>
      <td><form:errors path="hour" cssClass="error" /></td>
   </tr>
   <tr>
      <td>Date</td>
      <td><form:input path="date"/></td>
      <td><form:errors path="date" cssClass="error" /></td>
      </tr>
   <tr>
   <tr>
      <td>Player</td>
      <td><form:input path="player.name"/></td>
      <td><form:errors path="player.name" cssClass="error" /></td>
      </tr>
   <tr>
   <tr>
      <td>Phone</td>
      <td><form:input path="player.phone"/></td>
      <td><form:errors path="player.phone" cssClass="error" /></td>
      </tr>
  
   
   
   
   <td colspan="3"><input type="submit" /></td>
   </tr>  
   </table>
</form:form>
</body>
</html>