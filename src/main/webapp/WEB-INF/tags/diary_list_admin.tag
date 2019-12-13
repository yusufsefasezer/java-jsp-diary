<%@tag import="java.util.List"%>
<%@tag import="com.yusufsezer.model.Diary"%>
<%@tag description="diaryListAdmin" pageEncoding="UTF-8"%>

<% List<Diary> diaryList = (List) request.getAttribute("diaryList"); %>

<% for (Diary diary : diaryList) {%>
<tr>
    <td><%=diary.getId()%></td>
    <td><%=diary.getDateOfDiary()%></td>
    <td><i class="material-icons"><%=diary.isVisibility() ? "check" : "remove"%></i></td>
    <td>
        <a href="edit?diary_id=<%=diary.getId()%>" class="btn-floating btn-small waves-effect waves-light green">
            <i class="material-icons">edit</i>
        </a>
        <a href="delete?diary_id=<%=diary.getId()%>" class="btn-floating btn-small waves-effect waves-light red" onclick="return confirm('Are you sure?');">
            <i class="material-icons">delete</i>
        </a>
    </td>
</tr>
<% } %>
