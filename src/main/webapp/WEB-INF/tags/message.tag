<%@tag description="message" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<c:if test="${ not empty message }">
    <div class="card-panel blue white-text"><c:out value="${ message }" /></div>
    <c:remove scope="session" var="message" />
</c:if>
