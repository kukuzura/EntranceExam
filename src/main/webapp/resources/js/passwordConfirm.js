function validatePassword() {
    var validator = $("#registrationForm").validate({
        rules: {
            confirm_password: {
                equalTo: "#password"
            }
        },
        messages: {
            confirm_password: "Enter Confirm Password Same as Password"
        },
        errorElement: 'span'
    });
    if (validator.form()) {
        $("#registrationForm").submit();
    }
}
