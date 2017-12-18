<#ftl encoding="UTF-8"/>
<#import "/spring.ftl" as spring/>

<option class="non" disabled selected data-value="nothing">-- выберите ВТП --</option>
<#list vtpList as vtp>
    <option  data-value="${vtp.id?string["0"]}">${vtp.fio}</option>
</#list>