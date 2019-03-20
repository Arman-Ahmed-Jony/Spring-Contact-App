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
            <c:if test="${param.action eq 'delete'}">
                <p class="success">The contact delete successfully</p>
            </c:if>
            <div>
                <form action="<s:url value="/user/contact_search" />">
                    <input type="text" value="${param.free_text}" name="free_text" id="myInput" placeholder="Search"/>
                    <input type="submit"/>
                </form>
            </div>
            <div>
                <form action="<s:url value="/user/bulk_delete_contact"/>">
                    <input type="submit" value="Delete selected contacts"/>
                    <table class="table table-bordered" >
                        <thead>
                            <tr>
                                <th><input type="checkbox" class="all_selector"/></th>
                                <th>Name</th>
                                <th>Phone</th>
                                <th>Email</th>
                                <th>Address</th>
                                <th>Remark</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody id="myTable">
                            <c:if test="${empty contactList}">
                                <tr><td colspan="7" class="error">No contact found!!</td></tr>
                            </c:if>

                            <c:forEach var="contact" items="${contactList}" varStatus="vs">
                                <tr>
                                    <td align="center"><input name="contactId" type="checkbox" class="contact_ck" value="${contact.contactId}"></td>
                                    <td>${contact.name}</td>
                                    <td>${contact.phone}</td>
                                    <td>${contact.email}</td>
                                    <td>${contact.address}</td>
                                    <td>${contact.remark}</td>
                                    <td>
                                        <s:url var="url_edit_contact" value="/user/edit_contact">
                                            <s:param name="contactId" value="${contact.contactId}" />
                                        </s:url>
                                        <a href="${url_edit_contact}" type="button" class="btn btn-info" role="button">Edit</a>
                                        <s:url var="url_delete_contact" value="/user/delete_contact" >
                                            <s:param name="contactId" value="${contact.contactId}"/>
                                        </s:url>
                                        <a href="${url_delete_contact}" type="button" class="btn btn-danger" role="button">Delete</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </form>
            </div>

        </div>

        <!-- Footer -->
        <jsp:include page="include/footer.jsp"/>
        <!-- Footer -->


    </body>
    <script>

        //jquery for searching 
        $(document).ready(function () {
            $("#myInput").on("keyup", function () {
                var value = $(this).val().toLowerCase();
                $("#myTable tr").filter(function () {
                    $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
                });
            });
        });
//        //javascript for top checkbox
//        function selectAll() {
//            var items = document.getElementsByName('contact_ck');
//            var selector = document.getElementsById('all_selector')
//            for (var i = 0; i < items.length; i++) {
//                if (selector.checked == true)
//                    items[i].checked = true;
//                else
//                    items[i].checked = false;
//            }
//        }
        //jquery for top checkbox
        var clicked = false;
        $(".all_selector").on("click", function () {
            $(".contact_ck").prop("checked", !clicked);
            clicked = !clicked;
        });


$(document).ready(function(){
   alert('jQuery is running'); 
});

    </script>

</html>
