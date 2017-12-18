<#ftl encoding="UTF-8"/>
<#import "/spring.ftl" as spring/>
<#include "../header.ftl">
<#if Session.user.role==4>
 <div class="container">
     <br>
     <div class="text-center lead">
         <img class="img-rounded" src="/images/Banner.png" alt="Responsive image">
     </div>
     <br>
 </div>
<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
    <div class="panel panel-primary">
        <div class="panel-heading" role="tab" id="headingOne">
            <h4 class="panel-title">
                <a class="selV1" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapse1"
                   aria-expanded="true"
                   aria-controls="collapse1">
                    Выбор ВТП
                </a>
                <a class="timeS"></a>
            </h4>
        </div>
        <div id="collapse1" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="heading1">
            <div class="panel-body">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12" align="center">
                            <select class="selRegion selectpicker" id="selRegion" style="width: 90%">
                                <option disabled selected data-value="nothing">-- выберите регион --</option>
                                    <#list regionList as region>
                                        <option data-value="${region.id?string["0"]}">${region.name}</option>
                                    </#list>
                            </select>
                        </div>
                    </div>
                    <p></p>
                    <div class="row">
                        <div class="col-md-12" align="center">
                            <select class="selDistr selectpicker" id="selDistr" style="width: 90%">
                                <option disabled selected data-value="nothing">-- выберите дистрибьютора --</option>
                            </select>
                        </div>
                    </div>
                    <p></p>
                    <div class="row">
                        <div class="col-md-12" align="center">
                            <select class="selVtp selectpicker" id="selVtp" style="width: 90%">
                                <option disabled selected data-value="nothing">-- выберите ВТП --</option>
                            </select>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12" align="center">
                            <h6>Результаты последнего обучения</h6>
                        </div>
                    </div>
                    <div class="jumbotron">
                        <div class="col-md-12 grade" align="center">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="panel panel-primary answVtp">
    </div>
    <div class="panel panel-primary endVtp" style="display: none;">
        <div class="panel-heading" role="tab" id="headingOne">
            <h4 class="panel-title">
                <a class="endVt" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapse3"
                   aria-expanded="true"
                   aria-controls="collapse3">
                    Подведение итогов за день
                </a>
            </h4>
        </div>
        <div id="collapse3" class="panel-collapse collapse in" role="tabpane1" aria-labelledby="heading3">
            <div class="panel-body">
                <div class="container">
                    <div class="row" align="center">
                        <h4>Завершение обучения <a class="zvHr" href="#zvHr">*</a></h4>
                    </div>
                    <div class="row">
                        <ol>
                            <table class="table" width="200px">
                                <tr>
                                    <td class="occ2">
                                        <li class="ques">Деятельность конкурентов</li>
                                    </td>
                                    <td class="answ2">
                                        <select>
                                            <option class="non" disabled selected data-value="nothing"></option>
                                            <option value="1">1</option>
                                            <option value="2">2</option>
                                            <option value="3">3</option>
                                            <option value="4">4</option>
                                            <option value="5">5</option>
                                        </select>
                                    </td>
                                </tr>
                            </table>
                        </ol>
                        <ol>
                            <table class="table">
                                <tr>
                                    <td class="occ2">
                                        <li class="ques">Условия работы с ТТ</li>
                                    </td>
                                    <td class="answ2">
                                        <select>
                                            <option class="non" disabled selected data-value="nothing"></option>
                                            <option value="1">1</option>
                                            <option value="2">2</option>
                                            <option value="3">3</option>
                                            <option value="4">4</option>
                                            <option value="5">5</option>
                                        </select>
                                    </td>
                                </tr>
                            </table>
                        </ol>
                        <ol>
                            <table class="table">
                                <tr>
                                    <td class="occ2">
                                        <li class="ques">Цели на день, знание акций</li>
                                    </td>
                                    <td class="answ2">
                                        <select>
                                            <option class="non" disabled selected data-value="nothing"></option>
                                            <option value="1">1</option>
                                            <option value="2">2</option>
                                            <option value="3">3</option>
                                            <option value="4">4</option>
                                            <option value="5">5</option>
                                        </select>
                                    </td>
                                </tr>
                            </table>
                        </ol>
                        <ol>
                            <table class="table">
                                <tr>
                                    <td class="occ2">
                                        <li class="ques">Правила ведения фин. документации</li>
                                    </td>
                                    <td class="answ2">
                                        <select>
                                            <option class="non" disabled selected data-value="nothing"></option>
                                            <option value="1">1</option>
                                            <option value="2">2</option>
                                            <option value="3">3</option>
                                            <option value="4">4</option>
                                            <option value="5">5</option>
                                        </select>
                                    </td>
                                </tr>
                            </table>
                        </ol>
                        <ol>
                            <table class="table">
                                <tr>
                                    <td class="occ2">
                                        <li class="ques">Знание 100% ТТ территории</li>
                                    </td>
                                    <td class="answ2">
                                        <select>
                                            <option class="non" disabled selected data-value="nothing"></option>
                                            <option value="1">1</option>
                                            <option value="2">2</option>
                                            <option value="3">3</option>
                                            <option value="4">4</option>
                                            <option value="5">5</option>
                                        </select>
                                    </td>
                                </tr>
                            </table>
                        </ol>
                    </div>
                    <div class="zvzd">
                        <div class="col-md-12">
                            <a class="zvHr" name="zvHr">*</a> - Оценки по 5-ти бальной шкале:1- Очевидно слабо;2- Хуже,
                            чем должно быть;3- Отвечает ожиданиям;4- Очевидно хорошо;5-
                            Явно сильные стороны
                        </div>
                    </div>
                    <div>
                        <div class="row occ2">
                            <h5 class="ques">
                                Комментарий о работе за день:</h5>
                            <div class="col-md-12 ">
                                <textarea class="inputComm answ2" style="width: 100%"></textarea>
                            </div>
                        </div>
                        <div class="row occ2">
                            <h5 class="ques">
                                Темы/цели и планы для самостоятельного развития:
                            </h5>
                            <div class="col-md-12 answ2">
                                <select class="selectpicker form-control tem" multiple data-max-options="2">
                                    <optgroup label="Знание документов">
                                        <option>История(1-2 вопрса)</option>
                                        <option>Миссия, Видение и Ценности</option>дщ
                                        <option>Стандарты работы ТП</option>
                                    </optgroup>
                                    <optgroup label="Продукция, свойства и преимущества">
                                        <option>Продукция, свойства и преимущества</option>
                                    </optgroup>
                                    <optgroup label="Управление территорией">
                                        <option>Корректность базы данных</option>
                                        <option>Оборудование, контроль состояния</option>
                                    </optgroup>
                                    <optgroup label="Готовность к работе">
                                        <option>Наличие документов, инструментов</option>
                                        <option>Наличие необходимых POSM, хранение</option>
                                        <option>Опрятный внешний вид, чистая машина</option>
                                    </optgroup>
                                    <optgroup label="Подготовка визита">
                                        <option>Постоновка цели S.M.A.R.T</option>
                                        <option>Планирование вопросов</option>
                                        <option>Готовность к возможным возражениям</option>
                                    </optgroup>
                                    <optgroup label="Открытие">
                                        <option>Использование этапов/правил представления</option>
                                        <option>Снятие срочных вопросов</option>
                                        <option>Создание позитивной атмосферы</option>
                                    </optgroup>
                                    <optgroup label="Осмотр торговой точки">
                                        <option>Снятие остатков, заполнение полок</option>
                                        <option>Анализ товарного запаса/ситуации</option>
                                        <option>Расчёт товарного запаса(формирование заявки)</option>
                                        <option>Коррекция цели/плана презентации</option>
                                    </optgroup>
                                    <optgroup label="Анализ нужд">
                                        <option>Работа с вопросами</option>
                                        <option>Вопросы функционально структурированы</option>
                                        <option>Активное слушание</option>
                                        <option>Обобщение в пользу своего предложения</option>
                                    </optgroup>
                                    <optgroup label="Презентация">
                                        <option>С П В</option>
                                        <option>Использование наглядных материалов</option>
                                        <option>Подготовлено заранее, лаконично</option>
                                    </optgroup>
                                    <optgroup label="Работа с возражениями">
                                        <option>Согласие с клиентом</option>
                                        <option>Техники и способы работы с возражениями</option>
                                        <option>Поиск альтернативных вариантов</option>
                                    </optgroup>
                                    <optgroup label="Закрытие сделки">
                                        <option>Сигналы о покупке</option>
                                        <option>Подходящая форма закрытия сделки</option>
                                        <option>Суммирование договоренностей</option>
                                    </optgroup>
                                    <optgroup label="Работа с ценой">
                                        <option>Знает рекоменодванные цены, устанавливает их</option>
                                    </optgroup>
                                    <optgroup label="Работа с промо">
                                        <option>Знает акции, предлагает их</option>
                                    </optgroup>
                                    <optgroup label="Работа с продуктом">
                                        <option>Заказ составляется по стандарту(приор. лист., SCU за SCU)</option>
                                    </optgroup>
                                    <optgroup label="Мерчендайзинг">
                                        <option>Знание и использование</option>
                                    </optgroup>
                                    <optgroup label="Администрирование">
                                        <option>Корректность информации</option>
                                        <option>Заполнение необходимой документации</option>
                                    </optgroup>
                                    <optgroup label="Анализ визита">
                                        <option>Анализ визита / S.M.A.R.T</option>
                                        <option>Определение причин удачи/неудачи</option>
                                        <option>Цели на следующий визит в эту ТТ</option>
                                    </optgroup>
                                    <optgroup label="Завершение обучения">
                                        <option>Деятельность конкурентов</option>
                                        <option>Условия работы с ТТ</option>
                                        <option>Цели на день, знание акций</option>
                                        <option>Правила ведения фин. документации</option>
                                        <option>Знание 100% ТТ территории</option>
                                    </optgroup>
                                </select>
                            </div>
                        </div>
                        <div class="row occ2">
                            <h5 class="ques">
                                Темы следующего обучения:
                            </h5>
                            <div class="col-md-12 answ2">
                                <select class="selectpicker form-control tem" multiple data-max-options="2">
                                    <optgroup label="Знание документов">
                                        <option>История(1-2 вопрса)</option>
                                        <option>Миссия, Видение и Ценности</option>
                                        <option>Стандарты работы ТП</option>
                                    </optgroup>
                                    <optgroup label="Продукция, свойства и преимущества">
                                        <option>Продукция, свойства и преимущества</option>
                                    </optgroup>
                                    <optgroup label="Управление территорией">
                                        <option>Корректность базы данных</option>
                                        <option>Оборудование, контроль состояния</option>
                                    </optgroup>
                                    <optgroup label="Готовность к работе">
                                        <option>Наличие документов, инструментов</option>
                                        <option>Наличие необходимых POSM, хранение</option>
                                        <option>Опрятный внешний вид, чистая машина</option>
                                    </optgroup>
                                    <optgroup label="Подготовка визита">
                                        <option>Постоновка цели S.M.A.R.T</option>
                                        <option>Планирование вопросов</option>
                                        <option>Готовность к возможным возражениям</option>
                                    </optgroup>
                                    <optgroup label="Открытие">
                                        <option>Использование этапов/правил представления</option>
                                        <option>Снятие срочных вопросов</option>
                                        <option>Создание позитивной атмосферы</option>
                                    </optgroup>
                                    <optgroup label="Осмотр торговой точки">
                                        <option>Снятие остатков, заполнение полок</option>
                                        <option>Анализ товарного запаса/ситуации</option>
                                        <option>Расчёт товарного запаса(формирование заявки)</option>
                                        <option>Коррекция цели/плана презентации</option>
                                    </optgroup>
                                    <optgroup label="Анализ нужд">
                                        <option>Работа с вопросами</option>
                                        <option>Вопросы функционально структурированы</option>
                                        <option>Активное слушание</option>
                                        <option>Обобщение в пользу своего предложения</option>
                                    </optgroup>
                                    <optgroup label="Презентация">
                                        <option>С П В</option>
                                        <option>Использование наглядных материалов</option>
                                        <option>Подготовлено заранее, лаконично</option>
                                    </optgroup>
                                    <optgroup label="Работа с возражениями">
                                        <option>Согласие с клиентом</option>
                                        <option>Техники и способы работы с возражениями</option>
                                        <option>Поиск альтернативных вариантов</option>
                                    </optgroup>
                                    <optgroup label="Закрытие сделки">
                                        <option>Сигналы о покупке</option>
                                        <option>Подходящая форма закрытия сделки</option>
                                        <option>Суммирование договоренностей</option>
                                    </optgroup>
                                    <optgroup label="Работа с ценой">
                                        <option>Знает рекоменодванные цены, устанавливает их</option>
                                    </optgroup>
                                    <optgroup label="Работа с промо">
                                        <option>Знает акции, предлагает их</option>
                                    </optgroup>
                                    <optgroup label="Работа с продуктом">
                                        <option>Заказ составляется по стандарту(приор. лист., SCU за SCU)</option>
                                    </optgroup>
                                    <optgroup label="Мерчендайзинг">
                                        <option>Знание и использование</option>
                                    </optgroup>
                                    <optgroup label="Администрирование">
                                        <option>Корректность информации</option>
                                        <option>Заполнение необходимой документации</option>
                                    </optgroup>
                                    <optgroup label="Анализ визита">
                                        <option>Анализ визита / S.M.A.R.T</option>
                                        <option>Определение причин удачи/неудачи</option>
                                        <option>Цели на следующий визит в эту ТТ</option>
                                    </optgroup>
                                    <optgroup label="Завершение обучения">
                                        <option>Деятельность конкурентов</option>
                                        <option>Условия работы с ТТ</option>
                                        <option>Цели на день, знание акций</option>
                                        <option>Правила ведения фин. документации</option>
                                        <option>Знание 100% ТТ территории</option>
                                    </optgroup>
                                </select>
                            </div>
                        </div>
                    </div>
                    <p></p>
                    <div align="center" style="margin: 20px 20px 20px 20px">
                        <button type="button" class="btn btn-primary btn-block" onclick="saved(2)" style="width: 250px">
                            Завершить обучение
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<#else>
<h4>Недостаточно прав, вернитесь на главную</h4>
</#if>
<#include "../footer.ftl">


