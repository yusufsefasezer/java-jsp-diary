<%@page pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="t" %>

<t:layout>
    <article class="row">
        <!-- Content -->
        <div class="col s12">
            <div class="card-panel">${diary.getContent()}</div>
        </div>
    </article>
</t:layout>
