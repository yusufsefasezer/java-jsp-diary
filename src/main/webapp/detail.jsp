<%@page pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="t" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@taglib prefix="sql" uri="jakarta.tags.sql" %>
<c:set scope="request" var="pageTitle" value="Just Another Java JSP App..."  />

<c:catch var="error">
    <sql:query dataSource="jdbc/MyDB" var="rs">
        SELECT * FROM diary
        WHERE
        visibility = 1 AND
        diary_id = ?
        <sql:param value="${param.diary_id}" />
    </sql:query>
</c:catch>

<c:if test="${ error ne null or empty rs.rows }">
    <% response.sendRedirect("index.jsp"); %>
</c:if>

<t:layout>
    <article class="row">
        <!-- Content -->
        <div class="col s12">
            <div class="card-panel"><c:out value="${ rs.rows[0].content }" /></div>
        </div>
    </article>
</t:layout>
