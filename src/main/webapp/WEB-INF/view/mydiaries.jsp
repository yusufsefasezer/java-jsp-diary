<%@page pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="t" %>

<t:layout>
    <div class="card-panel">
        <a href="add" class="waves-effect waves-light btn blue"><i class="material-icons left">add</i>Add New</a>
        <table class="striped">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Date Of Diary</th>
                    <th>Visibility</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <t:diary_list_admin />
            </tbody>
        </table>
    </div>
</t:layout>
