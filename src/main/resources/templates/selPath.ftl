<#ftl encoding="UTF-8"/>
<#import "/spring.ftl" as spring/>

<#include "header.ftl" />

<div class="container" style="padding: 150px 0px 0px 0px;">
    <div class="row" align="center">
        <div style="background-color: #dddef1; width: 320px; padding: 10px " align="center">
<#if Session.user.role < 5 >
            <div class="row" align="center">
                <div class=" col-sm-12" align="center">
                    <a type="button" class="btn btn-primary btn-lg btn-block" style="width: 300px;  white-space: normal"
                       onclick="window.location = 'reports'">Список отчетов по
                        просмотру фотографий
                    </a>
                </div>
            </div>
</#if>
<#if Session.user.role == 4 >
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
</#if>
<#if Session.user.role == 5 || Session.user.role == 4 >
            <div class="row" align="center">
                <div class=" col-sm-12" align="center">
                    <a type="button" class="btn btn-primary btn-lg btn-block" style="width: 300px; white-space: normal"
                       onclick="window.location = 'select'">
                        Обучение ВТП
                    </a>
                </div>
            </div>
</#if>
        </div>
    </div>
</div>

<#include "footer.ftl" />

<#--
</body>
</html>-->