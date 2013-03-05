$(function() {

    $('#bootChooserControl')
        .load('actions/fetchBootStyleOptions.jsp');

    $('#bootChooserControl').change(function(event) {
        $('#productDetailPane').load(
            'actions/fetchProductDetails.jsp',
            $(this).serialize()
        );
        $('#colorChooserControl').load(
            'actions/fetchColorOptions.jsp',
            $(this).serialize(),
            function() {
                $(this).attr('disabled', false);
                $('#sizeChooserControl')
                    .attr('disabled', true)
                    .html("");
            }
        );
    });

    $('#colorChooserControl').change(function(event) {
        $('#sizeChooserControl').load(
            'actions/fetchSizeOptions.jsp',
            $('#bootChooserControl,#colorChooserControl').serialize(),
            function() {
                $(this).attr('disabled', false);
            }
        );
    });

    $('#selectionsPane').change(function(event) {
        $('[value=""]', event.target).remove();
    });

});
