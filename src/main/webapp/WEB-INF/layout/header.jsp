<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form action="https://www.paypal.com/cgi-bin/webscr" method="post"
	target="_top">
	<input type="hidden" name="cmd" value="_s-xclick"> <input
		type="hidden" name="hosted_button_id" value="R3SNJMZS49LU8">
	<button style="display: none" type="submit" id="btn-donate"></button>
</form>
<nav
	class="navbar navbar-expand-lg bg-primary fixed-top navbar-transparent">
	<div class="container">
		<div class="dropdown button-dropdown">
			<a href="#" class="dropdown-toggle" id="navbarDropdown"
				data-toggle="dropdown"> <span class="button-bar"></span> <span
				class="button-bar"></span> <span class="button-bar"></span>
			</a>
			<div class="dropdown-menu" aria-labelledby="navbarDropdown">
				<a class="dropdown-header">Dropdown header</a> <a
					class="dropdown-item" href="#">Action</a> <a class="dropdown-item"
					href="#">Another action</a> <a class="dropdown-item" href="#">Something
					else here</a>
				<div class="dropdown-divider"></div>
				<a class="dropdown-item" href="#">Separated link</a>
				<div class="dropdown-divider"></div>
				<a class="dropdown-item" href="#">One more separated link</a>
			</div>
		</div>
		<div class="navbar-translate">
			<a class="navbar-brand" href="#" rel="tooltip"
				title="Coded by Kaique Arantes" data-placement="bottom"
				target="_blank"> Kit inicial. </a>
			<button class="navbar-toggler navbar-toggler" type="button"
				data-toggle="collapse" data-target="#navigation"
				aria-controls="navigation-index" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-bar top-bar"></span> <span
					class="navbar-toggler-bar middle-bar"></span> <span
					class="navbar-toggler-bar bottom-bar"></span>
			</button>
		</div>
		<div class="collapse navbar-collapse justify-content-end"
			id="navigation"
			data-nav-image="/resources/plugins/nowUIKit/img/blurred-image-1.jpg">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="#"
					onclick="$('#btn-donate').click()">Doar</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Problemas?</a></li>
				<li class="nav-item"><a class="nav-link" rel="tooltip"
					title="Follow us on Twitter" data-placement="bottom"
					href="https://twitter.com" target="_blank"> <i
						class="fab fa-twitter"></i> <i class="d-lg-none d-xl-none">Twitter</i>
				</a></li>
				<li class="nav-item"><a class="nav-link" rel="tooltip"
					title="Like us on Facebook" data-placement="bottom"
					href="https://www.facebook.com" target="_blank"> <i
						class="fab fa-facebook-square"></i> <i class="d-lg-none d-xl-none">Facebook</i>
				</a></li>
				<li class="nav-item"><a class="nav-link" rel="tooltip"
					title="Follow us on Instagram" data-placement="bottom"
					href="https://www.instagram.com" target="_blank"> <i
						class="fab fa-instagram"></i> <i class="d-lg-none d-xl-none">Instagram</i>
				</a></li>
			</ul>
		</div>
	</div>
</nav>