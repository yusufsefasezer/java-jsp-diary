<%@page pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="t" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@taglib prefix="sql" uri="jakarta.tags.sql" %>
<%@taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<c:catch var="error">
    <sql:query dataSource="jdbc/MyDB" var="rs" scope="request">
        SELECT * FROM diary
        WHERE diary_id = ?
        <sql:param value="${ param.diary_id }" />
    </sql:query>
</c:catch>

<c:if test="${ error ne null or empty rs.rows }">
    <% response.sendRedirect("mydiaries.jsp"); %>
</c:if>

<c:set var="diary" value="${rs.rows[0]}" />
<fmt:parseDate value="${ diary.date_of_diary }" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both" />
<fmt:formatDate value="${ parsedDateTime }" pattern="yyyy-MM-dd" var="formattedDate" />
<c:set scope="request" var="pageTitle" value="Edit diary / ${ formattedDate }"  />

<c:if test="${ pageContext.request.method eq 'POST' }">
    <c:catch var="error">
        <sql:update dataSource="jdbc/MyDB" var="rowsAffected">
            UPDATE diary SET
            content = ?,
            visibility = ?
            WHERE diary_id = ?
            <sql:param value="${ param.diaryContent }" />
            <sql:param value="${ param.visible eq 'on' ? 1 : 0 }" />
            <sql:param value="${ diary.diary_id }" />
        </sql:update>
    </c:catch>
    <c:choose>
        <c:when test="${rowsAffected > 0}">
            <c:set scope="session" var="message" value="Record successfully updated!"  />
        </c:when>
        <c:otherwise>
            <c:set scope="request" var="message" value="Something went wrong."  />
        </c:otherwise>
    </c:choose>
</c:if>

<t:layout>
    <!-- Content -->
    <div class="card-panel">
        <div class="row">
            <t:message />
            <form class="col s12" method="POST">

                <!-- Content -->
                <div class="row">
                    <div class="input-field col s12">
                        <textarea id="diaryContent" name="diaryContent" class="materialize-textarea grey-text" style="font-size: 2em; font-style: italic;"><c:out value="${ diary.content }"/></textarea>
                    </div>
                </div>

                <!-- Switch -->
                <div class="switch">
                    <label>
                        Hidden
                        <input name="visible" type="checkbox" <c:if test="${ diary.visibility }">checked</c:if> />
                            <span class="lever"></span> Visible
                        </label>
                    </div>

                    <br />

                    <button class="btn waves-effect waves-light grey" type="submit" name="action">Submit
                        <i class="material-icons right">send</i>
                    </button>

                </form>
            </div>

        </div>
</t:layout>
