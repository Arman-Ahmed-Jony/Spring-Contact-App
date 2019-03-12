<%-- 
    Document   : hello
    Created on : Feb 27, 2019, 12:25:17 PM
    Author     : Arman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<s:url var="url_logo_img" value="/static/images/logo.png"/>
<s:url var="url_css" value="/static/css/style.css"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" type="image/gif" href="/static/images/logo.png">
        <link href="/webjars/bootstrap/4.3.1/css/bootstrap.min.css"
              rel="stylesheet">
        <script src="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <script src="/webjars/jquery/1.9.1/jquery.min.js"></script>
        <link href="${url_css}" rel="stylesheet" type="text/css">
        <title>User Dashboard</title>
    </head>
    <body>

        <!--Header and Menu-->
        <jsp:include page="include/header.jsp"/>
        <!--Header and Menu-->

        <div class="container-fluid text-center">    

            <h2>this is User dashboard</h2>

        </div>

        <!-- Footer -->
        <jsp:include page="include/footer.jsp"/>
        <!-- Footer -->


    </body>
</html>
