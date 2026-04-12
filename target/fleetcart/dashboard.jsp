<%@ page language="java" %>

<html>
<head>

<title>FleetCart Dashboard</title>

<link rel="stylesheet" href="style.css">

</head>

<body>

<jsp:include page="navbar.jsp" />

<%@ page import="java.util.List" %>
<%@ page import="com.fleetcart.dao.OrderDAO" %>
<%@ page import="com.fleetcart.model.Order" %>
<%@ page import="com.fleetcart.dao.DriverDAO" %>

<div class="container">

<h2>Orders Dashboard</h2>

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

List<Order> orders =
        OrderDAO.getAllOrders();

for (Order order : orders) {

%>

<tr>

<td><%= order.getId() %></td>

<td><%= order.getCustomerName() %></td>

<td><%= order.getPickupLocation() %></td>

<td><%= order.getDeliveryLocation() %></td>

<!-- STATUS -->

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

<!-- DATE -->

<td>
<%= order.getCreatedAt() %>
</td>

<!-- UPDATE BUTTON -->

<td>

<button type="submit">

Update

</button>

</form>

</td>

<!-- DELETE BUTTON -->

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

</div>

</body>

</html>