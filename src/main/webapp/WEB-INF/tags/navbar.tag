<%@tag description="navbar" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>


<header>
    <nav class="blue darken-3" role="navigation">
        <div class="nav-wrapper container">

            <a href="${pageContext.request.contextPath}" class="brand-logo">JSP APP</a>

            <ul class="right hide-on-med-and-down">
                <li><a href="${pageContext.request.contextPath}"><i class="material-icons right">home</i> Home</a></li>
                    <c:choose>
                        <c:when test="${user ne null}">
                        <li><a href="${pageContext.request.contextPath}/mydiaries"><i class="material-icons right">library_books</i> My Diaries</a></li>
                        <li><a href="${pageContext.request.contextPath}/logout"><i class="material-icons right">exit_to_app</i> Logout</a></li>
                        </c:when>
                        <c:otherwise>
                        <li><a href="${pageContext.request.contextPath}/register"><i class="material-icons right">person_add</i> Register</a></li>
                        <li><a href="${pageContext.request.contextPath}/login"><i class="material-icons right">exit_to_app</i> Login</a></li>
                        </c:otherwise>
                    </c:choose>
            </ul>

            <ul id="nav-mobile" class="sidenav">
                <li class="active"><a href="${pageContext.request.contextPath}"><i class="material-icons left">home</i> Home</a></li>
                    <c:choose>
                        <c:when test="${not empty user}">
                        <li><a href="${pageContext.request.contextPath}/mydiaries"><i class="material-icons left">library_books</i> My Diaries</a></li>
                        <li><a href="${pageContext.request.contextPath}/logout"><i class="material-icons left">exit_to_app</i> Logout</a></li>
                        </c:when>
                        <c:otherwise>
                        <li><a href="${pageContext.request.contextPath}/register"><i class="material-icons left">person_add</i> Register</a></li>
                        <li><a href="${pageContext.request.contextPath}/login"><i class="material-icons left">exit_to_app</i> Login</a></li>
                        </c:otherwise>
                    </c:choose>
            </ul>

            <a href="#" data-target="nav-mobile" class="sidenav-trigger"><i class="material-icons">menu</i></a>
        </div>
    </nav>
</header>
