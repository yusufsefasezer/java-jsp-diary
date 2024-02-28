<%@page pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="t" %>

<t:layout>
    <div class="card-panel">
        <div class="row">
            <t:message />
            <form class="col l6 s12 offset-l3" method="POST" action="j_security_check">
                <div class="row">
                    <div class="input-field col s12">
                        <input name="j_username" id="email" type="email" class="validate" required="required" />
                        <label for="email">Email</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s12">
                        <input name="j_password" id="password" type="password" class="validate" required="required" />
                        <label for="password">Password</label>
                    </div>
                </div>
                <button class="btn waves-effect waves-light right grey" type="submit">Log In
                    <i class="material-icons right">send</i>
                </button>
            </form>
        </div>
    </div>
</t:layout>
