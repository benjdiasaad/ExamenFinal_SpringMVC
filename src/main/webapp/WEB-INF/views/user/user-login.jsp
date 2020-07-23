<%--
  Created by IntelliJ IDEA.
  User: TOSHIBA
  Date: 26/04/2020
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
    <title>Login</title>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-6 offset-3 ">
            <div class="card" style="margin-top: 100px">
                <div class="card-header">Login</div>
                <form:form action="${pageContext.request.contextPath}/login" cssClass="form-horizontal" method="post" modelAttribute="user">
                    <div class="card-body row">
                        <div class="form-group col-sm-12 required">
                            <label>Email</label>
                            <form:input path="email"  type="text" name="email" value="abdeslam.rehaimi@gmail.com" class="form-control "></form:input>
                            <form:errors path="email"  class="invalid-feedback"  cssStyle="color: red" />
                        </div>

                        <div class="form-group col-md-12 required">
                            <label>Mot de pass</label>
                            <form:input path="password" type="password" value="123456789" name="password" autocomplete="off" class="form-control "></form:input>
                            <form:errors path="password"  class="invalid-feedback"  cssStyle="color: red" />
                        </div>


                        <div class="form-group col-md-12">
                            <form:button class="btn btn-primary btn-block">Login</form:button>
                        </div>
                    </div>
                </form:form>
                <!--
                <div class="text-center " style="text-align: center!important;">
                    <a class=" d-block small mt-3" href="${pageContext.request.contextPath}/register">Register an Account</a>
                </div>
                -->
            </div>
        </div>
    </div>
</div>



</body>
</html>
