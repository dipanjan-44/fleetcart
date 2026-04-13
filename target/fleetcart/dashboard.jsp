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

<html>
<head>

<title>FleetCart Dashboard</title>

<link rel="stylesheet" href="style.css">

</head>

<body>

<jsp:include page="navbar.jsp" />

<div class="container">

<h2>Orders Dashboard</h2>

<% if (success != null) { %>
<div id="successMessage" class="alert success">
    Order Added Successfully!
</div>
<% } %>

<% if (error != null) { %>
<div id="errorMessage" class="alert error">
    Operation failed. Please try again.
</div>
<% } %>

<table border="1" width="100%">

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

<select name="status">

<option>Pending</option>
<option>Assigned</option>
<option>Delivered</option>

</select>

</td>

<td>
<%= order.getCreatedAt() %>
</td>

<td>

<button type="submit">
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
onclick="return confirm('Delete this order?')">
Delete
</button>

</form>

</td>

</tr>

<%
}
%>

</table>

</div>

<!-- STATISTICS CARDS -->

<div class="card">

<h3>Total Orders</h3>

<p>
<%= OrderDAO.getTotalOrders() %>
</p>

</div>

<div class="card">

<h3>Active Drivers</h3>

<p>
<%= DriverDAO.getTotalDrivers() %>
</p>

</div>

<div class="card">

<h3>Pending Deliveries</h3>

<p>
<%= OrderDAO.getPendingOrders() %>
</p>

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