function RestDelete(id) {
    $.ajax({
        type: "DELETE",
        url: "userDelete/" + id,
        success: $('#' + id).remove()
    })
}