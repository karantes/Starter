$(function() {
	 $('.btn-block').on('click', function() {
		$(this).closest('form').on('submit', function() {
				if ($(this).valid()) {
					var block_ele = $(this).closest('.card');
					$(block_ele).block({
						message : '<div class="ft-refresh-cw icon-spin font-medium-2"></div>',
						// timeout : 3000, // unblock after 3 seconds
						overlayCSS : {
							backgroundColor : '#fff',
							opacity : 0.8,
							cursor : 'wait'
						},
						css : {
							border : 0,
							padding : 0,
							backgroundColor : 'transparent'
						}
					});
				}
			})
    });

	$('input.currency').each(function() {
		for (var i = 0; i < 10; i++) {
			if ($(this).val().endsWith('.' + i)) {
				$(this).val($(this).val().replace('.' + i, '.' + i + '0'))
			}
		}
	})
	$('input').each(function() {
		$(this).prop('autocomplete', 'nope');
		if ($(this).prop('required')) {
			var label = $(this).parent().find('label');
			label.html('<b style="color: red;">*</b>' + label.html());
		}
	})

	$('select').each(function() {
		if ($(this).prop('required')) {
			var label = $(this).parent().find('label');
			label.html('<b style="color: red;">*</b>' + label.html());
		}
	});
	$('textarea').each(function() {
		if ($(this).prop('required')) {
			var label = $(this).parent().find('label');
			label.html('<b style="color: red;">*</b>' + label.html());
		}
	});

	$('.currency').maskMoney();
	$('.select2').select2();

	$("form").each(function() {
		$(this).submit(function(_event) {
			$('input.currency').each(function() {
				$(this).val($(this).val().replace(new RegExp(',', 'g'), ''));
			})
		})
	});

	$('.table')
			.each(
					function() {
						if (!$(this).hasClass('simple-table'))
							$(this)
									.DataTable(
											{
												destroy : true,
												scrollX : true,
												pageLength : 10,
												dom : 'Bfrtip',
												ordering : !$(this).hasClass(
														'ignore-ordering'),
												buttons : [
														{
															extend : 'excelHtml5',
															footer : true
														},
														{
															extend : 'csvHtml5',
															footer : true
														},
														{
															extend : 'print',
															orientation : !$(
																	this)
																	.hasClass(
																			'portrait') ? 'landscape'
																	: 'portrait',
															footer : true
														},
														{
															extend : 'pdf',
															orientation : !$(
																	this)
																	.hasClass(
																			'portrait') ? 'landscape'
																	: 'portrait',
															pageSize : 'LEGAL',
															footer : true
														},
														{
															extend : 'pageLength',
															footer : true
														} ]
											});
						else
							$(this).DataTable({
								destroy : true,
								scrollX : true,
								searching : false,
								lengthChange : false,
								paging : false,
								ordering : false,
								info : false
							});

					});

});

function formataDinheiro(n) {
	return "R$ "
			+ parseFloat(n).toFixed(2).replace('.', ',').replace(
					/(\d)(?=(\d{3})+\,)/g, "$1.");
}
