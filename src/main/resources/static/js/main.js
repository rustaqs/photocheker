$(function () {
    $('#selRep').change(function () {
        var selRep = $('#selRep option:selected').data('value')
        if (selRep=='0'){
            window.location = '/';
        }
        if (selRep=='1'){
            window.location = '/reports';
        }
    })

});

function showErrorPane() {
    $("#errorBlock").show();
    setTimeout(function() { $("#errorBlock").hide(); }, 3000);
}

function showSavedSuccessfullyPane() {
    $("#savedSuccessfullyBlock").show();
    setTimeout(function() { $("#savedSuccessfullyBlock").hide(); }, 2000);
}

function checkForRedirect(data) {
    if (data.urlToRedirect !== undefined) {
        window.location = data.urlToRedirect;
        return;
    }
}