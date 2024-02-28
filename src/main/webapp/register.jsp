<%@page pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="t" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@taglib prefix="sql" uri="jakarta.tags.sql" %>

<c:if test="${ pageContext.request.method eq 'POST' }">
    <c:choose>
        <c:when test="${  empty param.first_name or empty param.last_name or empty param.user_name or empty param.password }">
            <c:set scope="request" var="message" value="Please fill all field"  />
        </c:when>
        <c:otherwise>
            <c:catch var="error">
                <sql:transaction dataSource="jdbc/MyDB">
                    <sql:update var="rowsAffected">
                        INSERT INTO user VALUES (NULL, ?, ?, ?, ?);
                        <sql:param value="${ param.first_name }" />
                        <sql:param value="${ param.last_name }" />
                        <sql:param value="${ param.user_name }" />
                        <sql:param value="${ param.password }" />
                    </sql:update>
                    <sql:update>
                        INSERT INTO user_roles  VALUES (?, 'USER');
                        <sql:param value="${ param.user_name }" />
                    </sql:update>
                </sql:transaction>
            </c:catch>
            <c:choose>
                <c:when test="${ rowsAffected > 0 }">
                    <c:set scope="request" var="message" value="User successfully added!"  />
                    <% response.sendRedirect("mydiaries.jsp"); %>
                </c:when>
                <c:otherwise>
                    <c:set scope="request" var="message" value="Something went wrong."  />
                </c:otherwise>
            </c:choose>
        </c:otherwise>
    </c:choose>
</c:if>

<t:layout>
    <div class="card-panel">
        <div class="row">
            <t:message />
            <form class="col l6 s12 offset-l3" method="POST">
                <div class="row">
                    <div class="input-field col s6">
                        <input name="first_name" id="first_name" type="text" class="validate" required="required" />
                        <label for="first_name">First Name</label>
                    </div>
                    <div class="input-field col s6">
                        <input name="last_name" id="last_name" type="text" class="validate" />
                        <label for="last_name">Last Name</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s12">
                        <input name="user_name" id="email" type="email" class="validate" required="required" />
                        <label for="email">Email</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s12">
                        <input name="password" id="password" type="password" class="validate" required="required" />
                        <label for="password">Password</label>
                    </div>
                </div>

                <button class="btn waves-effect waves-light right grey" type="submit">Submit
                    <i class="material-icons right">send</i>
                </button>
            </form>
        </div>
    </div>
</t:layout>
