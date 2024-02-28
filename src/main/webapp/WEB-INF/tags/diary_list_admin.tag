<%@tag description="diaryListAdmin" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<c:forEach items="${ rs.rows }" var="diary">
    <tr>
        <td><c:out value="${ diary.diary_id }"/></td>
        <fmt:parseDate value="${ diary.date_of_diary }" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both" />
        <td><fmt:formatDate value="${ parsedDateTime }" dateStyle="FULL" /></td>
        <td><i class="material-icons">${ diary.visibility ? "check" : "remove"}</i></td>
        <td>
            <a href="edit.jsp?diary_id=${ diary.diary_id }" class="btn-floating btn-small waves-effect waves-light green">
                <i class="material-icons">edit</i>
            </a>
            <a href="delete.jsp?diary_id=${ diary.diary_id }" class="btn-floating btn-small waves-effect waves-light red" onclick="return confirm('Are you sure?');">
                <i class="material-icons">delete</i>
            </a>
        </td>
    </tr>
</c:forEach>
