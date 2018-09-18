<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>


<aside class="main-sidebar">
	<section class="sidebar">
		<ul class="sidebar-menu">
			<li class="header">Admin</li>
			<li class="treeview"><a href="#"> <i class="fa fa-users"></i>
					<span>Usuarios</span> <i class="fa fa-angle-left pull-right"></i>
			</a>
				<ul class="treeview-menu">
					<li><a href='<spring:url value="/users.html"></spring:url>'>
							<i class="glyphicon glyphicon-list-alt"></i>Lista de Usuarios
					</a></li>
				</ul></li>

			<li class="treeview"><a href="#"> <i
					class="fa fa-newspaper-o"></i> <span>Noticias</span> <i
					class="fa fa-angle-left pull-right"></i>
			</a>
				<ul class="treeview-menu">
					<li><a href='<spring:url value="/noticias.html"></spring:url>'>
							<i class="glyphicon glyphicon-list-alt"></i>Noticias
					</a></li>
				</ul></li>

		</ul>
		<!-- /.sidebar menu -->
	</section>
	<!-- /.sidebar -->
</aside>