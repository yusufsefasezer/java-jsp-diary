<%@page pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="t" %>

<t:layout>
    <div class="row">

        <!-- Content -->
        <div class="col l8 m12">
            <div class="row">
                <t:diary_list />
            </div>
        </div>

        <!-- Sidebar -->
        <aside class="col l4 s12">
            <div class="row">
                <div class="col s12">
                    <div class="card-panel">
                        <t:user_list />
                    </div>
                </div>
            </div>
        </aside>

    </div>
</t:layout>
