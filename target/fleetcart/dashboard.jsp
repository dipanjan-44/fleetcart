<%@ page language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.fleetcart.dao.OrderDAO" %>
<%@ page import="com.fleetcart.model.Order" %>
<%@ page import="com.fleetcart.dao.DriverDAO" %>

<%
String success = request.getParameter("success");
String error = request.getParameter("error");

List<Order> orders = OrderDAO.getAllOrders();
%>

<!DOCTYPE html>
<html>
<head>

<title>FleetCart Dashboard</title>

<!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
rel="stylesheet">

<link rel="stylesheet" href="style.css">

<style>

body {
    background-color: #f4f6f9;
}

/* Statistics cards */

.stat-card {
    border-radius: 12px;
    padding: 20px;
    color: white;
    box-shadow: 0 4px 10px rgba(0,0,0,0.1);
}

.card-orders {
    background: linear-gradient(45deg, #007bff, #0056b3);
}

.card-drivers {
    background: linear-gradient(45deg, #28a745, #1e7e34);
}

.card-pending {
    background: linear-gradient(45deg, #ffc107, #d39e00);
}

/* Table styling */

table {
    background: white;
}

thead {
    background-color: #343a40;
    color: white;
}

/* Alerts */

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

<h2 class="mb-4">Orders Dashboard</h2>

<!-- SUCCESS MESSAGE -->

<% if (success != null) { %>

<div id="successMessage"
class="alert alert-success">

Order Added Successfully!

</div>

<% } %>

<!-- ERROR MESSAGE -->

<% if (error != null) { %>

<div id="errorMessage"
class="alert alert-danger">

Operation failed. Please try again.

</div>

<% } %>

<!-- STATISTICS CARDS -->

<div class="row mb-4">

<div class="col-md-4">

<div class="stat-card card-orders text-center">

<h4>Total Orders</h4>

<h2>

<%= OrderDAO.getTotalOrders() %>

</h2>

</div>

</div>

<div class="col-md-4">

<div class="stat-card card-drivers text-center">

<h4>Active Drivers</h4>

<h2>

<%= DriverDAO.getTotalDrivers() %>

</h2>

</div>

</div>

<div class="col-md-4">

<div class="stat-card card-pending text-center">

<h4>Pending Deliveries</h4>

<h2>

<%= OrderDAO.getPendingOrders() %>

</h2>

</div>

</div>

</div>

<!-- ORDERS TABLE -->

<div class="card">

<div class="card-header bg-dark text-white">

<h5 class="mb-0">Order Management</h5>

</div>

<div class="card-body">

<div class="table-responsive">

<table class="table table-bordered table-hover">

<thead>

<tr>

<th>ID</th>
<th>Customer</th>
<th>Pickup</th>
<th>Delivery</th>
<th>Status</th>
<th>Date</th>
<th>Update</th>
<th>Delete</th>

</tr>

</thead>

<tbody>

<%
for (Order order : orders) {
%>

<tr>

<td><%= order.getId() %></td>

<td><%= order.getCustomer() %></td>

<td><%= order.getPickupLocation() %></td>

<td><%= order.getDeliveryLocation() %></td>

<td>

<form action="update-status" method="post">

<input type="hidden"
name="orderId"
value="<%= order.getId() %>">

<select name="status"
class="form-select">

<option>Pending</option>
<option>Assigned</option>
<option>Delivered</option>

</select>

</td>

<td>

<%= order.getCreatedAt() %>

</td>

<td>

<button type="submit"
class="btn btn-primary btn-sm">

Update

</button>

</form>

</td>

<td>

<form action="delete-order" method="post">

<input type="hidden"
name="orderId"
value="<%= order.getId() %>">

<button type="submit"
class="btn btn-danger btn-sm"
onclick="return confirm('Delete this order?')">

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