$(function () {


    $('#selRegion').change(function () {
        var regionId = $('#selRegion option:selected').data('value')
        clearSelVtp()
        $('#selDistr').load('answer/getDistr', {regionId: regionId}, function (response, status, xhr) {
            if (status == 'success') {
                $('#selDistr').append(xhr);
                $('.selectpicker').selectpicker('refresh');
            } else {
                alert('Ошибка: ' + xhr.status + ' ' + xhr.statusText + ' , Авторизуйтесь заново.');
            }
        });

    })
    $('#selDistr').change(function () {
        var distrId = $('#selDistr option:selected').data('value')
        clearSelVtp()
        $('#selVtp').load('answer/getVtp', {distrId: distrId}, function (response, status, xhr) {
            if (status == 'success') {
                $('#selVtp').append(xhr);
                $('.selectpicker').selectpicker('refresh');
            } else {
                alert('Ошибка: ' + xhr.status + ' ' + xhr.statusText + ' , Авторизуйтесь заново.');
            }
        });

    })
    $('#selVtp').change(function () {
            $('.endVtp').css("display", "none")
            $('.timeS').text(time())
            $('.selectpicker').selectpicker('refresh');
            $('.grade').text('')
            $('.answVtp').empty()
            $.post('answer/answer', {fio: $('#selVtp option:selected').text()})
                .done(function (data) {
                    checkForRedirect(data);
                    console.log(data);
                    $('.answVtp').append(data);
                    $('.answVtp').css("display", "block")
                })
                .fail(function () {
                    showErrorPane()
                })
                .always(function (data) {
                    $('#loader').css('display', 'none');
                });
            $.post('answer/grade', {fio: $('#selVtp option:selected').text()})
                .done(function (data) {
                    checkForRedirect(data);
                    console.log(data);
                    $('.grade').append(data);
                })
                .fail(function () {
                    showErrorPane()
                })
                .always(function (data) {
                    $('#loader').css('display', 'none');
                });
            $('.selV1').text('Выбор ВТП: ' + $('#selVtp option:selected').text())
            $('.selV2').text('Оценка работы ВТП: ' + $('#selVtp option:selected').text())
            $('.endVt').text('Подведение итогов за день: ' + $('#selVtp option:selected').text())
        }
    )
})

function time() {

    var t = new Date()
    var hour = t.getHours()
    var min = t.getMinutes() + ''
    var date = t.getDate()
    var month = t.getMonth() + 1
    var year = t.getFullYear()
    var sec = t.getSeconds() + ''
    if (sec.length == 1) {
        sec = '0' + sec
    }
    if (min.length == 1) {
        min = '0' + min
    }
    if (month.length == 1) {
        month = '0' + month
    }
    if (date.length == 1) {
        date = '0' + date
    }
    var tiDa = year + '.' + month + '.' + date + ';' + hour + ':' + min + ':' + sec
    return tiDa
}

function clearSelVtp() {
    $('.selV1').text('Выбор ВТП')
    $('.selV2').text('Оценка работы ВТП')
}

function loadDistrs(regionId) {
    $('#loader').css('display', 'block');
    $.post('answer',
        {
            regionId: regionId
        })
        .done(function (data) {
            checkForRedirect(data);
            console.log(data);
            $('#selDistr').append(data);
        })
        .fail(function () {
            showErrorPane()
        })
        .always(function (data) {
            $('#loader').css('display', 'none');
        });
}

function block() {
    $('.endVtp').css("display", "block")
    /*$('.btnSAV').css("display", "none")*/
}

