function RestGetUpdatePage(id) {
    var contextPath = "${pageContext.request.contextPath}";
    $.ajax({
        type: "get",
        url: "userUpdate/" + id,
        data: id,
        success: window.location.href = "userUpdate/" + id
    })
}