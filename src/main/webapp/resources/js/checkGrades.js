$(document).ready(function () {
    $("#gradingForm").validate({});
    $('.grade').each(function () {
        $(this).rules('add', {
            required: true,
            number: true,
            range: [1, 100]
        })
    });

});