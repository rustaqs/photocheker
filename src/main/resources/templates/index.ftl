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
<div class="container" style="padding: 150px 0px 0px 0px;">
    <div class="row" align="center">
        <div style="background-color: #dddef1; width: 320px; padding: 10px " align="center">
            <div class="row" align="center">
                <div class=" col-sm-12" align="center">
                    <a type="button" class="btn btn-primary btn-lg btn-block" style="width: 300px;  white-space: normal"
                       onclick="window.location = 'reports'">Список отчетов по
                        просмотру фотографий
                    </a>
                </div>
            </div>
            <p></p>
            <div class="row" align="center">
                <div class=" col-sm-12" align="center">
                    <a type="button" class="btn btn-primary btn-lg btn-block" style="width: 300px;  white-space: normal"
                       onclick="window.location = 'route'">
                        Построение оптимального маршрута
                    </a>
                </div>
            </div>
            <p></p>
            <div class="row" align="center">
                <div class=" col-sm-12" align="center">
                    <a type="button" class="btn btn-primary btn-lg btn-block" style="width: 300px; white-space: normal"
                       onclick="window.location = 'select'">
                        Обучение ВТП
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>