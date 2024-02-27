<%@tag description="userList" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<ul class="collection with-header">
    <li class="collection-header"><h3>User list</h3></li>
        <c:forEach items="${userList}" var="user">
        <li class="collection-item"><a href="${pageContext.request.contextPath}/profile?user_id=${user.id}">${user}</a></li>
        </c:forEach>
</ul>
