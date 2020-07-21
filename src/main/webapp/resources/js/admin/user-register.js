$(function() {
	$('#idLegal').blur(function() {
		$
			.post(
				window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2)) + '/ajax/busca-usuario.html',
				{
					idLegal: $('#idLegal').val()
				},
				function(data) {
					var user = JSON.parse(data);
					if (user != null) {
						Swal.fire("Atenção!", "CPF/CNPJ (" + $('#idLegal').val() + ") já Cadastrado!", "warning");
						$('#idLegal').val('');
					}
				})
			.fail(
				function(error) {
					console.log(error);
				});
	});

	$('#email').blur(function() {
		$
			.post(
				window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2)) + '/ajax/busca-usuario.html',
				{
					email: $('#email').val()
				},
				function(data) {
					var user = JSON.parse(data);
					if (user != null) {
						Swal.fire("Atenção!", "Email (" + $('#email').val() + ") já Cadastrado!", "warning");
						$('#email').val('');
					}
				})
			.fail(
				function(error) {
					console.log(error);
				});
	});

});