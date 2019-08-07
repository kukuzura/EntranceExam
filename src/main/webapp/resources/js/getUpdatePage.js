function RestGetUpdatePage(id) {
    $.ajax({
        type: "get",
        url: "/admin/userUpdate/"+id,
        data: id,
        success: window.location.href = "../admin/userUpdate/" + id
    })
}