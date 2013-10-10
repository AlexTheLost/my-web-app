<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"
%>

<html>
<head>
  <title>Sign In</title>
    <meta name="viewport" content="width=device-width">
    <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css">
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
    </style>
</head>
<body>
    <div class="container">
        <form class="form-signin">
            <h1
                style="color: #E32636; font-family: 'Times New Roman'; line-height: normal;"
                class="text-center"
            >Sign In Failure&nbsp;</h1>
            <p align="center">
                <i style="color: #E32636;" class="icon-frown icon-4x"></i>
            </p>
            <ul class="list-group">
                <li class="list-group-item"><a href="signin"
                    class="btn btn-link btn-lg"
                >Repeat login.</a></li>
                <li class="list-group-item"><a href="welcome"
                    class="btn btn-link btn-lg"
                >Go to main page.</a></li>
                <li class="list-group-item"><a href="registration"
                    class="btn btn-link btn-lg"
                >Registration.</a></li>
            </ul>
        </form>
    </div>
</body>
</html>