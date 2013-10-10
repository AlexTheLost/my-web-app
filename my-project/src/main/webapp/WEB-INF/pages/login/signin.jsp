<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sing in</title>
</head>
<body>
    <h1>Spring Security - Sign In</h1>

    <div style="color: red">${message}</div>

    <form class="login-form" action="j_spring_security_check"
        method="post"
    >
        <label for="j_username">Username: </label> <input
            id="j_username" name="j_username" size="20" maxlength="50"
            type="text"
        /> <label for="j_password">Password: </label> <input
            id="j_password" name="j_password" size="20" maxlength="50"
            type="password"
        /> <input type="submit" value="Login" />
    </form>
</body>
</html>