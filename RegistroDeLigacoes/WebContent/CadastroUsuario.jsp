<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="entidade.Usuario, java.util.List, java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Usuários</title>
<script src="./js/bootstrap.min.js"></script>
<script src="./js/jquery-3.3.1.min.js"></script>
<link rel="stylesheet" href="./css/bootstrap.css" />
<script >
function remover( id ) {
			if (confirm("Remove o Exame com id " + id)) {
				$('#fUsuario').empty();
				$('#fUsuario').append('<input type="hidden" name="idUsuario" value="' + id + '"/>');
				$('#fUsuario').append('<input type="hidden" name="cmdU" value="remover"/>');
				$('#fUsuario').submit();
			}
		}

		function editar( id ) {
			$('#fUsuario').empty();
			$('#fUsuario').append('<input type="hidden" name="idUsuario" value="' + id + '"/>');
			$('#fUsuario').append('<input type="hidden" name="cmdU" value="editar"/>');
			$('#fUsuario').submit();
		}
</script>
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
	   		
	   		Usuario usuarioAtual = (Usuario)session.getAttribute("USUARIO_ATUAL");
	   		if (usuarioAtual == null) {
	   			usuarioAtual = new Usuario();
	   		} else {
	   			session.setAttribute("USUARIO_ATUAL", null);
	   		}
	   
	   		if (msgU != null) {
		  		session.setAttribute("MENSAGEM", null);
		%>
			<h3 class="alert alert-danger"><%=msgU%></h3>
		<% } %>
        
        <form action="./UsuarioController" method="post" id="fUsuario">
            <div class="form-group">
                <label for="id">ID:</label>
                <input type="text1" class="form-control" id="idUsuario" name="idUsuario" value="<%=usuarioAtual.getId()%>" readonly>
            </div>
            <div class="form-group">
                <label for="textfield">Nome:</label>
                <input type="text1" class="form-control" id="nome" name="nome" value="<%=usuarioAtual.getNome()%>">
            </div>
            <div class="form-group">
    		  <label for="textfield">Usuário:</label>
    		  <input type="text1" class="form-control" id="nomeUsuario"  name="nomeUsuario"  placeholder="Digite o usuário do sistema" value="<%=usuarioAtual.getNomeUsuario()%>">
  		    </div>
  		    <div class="form-group">
    		  <label for="Password">Senha:</label>
    		  <input type="password" class="form-control" id="password" name="password"  placeholder="Digite a senha" value="<%=usuarioAtual.getSenha()%>">
  		    </div>
            
            <div class="form-group">
				<%if (usuarioAtual.getId() == 0) { %>
					<button type="submit" class="btn btn-primary" name="cmdU" value="adicionar">Adicionar</button>
				<%} else { %>
					<button type="submit" class="btn btn-primary" name="cmdU" value="salvar">Salvar</button>
				<%} %>
				<button type="submit" class="btn btn-primary" name="cmdU" value="pesquisar">Pesquisar</button>
			</div>
        </form>
		<br>
		<br>
		<%if (listaU.size() > 0) {%>
		<div class="container">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Id</th>
						<th>Nome</th>
						<th>Usuário</th>
						<th>Senha</th>
					</tr>
				</thead>
				<tbody>
					<% for (Usuario u : listaU) { %>
					<tr>
						<td><%=u.getId() %></td>
						<td><%=u.getNome() %></td>
						<td><%=u.getNomeUsuario() %></td>
						<td><%=u.getSenha() %></td>
						<td>
							<div class="form-group">
								<button type="button" class="btn btn-primary" onclick="remover('<%=u.getId()%>');">Remover</button>
								<button type="button" class="btn btn-primary" onclick="editar('<%=u.getId()%>');">Editar</button>
							</div>																		
						</td>
					</tr>
					<% } %>
				</tbody>
			</table>
		</div>
		<%} %>
</body>
</html>