<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Sign In</title>
<meta name="viewport" content="width=device-width">
<link rel="stylesheet"
    href="https://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"
>
<script type="text/javascript"
    src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"
></script>
<script type="text/javascript"
    src="https://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"
></script>
<style type="text/css">
body {
	padding-top: 40px;
	padding-bottom: 40px;
	background-color: #eee;
}

.form-signin {
	max-width: 330px;
	padding: 15px;
	margin: 0 auto;
}

.form-signin .form-signin-heading,.form-signin .checkbox {
	margin-bottom: 10px;
}

.form-signin .checkbox {
	font-weight: normal;
}

.form-signin .form-control {
	position: relative;
	font-size: 16px;
	height: auto;
	padding: 10px;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
}

.form-signin .form-control:focus {
	z-index: 2;
}

.form-signin input[type="text"] {
	margin-bottom: -1px;
	border-bottom-left-radius: 0;
	border-bottom-right-radius: 0;
}

.form-signin input[type="password"] {
	margin-bottom: 10px;
	border-top-left-radius: 0;
	border-top-right-radius: 0;
}
</style>
</head>
<body>
    <div class="container">
        <form class="form-signin" action="j_spring_security_check"
            method="post">
            <h2 class="form-signin-heading">Please sign in</h2>
            <div>
                <input id="j_username" name="j_username" size="20" maxlength="50" 
                    type="text" class="form-control" placeholder="Email address"/>
                <input id="j_password" name="j_password" size="20" maxlength="50"
                    type="password" class="form-control" placeholder="Password" />
            </div>
            <button class="btn btn-lg btn-primary btn-block" type="submit" value="Login">
                Sign in
            </button>
        </form>
    </div>
</body>
</html>