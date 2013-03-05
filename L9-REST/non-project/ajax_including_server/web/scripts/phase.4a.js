$(function() {

    $('#bootChooserControl')
        .load('actions/fetchBootStyleOptions.jsp');

    $('#bootChooserControl').change(function(event) {
        $('#productDetailPane').load(
            'actions/fetchProductDetails.jsp',
            $('#bootChooserControl').serialize(),
            function() {
                $('abbr').termifier('action/fetchTerm');
            }
        );
        $('#colorChooserControl').load(
            'actions/fetchColorOptions.jsp',
            $('#bootChooserControl').serialize(),
            function() {
                $('#colorChooserControl').attr('disabled', false);
                $('#sizeChooserControl')
                    .attr('disabled', true)
                    .find('option').remove();
            }
        );
    });

    $('#colorChooserControl').change(function(event) {
        $('#sizeChooserControl').load(
            'actions/fetchSizeOptions.jsp',
            $('#bootChooserControl,#colorChooserControl').serialize(),
            function() {
                $('#sizeChooserControl').attr('disabled', false);
            }
        );
    });

    $('#selectionsPane').change(function(event) {
        $('[value=""]', event.target).remove();
    });

    $('body').ajaxComplete(function(event, xhr, options) {
        if (options.url.indexOf('fetchProductDetails') != -1) {
            $('div.termifier').remove();
        }
    });

});
