<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<div class="container">

    <div class="row">

        <div class="col-lg-12">
            <sec:authorize access="hasAnyRole('ROLE_USER')">

                <c:if test="${!member}">
                    <form action="${pageContext.request.contextPath}/user/event_become_member" method="get"
                        class="form-signin">
                        <button type="submit" name="eventTitle" value="${event.title}" class="btn btn-link btn-sm">Become
                            a member</button>
                    </form>
                </c:if>

                <c:if test="${modify}">
                    <div class="pull-right">
                        <form action="${pageContext.request.contextPath}/user/event_delete" method="get"
                            class="form-signin">
                            <button type="submit" name="eventTitle" value="${event.title}" class="btn btn-link btn-sm">Delete</button>
                        </form>
                        <form action="${pageContext.request.contextPath}/user/event_edit" method="get"
                            class="form-signin">
                            <button type="submit" name="eventTitle" value="${event.title}" class="btn btn-link btn-sm">Edit</button>
                        </form>
                    </div>
                </c:if>
            </sec:authorize>
            <h2>
                <p align="center">Title: ${event.title}</p>
            </h2>
            <hr>
            <p>Date end: ${event.date}</p>
            <hr>
            <p>Event description:</p>
            <p>${event.description}</p>

            <hr>

            <p>Categories:</p>
            <c:forEach items="${event.categories}" var="category">
                <p>${category.name}</p>
            </c:forEach>

            <hr>

            <p>Members:</p>
            <c:forEach items="${event.users}" var="user">
                <p>${user.name}</p>
            </c:forEach>

            <hr>
        </div>

    </div>
</div>