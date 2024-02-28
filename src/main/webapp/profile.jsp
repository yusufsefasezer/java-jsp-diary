<%@page pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="t" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@taglib prefix="sql" uri="jakarta.tags.sql" %>

<sql:query dataSource="jdbc/MyDB" var="rs" scope="request">
    SELECT * FROM diary
    INNER JOIN user
    WHERE visibility = 1 AND
    user.user_id = ?
    <sql:param value="${param.user_id}" />
</sql:query>

<c:if test="${ error ne null or empty rs.rows }">
    <% response.sendRedirect("index.jsp"); %>
</c:if>

<c:set var="firstName" value="${ rs.rows[0].first_name }" />
<c:set var="lastName" value="${ rs.rows[0].last_name }" />
<c:set scope="request" var="pageTitle" value="${ firstName } ${ lastName }" />

<t:layout>
    <div class="section">

        <!-- Content -->
        <div class="row">

            <!-- Content -->
            <div class="col s12">
                <div class="row">
                    <t:diary_list />
                </div>
            </div>
        </div>

    </div>

</t:layout>
