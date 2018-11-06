<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="entidade.Medico, entidade.Exame, entidade.Setor, entidade.Usuario, java.util.List, java.util.ArrayList" %>
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
    		<a class="nav-link" data-toggle="pill" href="#menu0">Cadastrar Exames</a>
 		</li>
  		<li class="nav-item">
    		<a class="nav-link" data-toggle="pill" href="#menu1"> Cadastrar Médicos</a>
 		</li>
  		<li class="nav-item">
    		<a class="nav-link" data-toggle="pill" href="#menu2">Cadastrar Setor</a>
  		</li>
        <li class="nav-item">
    		<a class="nav-link" data-toggle="pill" href="#menu3">Cadastrar Usuários</a>
  		</li>
	</ul>
	</div>
<!-- Tab panes -->
<div class="tab-content">
    
    <div class="tab-pane container active" id="home">Bem vindo Rodrigo Abreu</div>
    
    <div class="tab-pane container fade" id="menu0">
    
    <%  String msgE = (String)session.getAttribute("MENSAGEM");
	   		List<Exame> listaE = (List<Exame>)session.getAttribute("LISTA");
	   		if (listaE == null){
		   		listaE = new ArrayList<Exame>();
	   		} else {
		   		session.setAttribute("LISTA", null);
	   		}
	   
	   		if (msgE != null) {
		  		session.setAttribute("MENSAGEM", null);
		%>
			<h3 class="alert alert-danger"><%=msgE%></h3>
	<% } %>
    
    	<form action="./ExameController" method="post" id="fExame">
            <div class="form-group">
                <label for="textfield">ID:</label>
                <input type="text1" class="form-control" name="idExame"  id="idExame" readonly>
            </div>
            <div class="form-group">
                <label for="textfield">Exame:</label>
                <input type="text1" class="form-control" name="nomeExame" id="nomeExame">
            </div>      
            
            <button type="submit" class="btn btn-primary" value="adicionar" name="cmdE" id="btnEnviarE">Adicionar</button>  <button class="btn btn-primary" type="submit" value="pesquisar" name="cmdE">Pesquisar</button>
        
        	<div class="container">
        		<table class="table table-striped">
        			<tbody>
        				<% for (Exame e : listaE) { %>
        				<tr>
        					<td><%=e.getExame() %></td>	
        				</tr>
        				<% } %>
        			</tbody>
        		</table>
        	</div>      
      	</form>
    </div>
    
    <div class="tab-pane container fade" id="menu1">
        
    	<%  String msg = (String)session.getAttribute("MENSAGEM");
	   		List<Medico> lista = (List<Medico>)session.getAttribute("LISTA");
	   		if (lista == null){
		   		lista = new ArrayList<Medico>();
	   		} else {
		   		session.setAttribute("LISTA", null);
	   		}
	   
	   		if (msg != null) {
		  		session.setAttribute("MENSAGEM", null);
		%>
			<h3 class="alert alert-danger"><%=msg%></h3>
		<% } %>
        
        <form action="./MedicoController" method="post" id="fMedico">
            <div class="form-group">
                <label for="id">ID:</label>
                <input type="text1" class="form-control" name="idMedico"  id="idMedico" readonly>
            </div>
            <div class="form-group">
                <label for="id">Nome:</label>
                <input type="text1" class="form-control" name="nomeMedico" id="nomeMedico">
            </div>      
            
            <button type="submit" class="btn btn-primary" value="adicionar" name="cmdM" id="btnEnviarM">Adicionar</button>  <button class="btn btn-primary" type="submit" value="pesquisar" name="cmdM">Pesquisar</button>
        
	        <div class="container">
	        	<table class="table table-striped">
	        		<tbody>
	        			<% for (Medico m : lista) { %>
	        			<tr>
	        				<td><%=m.getNome() %></td>	
	        			</tr>
	        			<% } %>
	        		</tbody>
	        	</table>
	        </div>
        
        </form>
    </div>
    
    <div class="tab-pane container fade" id="menu2">
    
    	<%  String msgS = (String)session.getAttribute("MENSAGEM");
	   		List<Setor> listaS = (List<Setor>)session.getAttribute("LISTA");
	   		if (listaS == null){
		   		listaS = new ArrayList<Setor>();
	   		} else {
		   		session.setAttribute("LISTA", null);
	   		}
	   
	   		if (msgS != null) {
		  		session.setAttribute("MENSAGEM", null);
		%>
			<h3 class="alert alert-danger"><%=msgS%></h3>
		<% } %>
    
        <form action="./SetorController" method="post" id="fSetor">
            <div class="form-group">
                <label for="textfield">ID:</label>
                <input type="text1" class="form-control" id="idSetor" readonly>
            </div>
            <div class="form-group">
                <label for="textfield">Setor:</label>
                <input type="text1" class="form-control" id="nomeSetor" name="nomeSetor">
            </div>      
            
            <button type="submit" class="btn btn-primary" value="adicionar" name="cmdS" id="btnEnviarS">Adicionar</button>  <button class="btn btn-primary" type="submit" value="pesquisar" name="cmdS">Pesquisar</button>
        
        	<div class="container">
	        	<table class="table table-striped">
	        		<tbody>
	        			<% for (Setor s : listaS) { %>
	        			<tr>
	        				<td><%=s.getSetor() %></td>	
	        			</tr>
	        			<% } %>
	        		</tbody>
	        	</table>
	        </div>
        </form>
    </div>
    
    <div class="tab-pane container fade" id="menu3">
        
        <%  String msgU = (String)session.getAttribute("MENSAGEM");
	   		List<Usuario> listaU = (List<Usuario>)session.getAttribute("LISTA");
	   		if (listaU == null){
		   		listaU = new ArrayList<Usuario>();
	   		} else {
		   		session.setAttribute("LISTA", null);
	   		}
	   
	   		if (msgU != null) {
		  		session.setAttribute("MENSAGEM", null);
		%>
			<h3 class="alert alert-danger"><%=msgU%></h3>
		<% } %>
        
        <form action="./UsuarioController" method="post" id="fUsuario">
            <div class="form-group">
                <label for="id">ID:</label>
                <input type="text1" class="form-control" id="idUsuario" readonly>
            </div>
            <div class="form-group">
                <label for="textfield">Nome:</label>
                <input type="text1" class="form-control" id="nome" name="nome">
            </div>
            <div class="form-group">
    		  <label for="textfield">Usuário:</label>
    		  <input type="text1" class="form-control" id="nomeUsuario"  name="nomeUsuario"  placeholder="Digite o usuário do sistema">
  		    </div>
  		    <div class="form-group">
    		  <label for="Password">Senha:</label>
    		  <input type="password" class="form-control" id="password" name="password"  placeholder="Digite a senha">
  		    </div>
            
            <button type="submit" class="btn btn-primary" value="adicionar" name="cmdU" id="btnEnviarU">Adicionar</button>  <button class="btn btn-primary" type="submit" value="pesquisar" name="cmdU">Pesquisar</button>
        
        	<div class="container">
	        	<table class="table table-striped">
	        		<tbody>
	        			<% for (Usuario u : listaU) { %>
	        			<tr>
	        				<td><%=u.getNome() %></td>
	        				<td><%=u.getNomeUsuario() %></td>
	        				<td><%=u.getSenha() %></td>	
	        			</tr>
	        			<% } %>
	        		</tbody>
	        	</table>
	        </div>
        </form>
    </div>
</div>
</body>
</html>