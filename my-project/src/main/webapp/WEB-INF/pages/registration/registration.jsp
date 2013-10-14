<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Registration</title>
    <meta name="viewport" content="width=device-width">
    <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <script type="text/javascript" src="https://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
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
      .form-signin .form-signin-heading, .form-signin .checkbox {
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
      span.error {
        color: red;
      }
    </style>
</head>
<body>
    <div class="container">
      <form:form method="post" commandName="registrationForm" class="form-signin">
        <h2 class="form-signin-heading text-center">Registration</h2>
        
        <form:input path="userName" type="text" class="form-control" placeholder="User name" />
        <span class="error">
            <form:errors path="userName" />
        </span>
        <form:input path="email" type="email" class="form-control" placeholder="Email address" />
        <span class="error">
            <form:errors path="email" />
        </span>
        <form:input path="password" type="password" class="form-control" placeholder="Password" />
        <span class="error">
            <form:errors path="password" />
        </span>
        <form:input path="confirmPassword" type="password" class="form-control" placeholder="Confirm Password" />
        <span class="error">
            <form:errors path="confirmPassword" />
        </span>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit registration</button>
      </form:form>
    </div>
</body>
</html>