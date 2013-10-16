<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>

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