<!DOCTYPE html>
<html>
<head>

<title>FleetCart Sign Up</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
rel="stylesheet">

<style>

body {
    background: linear-gradient(135deg, #1e3c72, #2a5298);
    height: 100vh;
}

.signup-card {
    margin-top: 100px;
    border-radius: 15px;
}

</style>

</head>

<body>

<div class="container">

<div class="row justify-content-center">

<div class="col-md-4">

<div class="card signup-card">

<div class="card-body">

<h3 class="text-center">

Create Account

</h3>

<form action="RegisterServlet"
method="post">

<div class="mb-3">

<label>Username</label>

<input type="text"
name="username"
class="form-control"
required>

</div>

<div class="mb-3">

<label>Password</label>

<input type="password"
name="password"
class="form-control"
required>

</div>

<button class="btn btn-success w-100">

Register

</button>

<br><br>

<a href="login.jsp"
class="btn btn-secondary w-100">

Back to Login

</a>

</form>

</div>

</div>

</div>

</div>

</div>

</body>

</html>