<%-- 
    Document   : hello
    Created on : Feb 27, 2019, 12:25:17 PM
    Author     : Arman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <title>Contact List</title>
    </head>
    <body>

        <!--Header and Menu-->
        <jsp:include page="include/header.jsp"/>
        <!--Header and Menu-->

        <div class="container-fluid text-center">    

            <h2>Contact List</h2>
            <c:if test="${param.action eq 'save'}">
                <p class="success">The contact saved successfully</p>
            </c:if>
            <div>
                <table class="table table-bordered" >
                    <thead>
                        <tr>
                            <th>Sl#</th>
                            <th>Name</th>
                            <th>Phone</th>
                            <th>Email</th>
                            <th>Address</th>
                            <th>Remark</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:if test="${empty contactList}">
                            <tr><td colspan="7" class="error">No contact found!!</td></tr>
                        </c:if>
                        <c:forEach var="contact" items="${contactList}" varStatus="vs">
                            <tr>
                                <td>${vs.count}</td>
                                <td>${contact.name}</td>
                                <td>${contact.phone}</td>
                                <td>${contact.email}</td>
                                <td>${contact.address}</td>
                                <td>${contact.remark}</td>
                                <td>
                                    <button type="button" class="btn btn-info">Edit</button>
                                    <button type="button" class="btn btn-danger">Delete</button>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>

        </div>

        <!-- Footer -->
        <jsp:include page="include/footer.jsp"/>
        <!-- Footer -->


    </body>
</html>
