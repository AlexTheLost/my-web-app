<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div class="navbar navbar-fixed-top navbar-inverse">
    <div class="container pull-left">
        <div class="navbar-header">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/welcome"><i class="icon-home"></i><b>&nbsp;<spring:message
                        code="label.home" /></b></a>
            <sec:authorize access="hasAnyRole('ROLE_USER')">
                <a href="${pageContext.request.contextPath}/user/user_events" class="navbar-brand" href=""><b><i
                        class="icon-calendar"></i>&nbsp;<spring:message code="label.my_events" /></b></a>
                <a href="${pageContext.request.contextPath}/user/event_create" class="navbar-brand" href=""><b><i
                        class="icon-pencil"></i>&nbsp;<spring:message code="label.add_event" /></b></a>
            </sec:authorize>
            <sec:authorize access="hasAnyRole('ROLE_MANAGER')">
                <a href="${pageContext.request.contextPath}/manager/users_manage" class="navbar-brand" href=""><b><i
                        class="icon-group"></i>&nbsp;user management</b></a>
            </sec:authorize>
        </div>
    </div>
    <div class="container pull-right">
        <div class="navbar-header">
            <div class="navbar-form navbar-right pull-right">

                <div class="form-group btn-sm">
                    <form action="${pageContext.request.contextPath}/search" method="get" class="form-search text-center">
                        <div class="input-append">
                            <input type="search" class="span7 search-query" name="query" autocomplete="off"
                                placeholder="SEARCH" tabindex="1">
                            <button type="submit" class="btn">
                                <i class="icon-search icon-large"></i>
                            </button>
                        </div>
                    </form>
                </div>

                <sec:authorize access="isAuthenticated()">
                    <sec:authentication var="user" property="principal.username" />
                    <div class="form-group btn-sm">
                        <a href="${pageContext.request.contextPath}/user/user_account" class="btn btn-link btn-xs"
                            href=""><b><i class="icon-user icon-1x"></i>&nbsp;${user}</b></a> <a
                            class="btn btn-warning btn-xs" href="<c:url value="/j_spring_security_logout"/>"><spring:message
                                code="label.sign_out" /></a>
                    </div>
                </sec:authorize>
                <sec:authorize access="isAnonymous()">
                    <div class="form-group btn-sm">
                        <a href="signin" class="btn btn-success btn-xs"><b><spring:message code="label.sign_in" /></b></a>
                        <a href="registration" class="btn btn-primary btn-xs"><b><spring:message
                                    code="label.registration" /></b></a>
                    </div>
                </sec:authorize>
                <span> <a href="${pageContext.request.contextPath}/welcome?lang=en">en</a> | <a
                    href="${pageContext.request.contextPath}/welcome?lang=ru">ru</a>
                </span>
            </div>
        </div>
    </div>
</div>

<div class="jumbotron">
    <div class="container"></div>
</div>