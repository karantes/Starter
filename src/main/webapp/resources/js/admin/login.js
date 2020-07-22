function showPassword() {
	var x = document.getElementById("password");
	if (x.type === "password") {
		$('#iconEye').removeClass('fa-eye-slash');
		$('#iconEye').addClass('fa-eye');
		x.type = "text";
	} else {
		$('#iconEye').addClass('fa-eye-slash');
		$('#iconEye').removeClass('fa-eye');
		x.type = "password";
	}
}

function alertaUsuarioIncorreto() {
	Swal.fire("Atenção!", "Usuário ou senha incorretos!", "warning");
}

function alertaSenhaAlterada() {
	Swal.fire("Sucesso!", "Senha alterada com sucesso!", "success");
}

function alertaFacaLogin() {
	Swal.fire("Atenção!", "Você precisa estar logado para acessar o sistema!",
		"error");
}
