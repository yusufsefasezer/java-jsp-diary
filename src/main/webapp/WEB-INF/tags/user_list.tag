<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@tag description="userList" pageEncoding="UTF-8"%>

<ul class="collection with-header">
    <li class="collection-header"><h3>User list</h3></li>
        <c:forEach items="${userList}" var="user">
        <a href="profile?user_id=${user.id}" class="collection-item">${user}</a>
    </c:forEach>
</ul>
