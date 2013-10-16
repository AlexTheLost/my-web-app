<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<div class="container">
    <form class="form-signin" action="j_spring_security_check"
        method="post"
    >
        <h2 class="form-signin-heading">
            <spring:message code="label.sign_in_msg" />
        </h2>
        <div>
            <input id="j_username" name="j_username" size="20"
                maxlength="50" type="text" class="form-control"
                placeholder="<spring:message code="label.sign_in_user_name"/>"
            /> <input id="j_password" name="j_password" size="20"
                maxlength="50" type="password" class="form-control"
                placeholder="<spring:message code="label.sign_in_password"/>"
            />
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit"
            value="Login"
        >
            <spring:message code="label.sign_in" />
        </button>
    </form>
</div>