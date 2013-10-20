<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="container">

    <div class="row">

        <c:forEach items="${result}" var="event">
            <div class="col-lg-12">
                <h2>
                    <p align="center">${event.title}</p>
                </h2>
                <p>${event.description}</p>
                <p>
                <form action="${pageContext.request.contextPath}/event_page" method="get" class="form-signin">
                    <button type="submit" name="eventTitle" value="${event.title}" class="btn btn-link btn-sm">View
                        event »</button>
                </form>
                </p>
            </div>
        </c:forEach>

    </div>

    <hr>

</div>