/**
 * Function(response) using get rather than load on the change event
 */
$(function() {

    $('#bootChooserControl')
        .load('actions/fetchBootStyleOptions.jsp');

    $('#bootChooserControl').change(function(event) {
        $.get(
            'actions/fetchProductDetails.jsp',
            {style: $(event.target).val()},
            function(response) {
                $('#productDetailPane').html(response);
                $('[value=""]', event.target).remove();
            }
        );
    });

});
