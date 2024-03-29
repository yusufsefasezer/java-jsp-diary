<%@page pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="t" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@taglib prefix="sql" uri="jakarta.tags.sql" %>
<c:set scope="request" var="pageTitle" value="Just Another Java JSP App..."  />

<c:catch var="error">
    <sql:query dataSource="jdbc/MyDB" var="rs" scope="request">
        SELECT * FROM diary
        INNER JOIN user
        WHERE visibility = 1
        ORDER BY diary_id DESC
    </sql:query>
</c:catch>

<t:layout>
    <div class="row">

        <!-- Content -->
        <div class="col l8 m12">
            <div class="row">
                <t:diary_list />
            </div>
        </div>

        <!-- Sidebar -->
        <aside class="col l4 s12">
            <div class="row">
                <div class="col s12">
                    <div class="card-panel">
                        <t:user_list />
                    </div>
                </div>
            </div>
        </aside>

    </div>
</t:layout>
