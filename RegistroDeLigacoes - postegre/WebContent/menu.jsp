
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="./css/bootstrap.css" />
<script src="./js/bootstrap.min.js"></script>
<title>Menu</title>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
</head>
<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<ul class="nav navbar-nav">
			<li><a href="Home.jsp">Home</a></li>
			<li><a href="RegistroLigacao.jsp">Cadastro</a></li>
			<li><a href="CadastroExame.jsp">Exames</a></li>
			<li><a href="CadastroMedico.jsp">Médicos</a></li>
			<li><a href="CadastroSetor.jsp">Setor</a></li>
			<li><a href="CadastroUsuario.jsp">Usuários</a></li>
		</ul>
		<form action="./Authenticator" method="post" id="logout">
		<input type="hidden" name="cmd" value="logout">
		<ul class="nav navbar-nav navbar-right">
			<li><a href="./index.jsp"><span class="glyphicon glyphicon-log-in"></span> Sair </a></li>
		</ul>
		</form>
	</div>
	</nav>
</body>
</html>
