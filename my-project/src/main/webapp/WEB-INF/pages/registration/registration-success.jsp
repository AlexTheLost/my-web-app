<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
    uri="http://www.springframework.org/security/tags"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Registration Success</title>
    <meta name="viewport" content="width=device-width">
    <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css">
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <script type="text/javascript" src="https://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
    <style type="text/css">
      body {
        padding-top: 50px;
        padding-bottom: 20px;
      }
    </style>
</head>
<body>  
  <body>
    <div class="navbar navbar-inverse navbar-fixed-top"></div>
    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
      <div class="container">
        <h1 class="text-center" style="color: #008000;">Registration Success!</h1>
        <p class="text-center">Congratulate!</p>
        <p></p>
        <p></p>
        <p></p>
      </div>
    </div>
    <!-- /container -->
    <div class="container">
      <p><b><i class="icon-user icon-3x"></i>&nbsp;User data:</b></p>
      <p><b><i>name:&nbsp;${userName}&nbsp;<i class="icon-ok icon-large" style="color: #008000;"></i></i></b></p>
      <p><b><i>email:&nbsp;${email}&nbsp;<i class="icon-ok icon-large" style="color: #008000;"></i></i></b></p>
    </div>
  </body>
</body>
</html>