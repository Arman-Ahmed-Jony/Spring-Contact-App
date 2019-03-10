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
        <title>Contact form</title>
    </head>
    <body>

        <!--Header and Menu-->
        <jsp:include page="include/header.jsp"/>
        <!--Header and Menu-->

        <div class="container-fluid text-center">    

            <div class="login-form">
                <s:url var="url_contact_save" value="/user/save_contact"/>
                <f:form action="${url_contact_save}" modelAttribute="command">
                    <h2 class="text-center">Contact Form</h2>   

                    <c:if test="${err!=null}">
                        <p class="error">${err}</p>
                    </c:if>

                    <div class="form-group">
                        <f:input type="text" path="contact.name" class="form-control" placeholder="Full Name" required="required"/>
                    </div>

                    <div class="form-group">
                        <f:input type="text" path="contact.phone" class="form-control" placeholder="Phone" required="required"/>
                    </div>

                    <div class="form-group">
                        <f:input type="email" path="contact.email" class="form-control" placeholder="Email" required="required"/>
                    </div>

                    <div class="form-group">
                        <f:textarea type="text" path="contact.address" class="form-control" placeholder="Address" required="required"/>
                    </div>


                    <div class="form-group">
                        <f:textarea type="text" path="contact.remark" class="form-control" placeholder="Remark" required="required"/>
                    </div>

                    <div class="form-group">
                        <button type="submit" class="btn btn-primary btn-block">Save</button>
                    </div>

                </f:form>

            </div>
        </div>
        <!-- Footer -->
        <jsp:include page="include/footer.jsp"/>
        <!-- Footer -->
    </body>
</html>
