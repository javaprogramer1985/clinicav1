$(document).ready(function () {
    $.ajax({
        url: '../DatosMenu',
        data: {
            userName: $('userName').val()
        },
        success: function (responseText) {
            $('#ajaxGetUserServletResponse').text(responseText);
        }
    });
});

