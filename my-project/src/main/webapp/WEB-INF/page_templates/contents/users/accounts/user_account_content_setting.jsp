<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="container">

    <div class="row pull" style="width: 30%;">
        <a href="user_account">User data</a>
        <hr>
        <div class="col-md-12" style="margin: 20px 0px 20px;">
            <h2>For Avatar</h2>
            <img src="https://app.divshot.com/img/placeholder-100x100.gif">
        </div>

        <hr>

        <div class="col-md-12" style="margin: 20px 0px 20px;">
            <form:form action="${pageContext.request.contextPath}/user/new_email" method="post" commandName="emailForm"
                class="form-inline">
                <label class="form-label"><spring:message code="label.new_user_email" />:</label>
                <c:set var="user_email">
                    <spring:message code="label.user_email" />
                </c:set>
                <form:input path="newEmail" type="text" class="form-control" placeholder="${user_email}" />
                <button class="btn btn-primary btn-xs" type="submit">
                    <spring:message code="label.submit" />
                </button>
                <span class="error"> <form:errors path="newEmail" />
                </span>
            </form:form>
        </div>

        <hr>

        <div class="col-md-12" style="margin: 20px 0px 20px;">
            <form:form action="${pageContext.request.contextPath}/user/new_password" method="post"
                commandName="passwordForm" class="form-inline">
                <label class="form-label"><spring:message code="label.new_user_password" />:</label>
                <c:set var="new_user_password">
                    <spring:message code="label.registration_password" />
                </c:set>
                <c:set var="new_user_password_confirm">
                    <spring:message code="label.registration_confirm_password" />
                </c:set>
                <form:input path="newPassword" type="password" class="form-control" placeholder="${new_user_password}" />
                <form:input path="newPasswordConfirm" type="password" class="form-control"
                    placeholder="${new_user_password_confirm}" />
                <button class="btn btn-primary btn-xs" type="submit">
                    <spring:message code="label.submit" />
                </button>
                <span class="error"> <form:errors path="newPassword" />
                </span>
                <span class="error"> <form:errors path="newPasswordConfirm" />
                </span>
            </form:form>
        </div>

        <hr>

        <div class="col-md-12" style="margin: 20px 0px 20px;">
            <form  action="${pageContext.request.contextPath}/user/new_language" method="post" class="form-horizontal">
                <label class="control-label"><spring:message code="label.new_user_language" />:</label> 
                <label class="radio inline">
                    <input name="language" type="radio" value="ru" checked="true" ><spring:message code="label.russian_language" />
                </label>
                <label class="radio inline">
                    <input name="language" type="radio" value="en"><spring:message code="label.english_language" />
                </label>
                <input type="submit" value="<spring:message code="label.english_language" />" class="btn btn-primary btn-xs">
            </form>
        </div>

        <hr>

        <div class="col-md-12">
            <form method="post">
                <h2>Short Decription:</h2>
                <textarea style="margin: 10px 0px 20px; width: 714px; height: 189px;" maxlength="1000"></textarea>
                <input type="submit" value="submit" class="btn btn-primary btn-xs">
            </form>
        </div>

        <hr>

    </div>
</div>