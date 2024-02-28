<%@page pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="t" %>

<% request.logout(); %>
<% response.sendRedirect("index.jsp"); %>
