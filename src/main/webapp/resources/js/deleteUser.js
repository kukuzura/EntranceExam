function RestDelete(id) {
    $.ajax({
        type: "DELETE",
        url: "/admin/userDelete/" + id,
        success: $('#' + id).remove()
    })
}