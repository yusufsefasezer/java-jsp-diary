<%@tag description="userList" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@taglib prefix="sql" uri="jakarta.tags.sql" %>
<%@taglib prefix="fn" uri="jakarta.tags.functions" %>

<c:catch var="error">
    <sql:query dataSource="jdbc/MyDB" var="rs">
        SELECT * FROM user
        ORDER BY user_id ASC
    </sql:query>
</c:catch>

<ul class="collection with-header">
    <li class="collection-header"><h3>User list</h3></li>
        <c:forEach items="${ rs.rows }" var="user">
            <c:set var="firstName" value="${ fn:toUpperCase(user.first_name) }" />
            <c:set var="lastName" value="${ fn:toUpperCase(user.last_name) }" />
        <li class="collection-item"><a href="${ pageContext.request.contextPath }/profile.jsp?user_id=${ user.user_id }">${ firstName } ${ lastName }</a></li>
        </c:forEach>
</ul>
