$(function() {
	$('#formRecovery').submit(function(_event) {
		
		if($('#password').val() != $('#confPassword').val()){
			Swal.fire("Atenção!", "Senhas diferentes!", "warning");
			_event.preventDefault();
		}
	})
})

function alertaTokenIncorreto() {
	Swal.fire("Atenção!", "O Token informado não pertence ao usuário!", "warning");
}