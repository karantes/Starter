$(function() {
	$('#formRole').submit(function(_event) {
		var i = 0;
		$('input[name="menuId"]').each(function() {
			if ($(this).prop('checked')) {
				$(this).attr('name', 'menus[' + i + ']\.id');
				$(this).attr('id', 'menus' + i + 'id');
				i++;
			}
		})
	})
})