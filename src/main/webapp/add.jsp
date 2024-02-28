<%@page pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="t" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@taglib prefix="sql" uri="jakarta.tags.sql" %>
<%@taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ page import="java.util.Date" %>
<fmt:formatDate value="<%= new Date() %>" pattern="yyyy-MM-dd" var="formattedDate" />
<c:set scope="request" var="pageTitle" value="Add new diary / ${ formattedDate }"  />
<c:set var="principal" value="<%= request.getUserPrincipal().getName() %>" />

<c:if test="${pageContext.request.method eq 'POST'}">
    <c:catch var="error">
        <sql:query dataSource="jdbc/MyDB" var="user">
            SELECT user_id FROM user WHERE user_name = ?
            <sql:param value="${ principal }" />
        </sql:query>
        <sql:update dataSource="jdbc/MyDB" var="rowsAffected">
            INSERT INTO diary VALUES(NULL, ?, now(), ?, ?)
            <sql:param value="${ user.rows[0].user_id }" />
            <sql:param value="${ param.diaryContent }" />
            <sql:param value="${ param.visible eq 'on' ? 1 : 0 }" />
        </sql:update>
    </c:catch>
    <c:choose>
        <c:when test="${rowsAffected > 0}">
            <c:set scope="session" var="message" value="Record successfully added!"  />
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
                        <textarea id="diaryContent" name="diaryContent" class="materialize-textarea grey-text" style="font-size: 2em; font-style: italic;"></textarea>
                    </div>
                </div>

                <!-- Switch -->
                <div class="switch">
                    <label>
                        Hidden
                        <input name="visible" type="checkbox" checked="checked" />
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
