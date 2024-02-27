<%@tag description="diaryListAdmin" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<c:forEach items="${diaryList}" var="diary">
    <tr>
        <td><c:out value="${diary.id}"/></td>
        <td><fmt:formatDate value="${diary.dateOfDiary}" dateStyle="FULL" /></td>
        <td><i class="material-icons">${diary.visibility?"check":"remove"}</i></td>
        <td>
            <a href="edit?diary_id=${diary.id}" class="btn-floating btn-small waves-effect waves-light green">
                <i class="material-icons">edit</i>
            </a>
            <a href="delete?diary_id=${diary.id}" class="btn-floating btn-small waves-effect waves-light red" onclick="return confirm('Are you sure?');">
                <i class="material-icons">delete</i>
            </a>
        </td>
    </tr>
</c:forEach>
