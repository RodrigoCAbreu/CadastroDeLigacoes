<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="entidade.Setor, java.util.List, java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Setor</title>
<script src="./js/bootstrap.min.js"></script>
<script src="./js/jquery-3.3.1.min.js"></script>
<link rel="stylesheet" href="./css/bootstrap.css" />
<script >
function remover( id ) {
			if (confirm("Remove o Exame com id " + id)) {
				$('#fSetor').empty();
				$('#fSetor').append('<input type="hidden" name="idSetor" value="' + id + '"/>');
				$('#fSetor').append('<input type="hidden" name="cmdS" value="remover"/>');
				$('#fSetor').submit();
			}
		}

		function editar( id ) {
			$('#fSetor').empty();
			$('#fSetor').append('<input type="hidden" name="idSetor" value="' + id + '"/>');
			$('#fSetor').append('<input type="hidden" name="cmdS" value="editar"/>');
			$('#fSetor').submit();
		}
</script>
</head>
<body>
<%@ include file="./menu.jsp" %>
<br><br>

	<section>
		<h1>Cadastro de Setor</h1>
	</section>

	<%
		String msgS = (String)session.getAttribute("MENSAGEM");
		List<Setor> listaS = (List<Setor>) session.getAttribute("LISTA");
		if (listaS == null) {
			listaS = new ArrayList<Setor>();
		} else {
			session.setAttribute("LISTA", null);
		}

		Setor setorAtual = (Setor) session.getAttribute("SETOR_ATUAL");
		if (setorAtual == null) {
			setorAtual = new Setor();
		} else {
			session.setAttribute("SETOR_ATUAL", null);
		}

		if (msgS != null) {
			session.setAttribute("MENSAGEM", null);
	%>
	<h3 class="alert alert-danger"><%=msgS%></h3>
		<% } %>
    
        <form action="./SetorController" method="post" id="fSetor">
            <div class="form-group">
                <label for="textfield">ID:</label>
                <input type="text1" class="form-control" id="idSetor" name="idSetor" value="<%=setorAtual.getId()%>" readonly>
            </div>
            <div class="form-group">
                <label for="textfield">Setor:</label>
                <input type="text1" class="form-control" id="nomeSetor" name="nomeSetor" value="<%=setorAtual.getSetor()%>">
            </div>      
            
            <div class="form-group">
				<%if (setorAtual.getId() == 0) { %>
					<button type="submit" class="btn btn-primary" name="cmdS" value="adicionar">Adicionar</button>
				<%} else { %>
					<button type="submit" class="btn btn-primary" name="cmdS" value="salvar">Salvar</button>
				<%} %>
				<button type="submit" class="btn btn-primary" name="cmdS" value="pesquisar">Pesquisar</button>
			</div>     
        </form>
		<br>
		<br>
		<%if (listaS.size() > 0) {%>
		<div class="container">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Id</th>
						<th>Setor</th>
					</tr>
				</thead>
				<tbody>
					<% for (Setor s : listaS) { %>
					<tr>
						<td><%=s.getId() %></td>
						<td><%=s.getSetor() %></td>
						<td>	
							<div class="form-group">
								<button type="button" class="btn btn-primary" onclick="remover('<%=s.getId()%>');">Remover</button>
								<button type="button" class="btn btn-primary" onclick="editar('<%=s.getId()%>');">Editar</button>
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