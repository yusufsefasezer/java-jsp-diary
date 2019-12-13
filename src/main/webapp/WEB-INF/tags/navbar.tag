<%@tag import="com.yusufsezer.model.User"%>
<%@tag description="navbar" pageEncoding="UTF-8"%>
<% User currentUser = (User) request.getSession().getAttribute("user");%>

<header>
    <nav class="blue darken-3" role="navigation">
        <div class="nav-wrapper container">

            <a href="." class="brand-logo">JSP APP</a>

            <ul class="right hide-on-med-and-down">
                <li><a href=".">Home</a></li>
                    <% if (currentUser == null) {%>
                <li><a href="./register">Register</a></li>
                <li><a href="./login">Login</a></li>
                    <% } else { %>
                <li><a href="./mydiaries">My Diaries</a></li>
                <li><a href="./logout">Logout <i class="material-icons right">exit_to_app</i></a></li>
                    <% } %>
            </ul>

            <ul id="nav-mobile" class="sidenav">
                <li class="active"><a href=".">Home</a></li>
                    <% if (currentUser == null) {%>
                <li><a href="./register">Register</a></li>
                <li><a href="./login">Login</a></li>
                    <% } else { %>
                <li><a href="./mydiaries">My Diaries</a></li>
                <li><a href="./logout">Logout <i class="material-icons right">exit_to_app</i></a></li>
                    <% } %>
            </ul>

            <a href="#" data-target="nav-mobile" class="sidenav-trigger"><i class="material-icons">menu</i></a>
        </div>
    </nav>
</header>
