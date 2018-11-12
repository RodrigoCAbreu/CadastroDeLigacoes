<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="entidade.Usuario, java.util.List, java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Usuários</title>
<link rel="stylesheet" href="./css/bootstrap.css" />
<script src="./js/jquery-3.3.1.min.js"></script>
<script src="js/bootstrap.js"></script>
</head>
<body>
<%@ include file="./menu.jsp" %>
<br><br>
	<section>
		<h1>Cadastro de Usuários</h1>
	</section>

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
        
        </form>
	<br><br>
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

</body>
</html>