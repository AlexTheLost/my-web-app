<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

    <div class="container">
      <form:form method="post" commandName="registrationForm" class="form-signin">
        <h2 class="form-signin-heading text-center"><spring:message code="label.registration"/></h2>
        
        <c:set var="registration_user_name">
            <spring:message code="label.registration_user_name"/>
        </c:set>
        <form:input path="userName" type="text" class="form-control" placeholder="${registration_user_name}" />
        <span class="error">
            <form:errors path="userName" />
        </span>
        
        <c:set var="registration_email_addr">
            <spring:message code="label.registration_email_addr"/>
        </c:set>
        <form:input path="email" type="email" class="form-control" placeholder="${registration_email_addr}"/>   
        <span class="error">
            <form:errors path="email" />
        </span>
        
        <c:set var="registration_password">
            <spring:message code="label.registration_password"/>
        </c:set>
        <form:input path="password" type="password" class="form-control" placeholder="${registration_password}"/>
        <span class="error">
            <form:errors path="password" />
        </span>
        
        <c:set var="registration_confirm_password">
            <spring:message code="label.registration_confirm_password"/>
        </c:set>
        <form:input path="confirmPassword" type="password" class="form-control" placeholder="${registration_confirm_password}"/>
        <span class="error">
            <form:errors path="confirmPassword" />
        </span>

        <button class="btn btn-lg btn-primary btn-block" type="submit"><spring:message code="label.registration_submit"/></button>
      </form:form>
    </div>