function checkAll() {
	$('input[name="funcionalidadeId"]').each(function() {
		$(this).prop('checked', true);
	})
}

function uncheckAll() {
	$('input[name="funcionalidadeId"]').each(function() {
		$(this).prop('checked', false);
	})
}

$(function() {
	$('#formMenu').submit(function(_event) {
		var i = 0;
		$('input[name="funcionalidadeId"]').each(function() {
			if ($(this).prop('checked')) {
				$(this).attr('name', 'funcionalidades[' + i + ']\.id')
				$(this).attr('id', 'funcionalidades' + i + 'id')
				i++;
			}
		})
	})
})