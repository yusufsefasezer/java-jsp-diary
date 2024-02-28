<%@page pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="t" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@taglib prefix="sql" uri="jakarta.tags.sql" %>

<sql:query dataSource="jdbc/MyDB" var="rs" scope="request">
    SELECT * FROM diary
    WHERE visibility = 1 AND
    user_id = ?
    <sql:param value="${param.user_id}" />
</sql:query>

<c:if test="${ error ne null or empty rs.rows }">
    <% response.sendRedirect("index.jsp"); %>
</c:if>

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
