<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<div class="container">

    <div class="row">

        <c:forEach items="${titles}" var="title">
            <div class="col-lg-12">
                <p>Title: ${title}</p>
                <form action="${pageContext.request.contextPath}/event_page" method="get" class="form-signin">
                    <button type="submit" name="eventTitle" value="${title}" class="btn btn-link btn-sm">View
                        event »</button>
                </form>
            </div>
            <hr>
        </c:forEach>
    </div>