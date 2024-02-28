<%@taglib tagdir="/WEB-INF/tags/" prefix="t" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<c:set scope="session" var="message" value="Invalid user name and/or password, please try again."  />
<% response.sendRedirect("mydiaries.jsp"); %>
