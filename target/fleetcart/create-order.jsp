<%@ page language="java" %>

<html>
<head>

<title>Create Order</title>

<link rel="stylesheet" href="style.css">

</head>

<body>

<jsp:include page="navbar.jsp" />

<div class="container">

<h2>Create Delivery Order</h2>

<form action="create-order" method="post">

Customer Name:

<br>

<input type="text" name="customerName" required>

<br><br>

Pickup Location:

<br>

<input type="text" name="pickupLocation" required>

<br><br>

Delivery Location:

<br>

<input type="text" name="deliveryLocation" required>

<br><br>

<button type="submit">

Create Order

</button>

</form>

</div>

</body>

</html>