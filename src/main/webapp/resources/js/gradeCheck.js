$(".validate").validate({
    rules: {
        grade: {
            required: true,
            range: [1, 100]
        }
    },
    messages: {
        email: {
            required: "Введите оценку",
            email: "Адрес должен быть вида name@domain.com"
        }
    },
    focusInvalid: true,
    errorClass: "error"
});
]]>