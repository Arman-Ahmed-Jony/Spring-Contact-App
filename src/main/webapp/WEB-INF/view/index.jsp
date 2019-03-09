<%-- 
    Document   : hello
    Created on : Feb 27, 2019, 12:25:17 PM
    Author     : Arman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<s:url var="url_logo_img" value="/static/images/logo.png"/>
<s:url var="url_css" value="/static/css/style.css"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="/webjars/bootstrap/4.3.1/css/bootstrap.min.css"
              rel="stylesheet">
        <script src="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <script src="/webjars/jquery/1.9.1/jquery.min.js"></script>
        <link href="${url_css}" rel="stylesheet" type="text/css">
        <title>Login</title>
    </head>
    <body>

        <!--Header and Menu-->
        <jsp:include page="include/header.jsp"/>
        <!--Header and Menu-->

        <div class="container-fluid text-center">    

            <div class="login-form">
                <s:url var="url_login" value="/login"/>
                <f:form action="${url_login}" modelAttribute="command">
                    <h2 class="text-center">User Login</h2>   

                    <c:if test="${err!=null}">
                        <p class="error">${err}</p>
                    </c:if>
                        
                    <c:if test="${param.action eq 'logout'}">
                        <p class="success">Logout Successfully</p>
                    </c:if>
                        
                        
                        

                    <div class="form-group">
                        <f:input type="text" path="loginName" class="form-control" placeholder="Username" required="required"/>
                    </div>

                    <div class="form-group">
                        <f:input type="password" path="password" class="form-control" placeholder="Password" required="required"/>
                    </div>

                    <div class="form-group">
                        <button type="submit" class="btn btn-primary btn-block">Log in</button>
                    </div>

                    <div class="clearfix">
                        <label class="pull-left checkbox-inline"><input type="checkbox">Remember me</label>
                        <a href="#" class="pull-right">Forgot Password?</a>
                    </div> 
                    <p class="text-center"><a href="#">Create an Account</a></p>
                </f:form>

            </div>
        </div>
        <!-- Footer -->
        <jsp:include page="include/footer.jsp"/>
        <!-- Footer -->
    </body>
</html>
