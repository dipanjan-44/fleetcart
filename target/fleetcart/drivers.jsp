<%@ page import="java.util.List" %>
<%@ page import="com.fleetcart.dao.DriverDAO" %>
<%@ page import="com.fleetcart.model.Driver" %>

<html>

<head>

<title>Drivers</title>

<%
String success = request.getParameter("success");
String error = request.getParameter("error");
%>

<% if (success != null) { %>

<div id="successMessage" class="alert success">
    Driver Added Successfully!
</div>

<% } %>

<% if (error != null) { %>

<div id="errorMessage" class="alert error">
    Operation failed. Please try again.
</div>

<% } %>

<link rel="stylesheet"
href="<%= request.getContextPath() %>/style.css">

</head>

<body>

<jsp:include page="navbar.jsp" />

<div class="container">

<h2>Add Driver</h2>

<form action="add-driver" method="post">

Name:

<br>

<input type="text" name="name" required>

<br><br>

Phone:

<br>

<input type="text" name="phone" required>

<br><br>

Status:

<br>

<select name="status">

<option>Available</option>
<option>On Delivery</option>

</select>

<br><br>

<button type="submit">

Add Driver

</button>

</form>

<br><br>

<h2>Driver List</h2>

<table border="1" width="100%">

<tr>

<th>ID</th>
<th>Name</th>
<th>Phone</th>
<th>Status</th>

</tr>

<%

List<Driver> drivers =
        DriverDAO.getAllDrivers();

for (Driver driver : drivers) {

%>

<tr>

<td><%= driver.getId() %></td>

<td><%= driver.getName() %></td>

<td><%= driver.getPhone() %></td>

<td><%= driver.getStatus() %></td>

</tr>

<%

}

%>

</table>

</div>

<script>
setTimeout(function () {
    var successMsg = document.getElementById("successMessage");
    var errorMsg = document.getElementById("errorMessage");

    if (successMsg) {
        successMsg.classList.add("fade-out");
    }

    if (errorMsg) {
        errorMsg.classList.add("fade-out");
    }
}, 3000); // disappears after 3 seconds
</script>

</body>

</html>