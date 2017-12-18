<#ftl encoding="UTF-8"/>
<#import "/spring.ftl" as spring/>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>${pageTitle}</title>

    <link type="text/css" href="<@spring.url "/css/style.css"/>?${resVer}" rel="stylesheet">
    <#if pageCategory == 'lka'>
        <link type="text/css" href="<@spring.url "/css/lkaStyle.css"/>?${resVer}" rel="stylesheet">
    </#if>
        <#if pageCategory == 'select'>
        <link type="text/css" href="<@spring.url "/css/answe.css"/>?${resVer}" rel="stylesheet">
        </#if>
    <#if pageCategory == 'mlka'>
        <link type="text/css" href="<@spring.url "/css/mlkaStyle.css"/>?${resVer}" rel="stylesheet">
    </#if>
    <#if pageCategory == 'lkaDmp'>
        <link type="text/css" href="<@spring.url "/css/lkaDmpStyle.css"/>?${resVer}" rel="stylesheet">
    </#if>
    <#if pageCategory == 'administrate'>
        <link type="text/css" href="<@spring.url "/css/administrateStyle.css"/>?${resVer}" rel="stylesheet">
    </#if>
    <#if pageCategory == 'lkaMa'>
        <link type="text/css" href="<@spring.url "/css/lkaMaStyle.css"/>?${resVer}" rel="stylesheet">
    </#if>
    <#if pageCategory == 'nst'>
        <link type="text/css" href="<@spring.url "/css/nstStyle.css"/>?${resVer}" rel="stylesheet">
    </#if>
    <#if pageCategory == 'nka'>
        <link type="text/css" href="<@spring.url "/css/nkaStyle.css"/>?${resVer}" rel="stylesheet">
    </#if>
    <#if pageCategory == 'nkaParam'>
        <link type="text/css" href="<@spring.url "/css/nkaParamStyle.css"/>?${resVer}" rel="stylesheet">
    </#if>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <#if pageCategory == 'select' >
    <script src="<@spring.url "/js/phone_book.js"/>?${resVer}" type="text/javascript"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="<@spring.url "/js/main.js"/>?${resVer}" type="text/javascript"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.4/css/bootstrap-select.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.4/js/bootstrap-select.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.4/js/i18n/defaults-ru_RU.min.js"></script>
    </#if>

    <#if pageCategory == 'lka'>
        <script src="<@spring.url "/js/lka.js"/>?${resVer}" type="text/javascript"></script>
    </#if>
    <#if pageCategory == 'mlka'>
        <script src="<@spring.url "/js/mlka.js"/>?${resVer}" type="text/javascript"></script>
    </#if>
    <#if pageCategory == 'lkaDmp'>
        <script src="<@spring.url "/js/lkaDmp.js"/>?${resVer}" type="text/javascript"></script>
    </#if>
    <#if pageCategory == 'reports'>
        <script src="<@spring.url "/js/reports.js"/>?${resVer}" type="text/javascript"></script>
    </#if>
    <#if pageCategory == 'administrate'>
        <script src="<@spring.url "/js/administrate.js"/>?${resVer}" type="text/javascript"></script>
    </#if>
    <#if pageCategory == 'lkaMa'>
        <script src="<@spring.url "/js/lkaMa.js"/>?${resVer}" type="text/javascript"></script>
    </#if>
    <#if pageCategory == 'nst'>
        <script src="<@spring.url "/js/nst.js"/>?${resVer}" type="text/javascript"></script>
    </#if>
    <#if pageCategory == 'nka' || pageCategory == 'nkaParam'>
        <script src="<@spring.url "/js/nka.js"/>?${resVer}" type="text/javascript"></script>
    </#if>
</head>
<body>
<div id="errorBlock">Произошла ошибка! Невозможно подключиться к серверу. Попробуйте позднее!</div>
<div id="savedSuccessfullyBlock">Данные успешно сохранены!</div>
<div id="head_pane">
    <div class="row">
        <div class="col-md-1" align="left">
            <div class="report_title">
                <a href="/" style="border: 0;">Главная</a>
                <a class="rep" href="/reports" style="border: 0;">Отчеты</a>
            </div>
        </div>
        <div>
            <div id="filter_pane">
                <div id="logoff_pane">
                    <span id="lbl_user_name">${Session.user.userName}<input type="button" id="exit" value="Выход"
                                                                            onclick="window.location = '/logoff';"><br>
                    </span>
                </div>
            </div>
        </div>
    </div>
</div>
<div id="loader">
    <img src="<@spring.url "/images/wheel.gif"/>">
    <span style="margin-left:10px;">Загрузка...</span>
</div>
<div id="top_separate"></div>