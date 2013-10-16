<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

    <div class="container">
        <form class="form-signin" action="j_spring_security_check"
            method="post">
            <h2 class="form-signin-heading">Please sign in</h2>
            <div>
                <input id="j_username" name="j_username" size="20" maxlength="50" 
                    type="text" class="form-control" placeholder="User name"/>
                <input id="j_password" name="j_password" size="20" maxlength="50"
                    type="password" class="form-control" placeholder="Password" />
            </div>
            <button class="btn btn-lg btn-primary btn-block" type="submit" value="Login">
                Sign in
            </button>
        </form>
    </div>