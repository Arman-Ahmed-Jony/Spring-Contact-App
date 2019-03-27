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
        <link rel="icon" type="image/gif" href="/static/images/logo.png">
        <link href="/webjars/bootstrap/4.3.1/css/bootstrap.min.css"
              rel="stylesheet">
        <script src="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <script src="/webjars/jquery/3.3.1/jquery.min.js"></script>
        <link href="${url_css}" rel="stylesheet" type="text/css">
        <title>Registration</title>
    </head>
    <body>

        <!--Header and Menu-->
        <jsp:include page="include/header.jsp"/>
        <!--Header and Menu-->

        <div class="container-fluid text-center">    

            <div class="login-form">
                <s:url var="url_reg" value="/register"/>
                <f:form action="${url_reg}" modelAttribute="command">
                    <h2 class="text-center">User Registration</h2>   

                    <c:if test="${err!=null}">
                        <p class="error">${err}</p>
                    </c:if>

                    <div class="form-group">
                        <f:input type="text" path="user.name" class="form-control" placeholder="Full Name" required="required"/>
                    </div>

                    <div class="form-group">
                        <f:input type="text" path="user.phone" class="form-control" placeholder="Phone" required="required"/>
                    </div>

                    <div class="form-group">
                        <f:input type="email" path="user.email" class="form-control" placeholder="Email" required="required"/>
                    </div>

                    <div class="form-group">
                        <f:textarea type="text" path="user.address" class="form-control" placeholder="Address" required="required"/>
                    </div>

                    <div class="form-group">
                        <f:input type="text" id="id_loginname" path="user.loginName" class="form-control" placeholder="Username" required="required"/>
                        <!--                        <button type="button" id="id_check_avail" onclick="">Check Availability</button>-->
                        <p class="error" id="avail_status"></p>
                        <script>
                            $(document).ready(function () {
                                $("#id_loginname").on("keyup", function () {
                                    $.ajax({
                                        url: "check_avail",
                                        data: {loginName: $("#id_loginname").val()},
                                        success: function (data) {
                                            $("#avail_status").html(data)
                                        }
                                    })
                                });
                            });
                        </script>
                    </div>

                    <div class="form-group">
                        <f:input type="password" path="user.password" class="form-control" placeholder="Password" required="required"/>
                    </div>

                    <div class="form-group">
                        <button type="submit" class="btn btn-primary btn-block">Register</button>
                    </div>

                </f:form>

            </div>
        </div>
        <!-- Footer -->
        <jsp:include page="include/footer.jsp"/>
        <!-- Footer -->
    </body>

</html>
