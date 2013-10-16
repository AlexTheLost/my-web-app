<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

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

        </div>
    </div>