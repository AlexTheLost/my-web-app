<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="container">

    <div class="row">

        <form:form method="post" commandName="registrationForm" class="form-signin">

            <div class="col-md-12" style="margin: 20px 0px 20px;">
                <label class="form-label">Create Event:</label>
            </div>

            <hr>

            <div class="col-md-12" style="margin: 20px 0px 20px;">
                <label class="form-label">Title:</label>
                
                <form:input path="" type="text" class="form-control" style="width: 300px;" />
                <span class="error"> 
                    <form:errors path="userName" />
                </span>
            </div>

            <hr>

            <div class="col-md-12" style="margin: 20px 0px 20px;">
                <label class="form-label">Date:</label>
                <div id="datetimepicker" class="input-append date">
                    <form:input path=""  data-format="yyyy-MM-dd" type="text" readonly />
                    <span class="add-on"> <i
                        data-time-icon="icon-time" data-date-icon="icon-calendar"></i>
                    </span>
                    <span class="error"> 
                        <form:errors path="userName" />
                    </span>
                </div>
            </div>

            <hr>

            <div class="col-md-12" style="margin: 20px 0px 20px;">
                <label class="form-label">Description:</label>
                <form:textarea path="" class="form-control clearfix" style="margin-top: 0px; margin-bottom: 0px; height: 260px;"
                    maxlength="2000" />
                <span class="error"> 
                    <form:errors path="userName" />
                </span>
            </div>

        </form:form>

    </div>

</div>

<script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script type="text/javascript" src="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/js/bootstrap.min.js"></script>
<script type="text/javascript"
    src="http://tarruda.github.com/bootstrap-datetimepicker/assets/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript"
    src="http://tarruda.github.com/bootstrap-datetimepicker/assets/js/bootstrap-datetimepicker.pt-BR.js"></script>
<script type="text/javascript">
    $('#datetimepicker').datetimepicker({
        pickTime : false
    });
</script>