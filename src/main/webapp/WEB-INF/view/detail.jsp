<%@page pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="t" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<t:layout>
    <article class="row">
        <!-- Content -->
        <div class="col s12">
            <div class="card-panel"><c:out value="${diary.content}" /></div>
        </div>
    </article>
</t:layout>
