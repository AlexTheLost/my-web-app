<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<div class="container">

    <div class="row">

        <c:forEach items="${users}" var="user">
            <div class="col-lg-12">
                <p>User name: ${user.name}</p>
                <p>User role: <c:out value="${user.role}" /></p>
                
                <sec:authorize access="hasAnyRole('ROLE_MANAGER')">
                    <form action="${pageContext.request.contextPath}/manager/delete_user" method="get"
                        class="form-signin">
                        <button type="submit" name="userName" value="${user.name}" class="btn btn-link btn-sm">Delete
                            user »</button>
                    </form>
                </sec:authorize>

                <sec:authorize access="hasAnyRole('ROLE_ADMINISTRATOR')">
                    <form action="${pageContext.request.contextPath}/admin/change_role" method="get"
                        class="form-signin">
                        <select name="role">
                            <option value="user" >User</option>
                            <option value="manager" >Manager</option>
                        </select>
                        <button type="submit" name="userName" value="${user.name}" class="btn btn-link btn-sm">Change
                            role »</button>
                    </form>
                </sec:authorize>

            </div>
            <hr>
        </c:forEach>
    </div>