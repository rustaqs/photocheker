<#ftl encoding="UTF-8"/>
<#import "/spring.ftl" as spring/>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <script language="javascript" type="text/javascript" src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Photocheker</title>
    <link type="text/css" href="<@spring.url "/css/style.css" />?${resVer}" rel="stylesheet">
</head>
<body>
<div class="container" id="login_block">
    <div class="row" align="center" style="width: 320px">
        <div class="login_title col-sm-4" style="margin: 5px">Пожалуйста, авторизуйтесь!</div>
    </div>
    <form action="/selPath" id="login_form" method="post">
        <div class=" col-sm-12" align="center" >
            <input type="text" class=" form-control" name="login_login" placeholder="Логин" style="width: 250px;">
        </div>
        <div class=" col-sm-12" align="center" style="margin-top: 10px">
            <input type="password" class=" form-control" name="login_password" placeholder="Пароль" style="width: 250px;">
        </div>
        <div class=" col-sm-12" align="center" style="margin-top: 10px; margin-bottom: 10px">
            <input type="submit" value="Войти" class="btn btn-primary btn-lg btn-block"
                   style="width: 250px;  white-space: normal">
        </div>
    </form>
    <script>
        var str = window.location.search.replace('?', '');
        if (str != "") {
            $('#login_form').after("<div class='errorInfo col-sm-12'>Пользователя с таким логином или паролем не существует!</div>")
        }
    </script>
    <div class="information col-sm-6 col-sm-12">Если у Вас еще нет логина и пароля, обратитесь к своему
        непосредственному руководителю.
    </div>
</div>
</body>
</html>