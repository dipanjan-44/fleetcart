<%@ page import="java.util.List" %>
<%@ page import="com.fleetcart.dao.DriverDAO" %>
<%@ page import="com.fleetcart.model.Driver" %>

<%
String success = request.getParameter("success");
String error = request.getParameter("error");

List<Driver> drivers =
        DriverDAO.getAllDrivers();
%>

<!DOCTYPE html>
<html>

<head>

<title>Drivers Management</title>

<!-- Bootstrap -->

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
rel="stylesheet">

<link rel="stylesheet"
href="<%= request.getContextPath() %>/style.css">

<style>

body {
    background-color: #f4f6f9;
}

.card {
    border-radius: 12px;
}

.alert {
    transition: opacity 1s ease-out;
}

.fade-out {
    opacity: 0;
}

</style>

</head>

<body>

<jsp:include page="navbar.jsp" />

<div class="container mt-4">

<h2 class="mb-4">

Driver Management

</h2>

<!-- SUCCESS MESSAGE -->

<% if (success != null) { %>

<div id="successMessage"
class="alert alert-success">

Driver Added Successfully!

</div>

<% } %>

<!-- ERROR MESSAGE -->

<% if (error != null) { %>

<div id="errorMessage"
class="alert alert-danger">

Operation failed. Please try again.

</div>

<% } %>

<!-- ADD DRIVER FORM -->

<div class="card mb-4">

<div class="card-header bg-dark text-white">

Add Driver

</div>

<div class="card-body">

<form action="add-driver" method="post">

<div class="row">

<div class="col-md-4">

<label>Name</label>

<input type="text"
name="name"
class="form-control"
required>

</div>

<div class="col-md-4">

<label>Phone</label>

<input type="text"
name="phone"
class="form-control"
required>

</div>

<div class="col-md-4">

<label>Status</label>

<select name="status"
class="form-select">

<option>Available</option>
<option>On Delivery</option>

</select>

</div>

</div>

<br>

<button type="submit"
class="btn btn-primary">

Add Driver

</button>

</form>

</div>

</div>

<!-- DRIVER LIST TABLE -->

<div class="card">

<div class="card-header bg-dark text-white">

Driver List

</div>

<div class="card-body">

<div class="table-responsive">

<table class="table table-bordered table-hover">

<thead>

<tr>

<th>ID</th>
<th>Name</th>
<th>Phone</th>
<th>Status</th>
<th>Delete</th>

</tr>

</thead>

<tbody>

<%
for (Driver driver : drivers) {
%>

<tr>

<td><%= driver.getId() %></td>

<td><%= driver.getName() %></td>

<td><%= driver.getPhone() %></td>

<td><%= driver.getStatus() %></td>

<td>

<form action="delete-driver"
method="post">

<input type="hidden"
name="driverId"
value="<%= driver.getId() %>">

<button type="submit"
class="btn btn-danger btn-sm"
onclick="return confirm('Delete this driver?')">

Delete

</button>

</form>

</td>

</tr>

<%
}
%>

</tbody>

</table>

</div>

</div>

</div>

</div>

<script>

setTimeout(function () {

    var successMsg =
        document.getElementById("successMessage");

    var errorMsg =
        document.getElementById("errorMessage");

    if (successMsg) {
        successMsg.classList.add("fade-out");
    }

    if (errorMsg) {
        errorMsg.classList.add("fade-out");
    }

}, 3000);

</script>

</body>

</html>