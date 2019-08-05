function RestGetUpdatePage(id) {
    $.ajax({
        type: "get",
        url: "/admin/userUpdate/"+id,
        data: id,
        success: function(){
            window.location.href="/admin/userUpdate/"+id;
        }
    })
}