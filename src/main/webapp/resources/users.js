$(function() {
	$('input.currency').each(function() {
		for (var i = 0; i < 10; i++) {
			if ($(this).val().endsWith('.' + i)) {
				$(this).val($(this).val().replace('.' + i, '.' + i + '0'))
			}
		}
	})
	$('input').each(function() {
		$(this).prop('autocomplete', 'nope');
	})

	$('.collapse').collapse();
	$('.currency').maskMoney();
	$('.select2').select2();

	$("form").each(function() {
		$(this).submit(function(event) {
			$('input.currency').each(function() {
				$(this).val($(this).val().replace(new RegExp(',', 'g'), ''));
			})
		})
	});
});

function formataDinheiro(n) {
	return "R$ " + parseFloat(n).toFixed(2).replace('.', ',').replace(/(\d)(?=(\d{3})+\,)/g, "$1.");
}
