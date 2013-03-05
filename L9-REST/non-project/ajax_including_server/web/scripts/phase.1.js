/**
 * Loading of boot style based on the detail information from secondary server call
 */
$(function() {

    $('#bootChooserControl')
        .load('actions/fetchBootStyleOptions.jsp');

    $('#bootChooserControl').change(function(event) {
        $('#productDetailPane').load(
            'actions/fetchProductDetails.jsp',
            {style: $(event.target).val()},
            function() {
                $('[value=""]', event.target).remove();
            }
        );
    });
});
