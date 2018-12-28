<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="entidade.Cadastro" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Página de login</title>
<script src="./js/bootstrap.min.js"></script>
<script src="./js/jquery-3.3.1.min.js"></script>
<link rel="stylesheet" href="./css/bootstrap.css" />
</head>
<body>
	<% String msg = (String)session.getAttribute("MENSAGEM");
	
		if (msg != null) {
			session.setAttribute("MENSAGEM", null);
	%>
			<h3 class="alert alert-danger"><%=msg%></h3>
	<% } %>
	
	<br><br>


	<div class="container">
    <form action="./Authenticator" method="post" id="login">
    	<h1>Login</h1>
  		<h3>Informe os seus dados para acessar o sistema</h3>
  		<br><br>
  		<div class="form-group">
    		<label for="InputUser">Usuário</label>
    		<input type="text1" class="form-control" name="userName" id="userName" placeholder="Digite seu usuário">
  		</div>
  		<div class="form-group">
    		<label for="Password1">Senha</label>
    		<input type="password" class="form-control" name="password" id="password" placeholder="Digite sua senha">
  		</div>
  		<div class="form-check">
    		<input type="checkbox" class="form-check-input" id="check1">
    		<label class="form-check-label" for="check1">Mantenha-me contectado</label>
  		</div>
        <br>
  		<button type="submit" class="btn btn-primary" name="cmd" id="cmd" value="Logar">Entrar</button>
	</form>
	</div>
</body>
</html>