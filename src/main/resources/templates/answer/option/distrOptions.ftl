<#ftl encoding="UTF-8"/>
<#import "/spring.ftl" as spring/>
<option disabled selected data-value="nothing">-- выберите дистрибьютора --</option>
<#list distrList as distr>
    <option data-value="${distr.id?string["0"]}">${distr.name}</option>
</#list>