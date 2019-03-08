<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <!-- Brand/logo -->
    <a class="navbar-brand" href="#">
        <s:url var="url_logo_img" value="/static/images/logo.png"/>
        <img src="${url_logo_img}" alt="logo" style="width:40px;">
    </a>
    <a class="navbar-brand" href="#">A2J Contact</a>
    <!-- Links -->
    <ul class="navbar-nav">
        <jsp:include page="menu.jsp"/>


    </ul>
</nav>
