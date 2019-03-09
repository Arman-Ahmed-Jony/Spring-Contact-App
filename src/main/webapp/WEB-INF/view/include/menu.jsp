<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

<s:url var="url_logout" value="/logout"/>

<c:if test="${sessionScope.userId==null}">
    <%--user is not logged in: guest menu --%>
    <li class="nav-item">
        <a class="nav-link" href="#">Home</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="#">Login</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="#">Register</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="#">About</a>
    </li>
</c:if>

<c:if test="${sessionScope.userId!=null && sessionScope.role==1}">
    <%--admin is logged in: admin menu --%>
    <li class="nav-item">
        <a class="nav-link" href="#">Home</a>
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
        <a class="nav-link" href="#">Home</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="#">Add Contact</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="#">Contact List</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="${url_logout}">Logout</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="#">About</a>
    </li>
</c:if>
