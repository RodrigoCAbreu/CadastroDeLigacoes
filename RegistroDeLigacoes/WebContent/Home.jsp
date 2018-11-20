<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Página inicial</title>
<script src="./js/bootstrap.min.js"></script>
<script src="./js/jquery-3.3.1.min.js"></script>
<link rel="stylesheet" href="./css/bootstrap.css" />
</head>
<body>
<%@ include file="./menu.jsp" %>
	<div class="container">
        
        <section style="text-align:center">
        	<h2>Bem vindo ao sistema de gerenciamento</h2>
        </section>
        <br><br>
        <div class="icones">
        	<a href="RegistroLigacao.jsp">
        	<div>
        		<i class="fas fa-phone fa-5x"></i>
        	</div>
            <div class="titulo">
        		<h2>Registro de Ligação</h2>
        	</div>
            </a>
        </div>
        <br>
        <div class="icones">
        	<a href="CadastroExame.jsp">
        	<div>
        		<i class="fas fa-file-alt fa-5x"></i>
        	</div>
            <div class="titulo">
        		<h2>Cadastrar Exame</h2>
        	</div>
            </a>
        </div>
        <br>
        <div class="icones">
        	<a href="CadastroMedico.jsp">
        	<div>
        		<i class="fas fa-user-md fa-5x"></i>
        	</div>
            <div class="titulo">
        		<h2>Cadastrar Médico</h2>
        	</div>
            </a>
        </div>
        <br>
        <div class="icones">
        	<a href="CadastroSetor.jsp">
        	<div>
        		<i class="fas fa-clipboard-list fa-5x"></i>
        	</div>
            <div class="titulo">
        		<h2>Cadastrar Setor</h2>
        	</div>
            </a>
        </div>
        <br>
        <div class="icones">
        	<a href="CadastroUsuario.jsp">
        	<div>
        		<i class="fas fa-user-plus fa-5x" ></i>
        	</div>
            <div class="titulo">
        		<h2>Cadastrar Usuário</h2>
        	</div>
            </a>
        </div>
        </div>
</body>
</html>