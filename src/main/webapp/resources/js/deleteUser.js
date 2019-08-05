function RestDelete(id) {
    $.ajax({
        type: "DELETE",
        url: "/admin/userDelete/" + id,
        data: id,
        success: function () {
            window.location.href = "/admin/userList";
        }
    })
}