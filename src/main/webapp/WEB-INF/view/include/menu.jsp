<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>


<s:url var="url_logout" value="/logout"/>


<c:if test="${sessionScope.userId==null}">
    <%--user is not logged in: guest menu --%>

    <li class="nav-item">
        <s:url var="url_home" value="/index"/>
        <a class="nav-link" href="${url_home}">Home</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="${url_home}">Login</a>
    </li>
    <li class="nav-item">
        <s:url var="url_reg_form" value="/registration_form"/>
        <a class="nav-link" href="${url_reg_form}">Register</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="#">About</a>
    </li>
</c:if>

<c:if test="${sessionScope.userId!=null && sessionScope.role==1}">
    <%--admin is logged in: admin menu --%>
    <li class="nav-item">
        <a class="nav-link" href="${url_home}">Home</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="#">User List</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="${url_logout}">Logout</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="#">About</a>
    </li>
</c:if>

<c:if test="${sessionScope.userId!=null && sessionScope.role==2}">
    <%--General user is logged in: user menu --%>
    <li class="nav-item">
        <s:url var="user_contact_home" value="/user/dashboard"/>
        <a class="nav-link" href="${user_contact_home}">Home</a>
    </li>
    <li class="nav-item">
        <s:url var="url_contact_form" value="/user/contact_form"/>
        <a class="nav-link" href="${url_contact_form}">Add Contact</a>
    </li>
    <li class="nav-item">
        <s:url var="url_contact_list" value="/user/contact_list"/>
        <a class="nav-link" href="${url_contact_list}">Contact List</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="${url_logout}">Logout</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="#">About</a>
    </li>
</c:if>
