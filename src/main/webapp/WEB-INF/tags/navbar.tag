<%@tag description="navbar" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="principal" value="<%= request.getUserPrincipal() %>" />

<header>
    <nav class="blue darken-3" role="navigation">
        <div class="nav-wrapper container">

            <a href="." class="brand-logo">JSP APP</a>

            <ul class="right hide-on-med-and-down">
                <li><a href="."><i class="material-icons right">home</i> Home</a></li>
                <li><a href="./mydiaries.jsp"><i class="material-icons right">library_books</i> My Diaries</a></li>
                    <c:choose>
                        <c:when test="${ principal ne null }">
                        <li><a href="./logout.jsp"><i class="material-icons right">exit_to_app</i> Logout</a></li>
                        </c:when>
                        <c:otherwise>
                        <li><a href="./register.jsp"><i class="material-icons right">person_add</i> Register</a></li>
                        </c:otherwise>
                    </c:choose>
            </ul>

            <ul id="nav-mobile" class="sidenav">
                <li class="active"><a href="."><i class="material-icons left">home</i> Home</a></li>
                <li><a href="./mydiaries.jsp"><i class="material-icons left">library_books</i> My Diaries</a></li>
                    <c:choose>
                        <c:when test="${ not empty principal }">
                        <li><a href="./logout.jsp"><i class="material-icons left">exit_to_app</i> Logout</a></li>
                        </c:when>
                        <c:otherwise>
                        <li><a href="./register.jsp"><i class="material-icons left">person_add</i> Register</a></li>
                        </c:otherwise>
                    </c:choose>
            </ul>

            <a href="#" data-target="nav-mobile" class="sidenav-trigger"><i class="material-icons">menu</i></a>
        </div>
    </nav>
</header>
