<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="container">

    <div class="row pull" style="width: 30%;">
        <a href="user_account">User data</a>

        <div class="col-md-12" style="margin: 20px 0px 20px;">
            <h2>For Avatar</h2>
            <img src="https://app.divshot.com/img/placeholder-100x100.gif">
        </div>

        <div class="col-md-12" style="margin: 20px 0px 20px;">
            <form:form action="${pageContext.request.contextPath}/user/new_email" method="post" commandName="emailForm"
                class="orm-inline">
                <label class="form-label"><spring:message code="label.new_user_email" />:</label>
                <c:set var="user_email">
                    <spring:message code="label.user_email" />
                </c:set>
                <form:input path="newEmail" type="text" class="form-control" placeholder="${user_email}" />
                <span class="error">
                    <form:errors path="newEmail" />
                </span>
                <button class="btn btn-primary btn-xs" type="submit"><spring:message code="label.submit"/></button>
            </form:form>
        </div>

        <div class="col-md-12" style="margin: 20px 0px 20px;">
            <label class="form-label">New password:</label>
            <form class="form-inline" method="post">
                <input type="text" class="form-control" placeholder="New password"> <input type="text"
                    class="form-control" placeholder="Confirm new password"> <input type="submit" value="submit"
                    class="btn btn-primary btn-xs">
            </form>
        </div>

        <div class="col-md-12" style="margin: 20px 0px 20px;">
            <form class="form-horizontal" method="post">
                <label class="control-label">Select languages:</label> <label class="radio inline"> <input
                    name="language" type="radio" value="ru" checked="true">Rusian
                </label> <label class="radio inline"> <input name="language" type="radio" value="en">English
                </label> <input type="submit" value="submit" class="btn btn-primary btn-xs">
            </form>
        </div>

        <div class="col-md-12">
            <form class="form-horizontal" method="post">
                <label class="control-label">Select style:</label> <label class="radio inline"> <input
                    name="style" type="radio" value="dark" checked="true">Dark
                </label> <label class="radio inline"> <input name="style" type="radio" value="light">Light
                </label> <input type="submit" value="submit" class="btn btn-primary btn-xs">
            </form>
        </div>
        <div class="col-md-12">
            <form method="post">
                <h2>Short Decription:</h2>
                <textarea style="margin: 10px 0px 20px; width: 714px; height: 189px;" maxlength="1000"></textarea>
                <input type="submit" value="submit" class="btn btn-primary btn-xs">
            </form>
        </div>
    </div>
</div>