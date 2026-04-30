<!DOCTYPE html>
<html>
<head>
    <title>FleetCart Login</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background: linear-gradient(135deg, #1e3c72, #2a5298);
            height: 100vh;
        }

        .login-card {
            margin-top: 100px;
            border-radius: 15px;
            box-shadow: 0 10px 25px rgba(0,0,0,0.3);
        }

        .brand-title {
            font-weight: bold;
            color: #1e3c72;
        }
    </style>
</head>

<body>

<div class="container">
    <div class="row justify-content-center">

        <div class="col-md-4">
            <div class="card login-card">

                <div class="card-body">

                    <h3 class="text-center brand-title">
                        FleetCart Login
                    </h3>

                    <form action="LoginServlet" method="post">

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

                        <button class="btn btn-primary w-100">
                            Login
                        </button>
                        <br>

                        <a href="signup.jsp"
                        class="btn btn-success w-100">

                            Sign Up

                        </a>

                    </form>

                </div>

            </div>
        </div>

    </div>
</div>

</body>
</html>