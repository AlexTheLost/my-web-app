<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="container">
    <form class="form-signin">
        <h1
            style="color: #E32636; font-family: 'Times New Roman'; line-height: normal;"
            class="text-center"
        >
            <spring:message code="label.sign_in_fail_msg" />
            &nbsp;
        </h1>
        <p align="center">
            <i style="color: #E32636;" class="icon-frown icon-4x"></i>
        </p>
    </form>
</div>