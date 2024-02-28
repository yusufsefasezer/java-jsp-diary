<%@page pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="t" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@taglib prefix="sql" uri="jakarta.tags.sql" %>

<c:catch var="error">
    <sql:update dataSource="jdbc/MyDB" var="rowsAffected">
        DELETE FROM diary WHERE diary_id = ?
        <sql:param value="${ param.diary_id }" />
    </sql:update>
</c:catch>

<c:choose>
    <c:when test="${rowsAffected > 0}">
        <c:set scope="session" var="message" value="Record successfully deleted!"  />
    </c:when>
    <c:otherwise>
        <c:set scope="session" var="message" value="Something went wrong."  />
    </c:otherwise>
</c:choose>

<% response.sendRedirect("mydiaries.jsp"); %>
