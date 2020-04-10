<%@tag description="layout" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="t" %>
<!DOCTYPE html>
<html lang="en">

    <t:head />

    <body class="blue lighten-4">

        <t:navbar />

        <div class="section no-pad-bot">
            <div class="container">
                <h1 class="header center">${pageTitle}</h1>
            </div>
        </div>

        <main class="container">
            <jsp:doBody />
        </main>

        <!--  Scripts-->
        <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
        <script>
            $(function () {
                $('.sidenav').sidenav();
            });
        </script>

    </body>

</html>
