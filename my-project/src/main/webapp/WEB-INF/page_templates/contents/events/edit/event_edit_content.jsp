<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="container">

    <div class="row">

        <form:form action="${pageContext.request.contextPath}/user/event_edit" method="post" commandName="eventEditForm"
            class="form-signin">
            
            <div class="col-md-12" style="margin: 20px 0px 20px;">
                <label class="form-label"><spring:message code="label.event.edit_event" />: ${eventTitle}</label> <input
                    type="text" name="eventTitle" value="${eventTitle}" hidden="true" />
            </div>

            <hr>

            <div class="col-md-12" style="margin: 20px 0px 20px;">
                <label class="form-label"><spring:message code="label.event.title" />:</label>
                <form:input path="title" type="text" class="form-control" style="width: 300px;" />
                <span class="error"> <form:errors path="title" />
                </span>
            </div>

            <hr>

            <div class="col-md-12" style="margin: 20px 0px 20px;">
                <label class="form-label"><spring:message code="label.event.date" />:</label>
                <div id="datetimepicker" class="input-append date">
                    <form:input path="date" data-format="yyyy-MM-dd" type="text" readonly="true" />
                    <span class="add-on"> <i data-time-icon="icon-time" data-date-icon="icon-calendar"></i>
                    </span> <span class="error"> <form:errors path="date" />
                    </span>
                </div>
            </div>

            <hr>

            <div class="col-md-12" style="margin: 20px 0px 20px;">
                <label class="form-label"><spring:message code="label.event.description" />:</label>
                <form:textarea path="description" class="form-control clearfix"
                    style="margin-top: 0px; margin-bottom: 0px; height: 260px;" maxlength="2000" />
                <span class="error"> <form:errors path="description" />
                </span>
            </div>

            <div class="col-md-12" style="margin: 20px 0px 20px;">
                <label class="form-label"><spring:message code="label.event.categories" />:</label>
                <div class="col-md-12" style="margin: 20px 0px 20px;">
                    <span class="error"> <form:errors path="categories" />
                    </span>
                    <c:forEach items="${allCategories}" var="category">
                        <div class="checkbox">
                            <label> <form:checkbox path="categories" value="${category.name}" /> <spring:message
                                    code="label.category.${category.name}" />
                            </label>
                        </div>
                    </c:forEach>
                </div>
            </div>

            <div class="col-md-12" style="margin: 20px 0px 20px;">
                <button class="btn btn-primary btn-xs" type="submit">
                    <spring:message code="label.submit" />
                </button>
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