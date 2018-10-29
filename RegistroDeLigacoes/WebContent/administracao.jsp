<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="entidade.Cadastro" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Página administração</title>
	<link rel="stylesheet" href="./css/bootstrap.css" />
	<script src="./js/bootstrap.min.js"></script>
	<script src="js/jquery-1.11.2.min.js"></script>
	<script src="js/bootstrap.js"></script>
</head>
<body>
	<div class="container">
    <ul class="nav nav-pills" id="navBar">
  		<li class="nav-item">
    		<a class="nav-link active" data-toggle="pill" href="#home">Home</a>
  		</li>
  		<li class="nav-item">
    		<a class="nav-link" data-toggle="pill" href="#menu1">Médicos</a>
 		</li>
  		<li class="nav-item">
    		<a class="nav-link" data-toggle="pill" href="#menu2">Setor</a>
  		</li>
        <li class="nav-item">
    		<a class="nav-link" data-toggle="pill" href="#menu3">Usuários</a>
  		</li>
	</ul>
	</div>
<!-- Tab panes -->
<div class="tab-content">
    
    <div class="tab-pane container active" id="home">Bem vindo Rodrigo Abreu</div>
    
    <div class="tab-pane container fade" id="menu1">
        <form action="" method="post" id="fMedico">
            <div class="form-group">
                <label for="id">ID:</label>
                <input type="text" class="form-control" id="idMedico" readonly>
            </div>
            <div class="form-group">
                <label for="id">Nome</label>
                <input type="text" class="form-control" id="nomeMedico">
            </div>      
            
            <button type="submit" class="btn btn-primary" value="adicionar" name="cmdM" id="btnEnviarM">Adicionar</button>  <button class="btn btn-primary" type="submit" value="pesquisar" name="cmdM">Pesquisar</button>
        </form>
    </div>
    
    <div class="tab-pane container fade" id="menu2">
        <form action="" method="post" id="fSetor">
            <div class="form-group">
                <label for="id">ID:</label>
                <input type="text" class="form-control" id="idSetor" readonly>
            </div>
            <div class="form-group">
                <label for="id">Nome</label>
                <input type="text" class="form-control" id="nomeSetor">
            </div>      
            
            <button type="submit" class="btn btn-primary" value="adicionar" name="cmdS" id="btnEnviarS">Adicionar</button>  <button class="btn btn-primary" type="submit" value="pesquisar" name="cmdS">Pesquisar</button>
        </form>
    </div>
    
    <div class="tab-pane container fade" id="menu3">
        <form action="" method="post" id="fUsuario">
            <div class="form-group">
                <label for="id">ID:</label>
                <input type="text" class="form-control" id="idUsuario" readonly>
            </div>
            <div class="form-group">
                <label for="id">Nome</label>
                <input type="text" class="form-control" id="nomeUsuario">
            </div>
            <div class="form-group">
    		  <label for="InputEmail1">E-mail</label>
    		  <input type="email" class="form-control" id="email" aria-describedby="email" placeholder="Digite o endereço de e-mail">
  		    </div>
  		    <div class="form-group">
    		  <label for="Password">Senha</label>
    		  <input type="password" class="form-control" id="password" placeholder="Digite a senha">
  		    </div>
            
            <button type="submit" class="btn btn-primary" value="adicionar" name="cmdU" id="btnEnviarU">Adicionar</button>  <button class="btn btn-primary" type="submit" value="pesquisar" name="cmdU">Pesquisar</button>
        </form>
    
    </div>
</div>
</body>
</html>