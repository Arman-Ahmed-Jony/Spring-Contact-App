<%-- 
    Document   : hello
    Created on : Feb 27, 2019, 12:25:17 PM
    Author     : Arman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="/webjars/bootstrap/4.3.1/css/bootstrap.min.css"
              rel="stylesheet">
        <script src="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <style>

            /* Remove the navbar's default margin-bottom and rounded borders */ 
            .navbar {
                margin-bottom: 0;
                border-radius: 0;
            }

            /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
            .row.content {height: 450px}

            /* Set gray background color and 100% height */
            .sidenav {
                padding-top: 20px;
                background-color: #f1f1f1;
                height: 100%;
            }

            /* Set black background color, white text and some padding */
            footer {
                background-color: #555;
                color: white;
                padding: 15px;
            }

            /* On small screens, set height to 'auto' for sidenav and grid */
            @media screen and (max-width: 767px) {
                .sidenav {
                    height: auto;
                    padding: 15px;
                }
                .row.content {height:auto;} 
            }

            .login-form {
                width: 340px;
                margin: 50px auto;
            }
            .login-form form {
                margin-bottom: 15px;
                background: #f7f7f7;
                box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
                padding: 30px;
            }
            .login-form h2 {
                margin: 0 0 15px;
            }
            .form-control, .btn {
                min-height: 38px;
                border-radius: 2px;
            }
            .btn {        
                font-size: 15px;
                font-weight: bold;
            }

        </style>
        <title>JSP Page</title>
    </head>
    <body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">Logo</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Home</a></li>
        <li><a href="#">About</a></li>
        <li><a href="#">Projects</a></li>
        <li><a href="#">Contact</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </ul>
    </div>
  </div>
</nav>

        <div class="container-fluid text-center">    

            <div class="login-form">
                <form action="/examples/actions/confirmation.php" method="post">
                    <h2 class="text-center">Log in</h2>       
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Username" required="required">
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" placeholder="Password" required="required">
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary btn-block">Log in</button>
                    </div>
                    <div class="clearfix">
                        <label class="pull-left checkbox-inline"><input type="checkbox"> Remember me</label>
                        <a href="#" class="pull-right">Forgot Password?</a>
                    </div>        
                </form>
                <p class="text-center"><a href="#">Create an Account</a></p>
            </div>
        </div>

        <footer class="container-fluid text-center">
            <p>Footer Text</p>
        </footer>


    </body>
</html>