function saved(p) {
    var text = ((($(".selV2").text()).slice(32)).replace(/\r|\n/g, '')).trim()
    var type
    var question
    var answ
    var nameauditor
    var i = 0
    var json = 0
    var arr = []
    var now = $('.timeS').text()
    var now2 = time()
    fiovtp = text
    id = ((($('.vizNum').text()).slice(8)).replace(/\r|\n/g, '')).trim()
    var size = $('.occ').length
    var t = 0
    if (p != 2) {
        while ($('.occ').eq(i).text() != "") {
            type = $($('.occ').eq(i).parents("table")).siblings("h4").text()
            question = (($('.occ').eq(i).text()).replace(/\r|\n/g, '')).trim()
            answ = $('.answ').eq(i).find('select').val()
            tema=$('.tema').text()
            if (answ == undefined || answ == null) {
                alert("Сохранение невозможно, необходимо оценить все пункты")
                t = 1
                break
            }
            nameauditor = (($('#lbl_user_name').text()).replace(/\r|\n/g, '')).trim()
            stage = $($('.answ').eq(i)).parents('form').attr('id')

            if (json == 0) {
                json = JSON.stringify({
                    'type': type,
                    'question': question,
                    'answer': answ,
                    'nameauditor': nameauditor,
                    'namevtp': fiovtp,
                    'time': now,
                    'creationTime': now2,
                    'vizNum': id,
                    'stage': stage,
                    'tema': tema
                })
                arr.push(JSON.parse(json))
            } else {
                var obj = JSON.parse(json);
                var js = new Object()
                js['type'] = type
                js['question'] = question
                js['answer'] = answ
                js['nameauditor'] = nameauditor
                js['namevtp'] = fiovtp
                js['time'] = now
                js['creationTime'] = now2
                js['vizNum'] = id
                js['stage'] = stage
                js['tema']=tema
                arr.push(js);
            }
            i++
        }
    }
    else {
        id = ((($('.vizNum').text()).slice(8)).replace(/\r|\n/g, '')).trim()
        while ($('.occ2').eq(i).text() != "") {
            type = 'Завершение обучения'
            question = (($('.ques').eq(i).text()).replace(/\r|\n/g, '')).trim()
            answ = $('.answ2').eq(i).find('select').val() + ''
            tema=$('.tema').text()
            if (answ == undefined || answ == 'null' || answ == ''  || answ == null) {
                alert("Сохранение невозможно, необходимо оценить все пункты")
                t = 1
                break
            }
            if (answ == 'undefined') {
                answ = $('.answ2').eq(i).val()
            }
            nameauditor = (($('#lbl_user_name').text()).replace(/\r|\n/g, '')).trim()
            stage = 3

            if (json == 0) {
                json = JSON.stringify({
                    'type': type,
                    'question': question,
                    'answer': answ,
                    'nameauditor': nameauditor,
                    'namevtp': fiovtp,
                    'time': now,
                    'creationTime': now2,
                    'vizNum': id - 1,
                    'stage': stage,
                    'tema': tema
                })
                arr.push(JSON.parse(json))
            } else {
                var obj = JSON.parse(json);
                var js = new Object()
                js['type'] = type
                js['question'] = question
                js['answer'] = answ
                js['nameauditor'] = nameauditor
                js['namevtp'] = fiovtp
                js['time'] = now
                js['creationTime'] = now2
                js['vizNum'] = id - 1
                js['stage'] = stage
                js['tema']=tema
                arr.push(js);
            }
            i++
        }
    }
    if (t != 1) {
        $.ajax({
            url: 'answer/evaluators',
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify(arr),
            statusCode: {
                500:
                    function (xhr) {
                        window.location = '/login.html';
                        alert("Сервер не доступен!")
                    }
                ,
                200:
                    function (xhr) {
                        checkForRedirect(xhr);
                        console.log(xhr);
                        $('.answVtp').empty();
                        $('.answVtp').append(xhr);
                        alert("Сохранено!")
                    }
            }
        });

        $('.timeS').text(time())
        if (p == 2) {
            $('.endVtp').css("display", "none")
            $('.answVtp').css("display", "none")
            $('.non').prop('selected', true);
            $('.grade').text('')
            $('.tem').selectpicker('deselectAll')
            $('.inputComm').val('')
            clearSelVtp()
            $('#selDistr').change()
        }
    }
}

