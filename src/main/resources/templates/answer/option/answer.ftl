<#ftl encoding="UTF-8"/>
<#import "/spring.ftl" as spring/>
<div class="panel-heading" role="tab" id="headingTwo">
    <h4 class="panel-title">
        <a name="top" class="collapsed selV2" role="button" data-toggle="collapse" data-parent="#accordion"
           href="#collapse2"
           aria-expanded="false" aria-controls="collapse2">
            Оценка работы ВТП: ${vizN}
        </a>
    </h4>
</div>
<div id="collapse2" class="panel-collapse" role="tabpane1" aria-labelledby="heading2" ">
    <div class="panel-body">
        <div class="container">
            <div class="row" style="margin: 0px 0px 10px 0px">
                <div class="col-md-12">
                    <h3 class="vizNum">Визит №:${id}</h3>
                </div>
                <div class="col-md-12">
                    <h4>Темы обучения:</h4>
                </div>
            </div>
            <div class="row ">
                <div class="col-md-8 tema">${tema}</div>
            </div>
            <br/>
            <div class="col-md-12" id="vizitNum">
            </div>
            <div class="zvzd podgot">
                <div class="col-md-12"><a>
                    Оценки по 5-ти бальной шкале:1- Очевидно слабо;2- Хуже, чем должно быть;3- Отвечает ожиданиям;4-
                    Очевидно хорошо;5- Явно сильные стороны</a>
                </div>
            </div>
            <#if id==1>
            <div class="row podgot" align="center">
                <h4>Подготовка к рабочему дню</h4>
            </div>
            <div class="row podgot">
                <form id="1">
                    <ol>
                        <table class="table" width="200px">
                            <h4 class="tyQ">1.Знание документов</h4>
                            <tr>
                                <td class="occ">
                                    <li>История(1-2 вопрса)</li>
                                </td>
                                <td class="answ">
                                    <select>
                                        <option disabled selected data-value="nothing"></option>
                                        <option value="1">1</option>
                                        <option value="2">2</option>
                                        <option value="3">3</option>
                                        <option value="4">4</option>
                                        <option value="5">5</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td class="occ">
                                    <li>Миссия, Видение и Ценности</li>
                                </td>
                                <td class="answ">
                                    <select>
                                        <option disabled selected data-value="nothing"></option>
                                        <option value="1">1</option>
                                        <option value="2">2</option>
                                        <option value="3">3</option>
                                        <option value="4">4</option>
                                        <option value="5">5</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td class="occ">
                                    <li class="question">Стандарты работы ТП</li>
                                </td>
                                <td class="answ">
                                    <select>
                                        <option disabled selected data-value="nothing"></option>
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
                            <h4 class="tyQ">2.Продукция, свойства и преимущества</h4>
                            <tr>
                                <td class="occ">
                                    <li>Продукция, свойства и преимущества</li>
                                </td>
                                <td class="answ">
                                    <select>
                                        <option disabled selected data-value="nothing"></option>
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
                            <h4 class="tyQ">3.Управление территорией</h4>
                            <tr>
                                <td class="occ">
                                    <li>Корректность базы данных</li>
                                </td>
                                <td class="answ">
                                    <select>
                                        <option disabled selected data-value="nothing"></option>
                                        <option value="1">1</option>
                                        <option value="2">2</option>
                                        <option value="3">3</option>
                                        <option value="4">4</option>
                                        <option value="5">5</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td class="occ">
                                    <li>Оборудование, контроль состояния</li>
                                </td>
                                <td class="answ">
                                    <select>
                                        <option disabled selected data-value="nothing"></option>
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
                            <h4 class="tyQ">4.Готовность к работе</h4>
                            <tr>
                                <td class="occ">
                                    <li>Наличие документов, инструментов</li>
                                </td>
                                <td class="answ">
                                    <select>
                                        <option disabled selected data-value="nothing"></option>
                                        <option value="1">1</option>
                                        <option value="2">2</option>
                                        <option value="3">3</option>
                                        <option value="4">4</option>
                                        <option value="5">5</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td class="occ">
                                    <li>Наличие необходимых POSM, хранение</li>
                                </td>
                                <td class="answ">
                                    <select>
                                        <option disabled selected data-value="nothing"></option>
                                        <option value="1">1</option>
                                        <option value="2">2</option>
                                        <option value="3">3</option>
                                        <option value="4">4</option>
                                        <option value="5">5</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td class="occ">
                                    <li>Опрятный внешний вид, чистая машина</li>
                                </td>
                                <td class="answ">
                                    <select>
                                        <option disabled selected data-value="nothing"></option>
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
                </form>
            </div>
            </#if>
            <div class="row" align="center">
                <div class="zvzd">
                    <div class="col-md-12">
                        <a>
                            Оценки: "+" применяет, "-" не применяет, "0" - не было необходимости
                        </a>
                    </div>
                </div>
                <h4>Этапы визита</h4>
                <h5>
                    Перед визитом
                </h5>
            </div>
            <form id="2">
                <div class="row">
                    <ol>
                        <table class="table" width="200px">
                            <h4 class="tyQ">1.Подготовка визита</h4>
                            <tr>
                                <td class="occ">
                                    <li>Постоновка цели S.M.A.R.T</li>
                                </td>
                                <td class="answ">
                                    <select>
                                        <option disabled selected data-value="nothing"></option>
                                        <option value="-">-</option>
                                        <option value="+">+</option>

                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td class="occ">
                                    <li>Планирование вопросов</li>
                                </td>
                                <td class="answ">
                                    <select>
                                        <option disabled selected data-value="nothing"></option>
                                        <option value="-">-</option>
                                        <option value="+">+</option>

                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td class="occ">
                                    <li>Готовность к возможным возражениям</li>
                                </td>
                                <td class="answ">
                                    <select>
                                        <option disabled selected data-value="nothing"></option>
                                        <option value="-">-</option>
                                        <option value="+">+</option>

                                    </select>
                                </td>
                            </tr>
                        </table>
                    </ol>
                </div>
                <div class="row" align="center">
                    <h5>
                        Во время визита
                    </h5>
                </div>
                <div class="row">
                    <ol>
                        <table class="table" width="200px">
                            <h4 class="tyQ">2.Открытие</h4>
                            <tr>
                                <td class="occ">
                                    <li>Использование этапов/правил представления</li>
                                </td>
                                <td class="answ">
                                    <select>
                                        <option disabled selected data-value="nothing"></option>
                                        <option value="-">-</option>
                                        <option value="+">+</option>

                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td class="occ">
                                    <li>Снятие срочных вопросов</li>
                                </td>
                                <td class="answ">
                                    <select>
                                        <option disabled selected data-value="nothing"></option>
                                        <option value="-">-</option>
                                        <option value="+">+</option>

                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td class="occ">
                                    <li>Создание позитивной атмосферы</li>
                                </td>
                                <td class="answ">
                                    <select>
                                        <option disabled selected data-value="nothing"></option>
                                        <option value="-">-</option>
                                        <option value="+">+</option>

                                    </select>
                                </td>
                            </tr>
                        </table>
                    </ol>
                    <ol>
                        <table class="table" width="200px">
                            <h4 class="tyQ">3.Осмотр торговой точки</h4>
                            <tr>
                                <td class="occ">
                                    <li>Снятие остатков, заполнение полок</li>
                                </td>
                                <td class="answ">
                                    <select>
                                        <option disabled selected data-value="nothing"></option>
                                        <option value="-">-</option>
                                        <option value="+">+</option>

                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td class="occ">
                                    <li>Анализ товарного запаса/ситуации</li>
                                </td>
                                <td class="answ">
                                    <select>
                                        <option disabled selected data-value="nothing"></option>
                                        <option value="-">-</option>
                                        <option value="+">+</option>

                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td class="occ">
                                    <li>Расчёт товарного запаса(формирование заявки)</li>
                                </td>
                                <td class="answ">
                                    <select>
                                        <option disabled selected data-value="nothing"></option>
                                        <option value="-">-</option>
                                        <option value="+">+</option>

                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td class="occ">
                                    <li>Коррекция цели/плана презентации</li>
                                </td>
                                <td class="answ">
                                    <select>
                                        <option disabled selected data-value="nothing"></option>
                                        <option value="-">-</option>
                                        <option value="+">+</option>

                                    </select>
                                </td>
                            </tr>
                        </table>
                    </ol>
                    <ol>
                        <table class="table" width="200px">
                            <h4 class="tyQ">4.Анализ нужд</h4>
                            <tr>
                                <td class="occ">
                                    <li>Работа с вопросами</li>
                                </td>
                                <td class="answ">
                                    <select>
                                        <option disabled selected data-value="nothing"></option>
                                        <option value="0">0</option>
                                        <option value="+">+</option>
                                        <option value="-">-</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td class="occ">
                                    <li>Вопросы функционально структурированы</li>
                                </td>
                                <td class="answ">
                                    <select>
                                        <option disabled selected data-value="nothing"></option>
                                        <option value="0">0</option>
                                        <option value="+">+</option>
                                        <option value="-">-</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td class="occ">
                                    <li>Активное слушание</li>
                                </td>
                                <td class="answ">
                                    <select>
                                        <option disabled selected data-value="nothing"></option>
                                        <option value="0">0</option>
                                        <option value="+">+</option>
                                        <option value="-">-</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td class="occ">
                                    <li>Обобщение в пользу своего предложения</li>
                                </td>
                                <td class="answ">
                                    <select>
                                        <option disabled selected data-value="nothing"></option>
                                        <option value="0">0</option>
                                        <option value="+">+</option>
                                        <option value="-">-</option>
                                    </select>
                                </td>
                            </tr>
                        </table>
                    </ol>
                    <ol>
                        <table class="table" width="200px">
                            <h4 class="tyQ">5.Презентация</h4>
                            <tr>
                                <td class="occ">
                                    <li>С П В</li>
                                </td>
                                <td class="answ">
                                    <select>
                                        <option disabled selected data-value="nothing"></option>
                                        <option value="0">0</option>
                                        <option value="+">+</option>
                                        <option value="-">-</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td class="occ">
                                    <li>Использование наглядных материалов</li>
                                </td>
                                <td class="answ">
                                    <select>
                                        <option disabled selected data-value="nothing"></option>
                                        <option value="0">0</option>
                                        <option value="+">+</option>
                                        <option value="-">-</option>
                                    </select>
                                </td>
                            </tr>
                        </table>
                    </ol>
                    <ol>
                        <table class="table" width="200px">
                            <h4 class="tyQ">6.Предложение</h4>
                            <tr>
                                <td class="occ">
                                    <li>Подготовлено заранее, лаконично</li>
                                </td>
                                <td class="answ">
                                    <select>
                                        <option disabled selected data-value="nothing"></option>
                                        <option value="0">0</option>
                                        <option value="+">+</option>
                                        <option value="-">-</option>
                                    </select>
                                </td>
                            </tr>
                        </table>
                    </ol>
                    <ol>
                        <table class="table" width="200px">
                            <h4 class="tyQ">7.Работа с возражениями</h4>
                            <tr>
                                <td class="occ">
                                    <li>Согласие с клиентом</li>
                                </td>
                                <td class="answ">
                                    <select>
                                        <option disabled selected data-value="nothing"></option>
                                        <option value="0">0</option>
                                        <option value="+">+</option>
                                        <option value="-">-</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td class="occ">
                                    <li>Техники и способы работы с возражениями</li>
                                </td>
                                <td class="answ">
                                    <select>
                                        <option disabled selected data-value="nothing"></option>
                                        <option value="0">0</option>
                                        <option value="+">+</option>
                                        <option value="-">-</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td class="occ">
                                    <li>Поиск альтернативных вариантов</li>
                                </td>
                                <td class="answ">
                                    <select>
                                        <option disabled selected data-value="nothing"></option>
                                        <option value="0">0</option>
                                        <option value="+">+</option>
                                        <option value="-">-</option>
                                    </select>
                                </td>
                            </tr>
                        </table>
                    </ol>
                    <ol>
                        <table class="table" width="200px">
                            <h4 class="tyQ">8.Закрытие сделки</h4>
                            <tr>
                                <td class="occ">
                                    <li>Сигналы о покупке</li>
                                </td>
                                <td class="answ">
                                    <select>
                                        <option disabled selected data-value="nothing"></option>
                                        <option value="0">0</option>
                                        <option value="+">+</option>
                                        <option value="-">-</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td class="occ">
                                    <li>Подходящая форма закрытия сделки</li>
                                </td>
                                <td class="answ">
                                    <select>
                                        <option disabled selected data-value="nothing"></option>
                                        <option value="0">0</option>
                                        <option value="+">+</option>
                                        <option value="-">-</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td class="occ">
                                    <li>Суммирование договоренностей</li>
                                </td>
                                <td class="answ">
                                    <select>
                                        <option disabled selected data-value="nothing"></option>
                                        <option value="0">0</option>
                                        <option value="+">+</option>
                                        <option value="-">-</option>
                                    </select>
                                </td>
                            </tr>
                        </table>
                    </ol>
                    <ol>
                        <table class="table" width="200px">
                            <h4 class="tyQ">9.Работа с ценой</h4>
                            <tr>
                                <td class="occ">
                                    <li>Знает рекоменодванные цены, устанавливает их</li>
                                </td>
                                <td class="answ">
                                    <select>
                                        <option disabled selected data-value="nothing"></option>
                                        <option value="0">0</option>
                                        <option value="+">+</option>
                                        <option value="-">-</option>
                                    </select>
                                </td>
                            </tr>
                        </table>
                    </ol>
                    <ol>
                        <table class="table" width="200px">
                            <h4 class="tyQ">10.Работа с промо</h4>
                            <tr>
                                <td class="occ">
                                    <li>Знает акции, предлагает их</li>
                                </td>
                                <td class="answ">
                                    <select>
                                        <option disabled selected data-value="nothing"></option>
                                        <option value="0">0</option>
                                        <option value="+">+</option>
                                        <option value="-">-</option>
                                    </select>
                                </td>
                            </tr>
                        </table>
                    </ol>
                    <ol>
                        <table class="table" width="200px">
                            <h4 class="tyQ">11.Работа с продуктом</h4>
                            <tr>
                                <td class="occ">
                                    <li>Заказ составляется по стандарту(приор. лист., SCU за SCU)</li>
                                </td>
                                <td class="answ">
                                    <select>
                                        <option disabled selected data-value="nothing"></option>
                                        <option value="0">0</option>
                                        <option value="+">+</option>
                                        <option value="-">-</option>
                                    </select>
                                </td>
                            </tr>
                        </table>
                    </ol>
                    <ol>
                        <table class="table" width="200px">
                            <h4 class="tyQ">12.Мерчендайзинг</h4>
                            <tr>
                                <td class="occ">
                                    <li>Знание и использование</li>
                                </td>
                                <td class="answ">
                                    <select>
                                        <option disabled selected data-value="nothing"></option>
                                        <option value="0">0</option>
                                        <option value="+">+</option>
                                        <option value="-">-</option>
                                    </select>
                                </td>
                            </tr>
                        </table>
                    </ol>
                    <ol>
                        <table class="table" width="200px">
                            <h4 class="tyQ">13.Администрирование</h4>
                            <tr>
                                <td class="occ">
                                    <li>Корректность информации</li>
                                </td>
                                <td class="answ">
                                    <select>
                                        <option disabled selected data-value="nothing"></option>
                                        <option value="0">0</option>
                                        <option value="+">+</option>
                                        <option value="-">-</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td class="occ">
                                    <li>Заполнение необходимой документации</li>
                                </td>
                                <td class="answ">
                                    <select>
                                        <option disabled selected data-value="nothing"></option>
                                        <option value="0">0</option>
                                        <option value="+">+</option>
                                        <option value="-">-</option>
                                    </select>
                                </td>
                            </tr>
                        </table>
                    </ol>
                </div>
                <div class="row" align="center">
                    <h5>
                        После визита
                    </h5>
                </div>
                <div class="row">
                    <ol>
                        <table class="table" width="200px">
                            <h4 class="tyQ">14.Анализ визита</h4>
                            <tr>
                                <td class="occ">
                                    <li>Анализ визита / S.M.A.R.T</li>
                                </td>
                                <td class="answ">
                                    <select>
                                        <option disabled selected data-value="nothing"></option>
                                        <option value="-">-</option>
                                        <option value="+">+</option>

                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td class="occ">
                                    <li>Определение причин удачи/неудачи</li>
                                </td>
                                <td class="answ">
                                    <select>
                                        <option disabled selected data-value="nothing"></option>
                                        <option value="-">-</option>
                                        <option value="+">+</option>

                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td class="occ">
                                    <li>Цели на следующий визит в эту ТТ</li>
                                </td>
                                <td class="answ">
                                    <select>
                                        <option disabled selected data-value="nothing"></option>
                                        <option value="-">-</option>
                                        <option value="+">+</option>

                                    </select>
                                </td>
                            </tr>
                        </table>
                    </ol>
                </div>
            </form>
            <div align="center" style="margin: 20px 20px 20px 20px"><a href="#top">
                <button type="button" class="btn btn-primary btn-block btnSAV" onclick="saved()"
                        style="width: 250px; height: 30px">Следующаяя ТТ (Сохранить)
                </button>
            </a>

                <p></p>
                <button type="button" class="btn btn-primary btn-block" onclick="block()" style="width: 250px">
                    Подведение
                    итогов за день
                </button>
            </div>
        </div>
    </div>
</div>
</div>
