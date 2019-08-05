$(document).ready(function () {
    $('#editForm').submit(function (e) {
        var login = $('#login').val();
        var password = $('#password').val();
        var id = $('#id').val();
        e.preventDefault();
        $.ajax({
            type: 'PUT',
            url: '/admin/updateProcess',
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            data: JSON.stringify({"id": id, "login": login, "password": password}),
            success: window.location.href = "/admin/userList"
        });
    });
});