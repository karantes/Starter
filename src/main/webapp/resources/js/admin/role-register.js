function checkAll(_menu) {
	$('input[name="funcionalidade' + _menu + 'Id"]').each(function() {
		if ($(this).hasClass(_menu))
			$(this).prop('checked', true);
	})
}

function uncheckAll(_menu) {
	$('input[name="funcionalidade' + _menu + 'Id"]').each(function() {
		if ($(this).hasClass(_menu))
			$(this).prop('checked', false);
	})	
}

$(function() {
	$('#formRole').submit(function(_event) {
		var i = 0;
		$('input[name="menuId"]').each(function() {
			if ($(this).prop('checked')) {
				$(this).attr('name', 'menus[' + i + ']\.id');
				$(this).attr('id', 'menus' + i + 'id');
				var classe = $(this).prop('class');
				var j = 0;
				$('input[name="funcionalidade' + classe + 'Id"]').each(function() {
					if ($(this).prop('checked')) {
						$(this).attr('name', 'menus[' + i + ']\.funcionalidades[' + j + ']\.id');
						$(this).attr('id', 'menus' + i + 'funcionalidades' + j + 'id');
						j++;
					}
				})
				i++;
			}
		})
	})
})