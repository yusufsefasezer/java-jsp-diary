<%@tag description="message" pageEncoding="UTF-8"%>

<% Object message = request.getAttribute("message");
    if (message != null) { %>
<div class="card-panel red white-text">${message}</div>
<% }%>
