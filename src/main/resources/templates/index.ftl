<#ftl encoding="UTF-8"/>
<#import "/spring.ftl" as spring/>
<html>
<head>
    <title>Заголовок</title>
    <link type="text/css" href="<@spring.url "/css/style.css" />?${resVer}" rel="stylesheet">
</head>
<body>
<div id="welcomeTitle">Добро пожаловать!</div>
<div class="welcomeButton" onclick="window.location = 'reports'">
    <div class="welButRep">Список отчетов по просмотру фотографий</div>
    <div class="welButClose">(Закрытый раздел)</div>
</div>
<div class="blank"></div>
<div class="welcomeButton" onclick="window.location = 'route'">
    <div class="welButRep">Построение оптимального маршрута</div>
    <div class="welButClose">(Закрытый раздел)</div>
</div>
<div class="blank"></div>
<div class="welcomeButton" onclick="window.location = 'select'">
    <div class="welButRep">Обучение ВТП</div>
    <div class="welButClose">(Закрытый раздел)</div>
</div>
</body>
</html>