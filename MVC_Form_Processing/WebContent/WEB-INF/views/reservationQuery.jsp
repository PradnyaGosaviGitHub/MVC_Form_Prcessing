<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
<title>Reservation Query</title>
</head>

<body>
<form method="post">
Court Name
<input type="text" name="courtName" value="${courtName}" />
<input type="submit" value="Query" />
</form>

<table border="1">
  <tr>
    <th>Court Name</th>
    <th>Date</th>
    <th>Hour</th>
    <th>Player</th>
    <th>Phone</th>
    
  </tr>
  <c:forEach items="${reservations}" var="res">
  <tr>
    <td>${res.courtName}</td>
    <td><fmt:formatDate value="${res.date}" pattern="yyyy-MM-dd" /></td>
    <td>${res.hour}</td>
    <td>${res.player.name}</td>
    <td>${res.player.phone}</td>
   
  </tr>
  </c:forEach>
</table>
</body>
</html>
