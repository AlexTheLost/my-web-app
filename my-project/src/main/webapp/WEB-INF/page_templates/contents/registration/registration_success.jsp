<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
    uri="http://www.springframework.org/security/tags"%>

    <div class="container">
      <h1 class="text-center" style="color: #008000;">Registration Success!</h1>
      <p class="text-center">Congratulate!</p>
      <p><b><i class="icon-user icon-3x"></i>&nbsp;User data:</b></p>
      <p><b><i>name:&nbsp;${userName}&nbsp;<i class="icon-ok icon-large" style="color: #008000;"></i></i></b></p>
      <p><b><i>email:&nbsp;${email}&nbsp;<i class="icon-ok icon-large" style="color: #008000;"></i></i></b></p>
    </div>