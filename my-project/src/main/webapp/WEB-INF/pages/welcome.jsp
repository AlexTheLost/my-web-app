<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
    uri="http://www.springframework.org/security/tags"
%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Welcome!</title>
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
    <div class="navbar navbar-fixed-top navbar-inverse">
        <div class="container pull-left">
            <div class="navbar-header">
                <a class="navbar-brand" href="welcome"><i class="icon-home"></i><b>&nbsp;<spring:message code="label.home"/></b></a>
                <sec:authorize access="isAuthenticated()">
                    <a class="navbar-brand" href=""><b><i class="icon-calendar"></i>&nbsp;<spring:message code="label.my_events"/></b></a>
                    <a class="navbar-brand" href=""><b><i class="icon-pencil"></i>&nbsp;<spring:message code="label.add_event"/></b></a>
                </sec:authorize>
            </div>
        </div>
        <div class="container pull-right">
            <div class="navbar-header">
                <div class="navbar-form navbar-right pull-right">
                    <sec:authorize access="isAuthenticated()">
                        <a class="btn btn-warning" href="<c:url value="/j_spring_security_logout"/>"><spring:message code="label.sign_out"/></a>
                    </sec:authorize>
                    <sec:authorize access="isAnonymous()">
                        <a href="signin" class="btn btn-success"><b><spring:message code="label.sign_in"/></b></a>
                        <a href="registration" class="btn btn-primary"><b><spring:message code="label.registration"/></b></a>
                    </sec:authorize>
                    <span >
                        <a href="?lang=en">en</a> | <a href="?lang=ru">ru</a>
                    </span>
                </div>
            </div>
        </div>
    </div>

    <div class="jumbotron">
        <div class="container">
            <h1 class="text-center">Welcome to your scheduler!</h1>
            <p class="text-center">Enjoy!</p>
            <p class="text-center">Date: ${date}</p>
            <p class="text-center">User Name: ${userName}</p>
        </div>
    </div>

    <div class="navbar-fixed-bottom row-fluid">
      <div class="navbar-inner">
        <div class="container">
            <hr>
            <p>Alexander&nbsp;Belkevich Coursework&nbsp;2013 at&nbsp;Itransition&nbsp;Company.</p>
        </div>
      </div>
    </div>

</body>
</html>