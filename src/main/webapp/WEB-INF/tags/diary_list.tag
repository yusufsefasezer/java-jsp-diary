<%@tag description="diaryList" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@taglib prefix="sql" uri="jakarta.tags.sql" %>
<%@taglib prefix="fn" uri="jakarta.tags.functions" %>
<%@taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<c:choose>
    <c:when test="${ not empty rs.rows }">
        <c:forEach items="${ rs.rows }" var="diary">
            <div class="col s12">
                <div class="card">
                    <div class="card-content">
                        <fmt:parseDate value="${ diary.date_of_diary }" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both" />
                        <a href="detail.jsp?diary_id=${ diary.diary_id }"><fmt:formatDate value="${ parsedDateTime }" dateStyle="FULL" /></a>
                        <p class="flow-text"><c:out value="${ diary.content }" /></p>
                    </div>
                    <div class="card-action">
                        <c:set var="firstName" value="${ fn:toUpperCase(diary.first_name) }" />
                        <c:set var="lastName" value="${ fn:toUpperCase(diary.last_name) }" />
                        <a href="profile.jsp?user_id=${ diary.user_id }">${ firstName } ${ lastName }</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </c:when>
    <c:otherwise>
        No record found!
    </c:otherwise>
</c:choose>
