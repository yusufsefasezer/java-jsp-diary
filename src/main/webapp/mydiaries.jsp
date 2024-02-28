<%@page pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="t" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@taglib prefix="sql" uri="jakarta.tags.sql" %>
<c:set scope="request" var="pageTitle" value="My diaries"  />
<c:set var="principal" value="<%= request.getUserPrincipal().getName() %>" />

<sql:query dataSource="jdbc/MyDB" var="rs" scope="request">
    SELECT * FROM diary
    INNER JOIN user
    WHERE user.user_name = ?
    <sql:param value="${ principal }" />
</sql:query>

<t:layout>
    <t:message />
    <div class="card-panel">
        <a href="add.jsp" class="waves-effect waves-light btn blue"><i class="material-icons left">add</i>Add New</a>
        <table class="striped">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Date Of Diary</th>
                    <th>Visibility</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <t:diary_list_admin />
            </tbody>
        </table>
    </div>
</t:layout>
