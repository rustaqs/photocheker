<#ftl encoding="UTF-8"/>
<#import "/spring.ftl" as spring/>

<#include "header.ftl" />

<div class="report_title">Назначение ответственных верификаторов</div>
<div id="resp_container">
    <div class="resp_title">
        <div class="resp type_name">Вид отчета</div>
        <div class="resp region_name">Регион</div>
        <div class="resp distr_name">Дистрибьютор</div>
        <div class="resp resp_name">Ответственный</div>
    </div>
    <div id="resp_editor_pane">
        <#list respList as respItem>
            <div class="responsib">
                <div class="resp type_name" name="${respItem.reportType.id?string["0"]}">${respItem.reportType.name}</div>
                <div class="resp region_name" name="${respItem.distr.region.id?string["0"]}">${respItem.distr.region.name}</div>
                <div class="resp distr_name" name="${respItem.distr.id?string["0"]}">${respItem.distr.name}</div>
                <select class="resp resp_name">
                    <option name="0"></option>
                    <#assign repId = respItem.reportType.id?string/>
                    <#list respUsers?keys as key>
                        <#if key == repId>
                            <#list respUsers[key] as userItem>
                                <option name="${userItem.id}" <#if ((respItem.user.id)!0) == userItem.id> selected="selected" </#if>>
                                    ${userItem.userName}
                                </option>
                            </#list>
                        </#if>
                    </#list>
                </select>
            </div>
        </#list>
    </div>
    <div class="button button_save" id="resp_save">Сохранить изменения</div>
    <div class="button button_cancel" id="resp_cancel">Отменить изменения</div>
</div>

<#include "footer.ftl"/>