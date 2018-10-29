<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="entidade.Cadastro" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Página de login</title>
	<link rel="stylesheet" href="./css/bootstrap.css" />
	<script src="./js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
    <form action="./CadastroController" method="post" id="login">
  		<div class="form-group">
    		<label for="InputEmail1">E-mail</label>
    		<input type="email" class="form-control" id="email" aria-describedby="email" placeholder="Digite seu endereço de e-mail">
  		</div>
  		<div class="form-group">
    		<label for="Password1">Senha</label>
    		<input type="password" class="form-control" id="password" placeholder="Digite sua senha">
  		</div>
  		<div class="form-check">
    		<input type="checkbox" class="form-check-input" id="check1">
    		<label class="form-check-label" for="check1">Mantenha-me contectado</label>
  		</div>
        <br>
  		<button type="submit" class="btn btn-primary">Entrar</button>
	</form>
	</div>
</body>
</html>