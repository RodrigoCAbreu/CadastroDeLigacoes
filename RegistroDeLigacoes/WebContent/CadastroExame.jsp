<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="entidade.Exame, java.util.List, java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Exames</title>
<script src="./js/jquery-3.3.1.min.js"></script>
<link rel="stylesheet" href="./css/bootstrap.css" />
<script >
function remover( id ) {
			if (confirm("Remove o Exame com id " + id)) {
				$('#formExame').empty();
				$('#formExame').append('<input type="hidden" name="idExame" value="' + id + '"/>');
				$('#formExame').append('<input type="hidden" name="cmdE" value="remover"/>');
				$('#formExame').submit();
			}
		}

		function editar( id ) {
			$('#formExame').empty();
			$('#formExame').append('<input type="hidden" name="idExame" value="' + id + '"/>');
			$('#formExame').append('<input type="hidden" name="cmd" value="editar"/>');
			$('#formExame').submit();
		}
</script>
</head>
<body>
<%@ include file="./menu.jsp" %>
<br><br>

	<section>
		<h1>Cadastro de Exame</h1>
	</section>

<%
	String msgE = (String) session.getAttribute("MENSAGEM");
	List<Exame> listaE = (List<Exame>) session.getAttribute("LISTA");
	if (listaE == null) {
		listaE = new ArrayList<Exame>();
	} else {
		session.setAttribute("LISTA", null);
	}

	Exame exameAtual = (Exame)session.getAttribute("EXAME_ATUAL");
	if (exameAtual == null) {
		exameAtual = new Exame();
	} else {
		session.setAttribute("CADASTRO_ATUAL", null);
	}

	if (msgE != null) {
		session.setAttribute("MENSAGEM", null);
%>
			<h3 class="alert alert-danger"><%=msgE%></h3>
	<% } %>
    
    	<form action="./ExameController" method="post" id="fExame" name="formExame">
            <div class="form-group">
                <label for="textfield">ID:</label>
                <input type="text1" class="form-control" name="idExame"  id="idExame" value="<%=exameAtual.getId()%>" readonly>
            </div>
            <div class="form-group">
                <label for="textfield">Exame:</label>
                <input type="text1" class="form-control" name="nomeExame" id="nomeExame" value="<%=exameAtual.getExame()%>">
            </div>      
            
            <div class="form-group">
				<%if (exameAtual.getId() == 0) { %>
					<button type="submit" class="btn btn-primary" name="cmdE" value="adicionar">Adicionar</button>
				<%} else { %>
					<button type="submit" class="btn btn-primary" name="cmdE" value="salvar">Salvar</button>
				<%} %>
				<button type="submit" class="btn btn-primary" name="cmdE" value="pesquisar">Pesquisar</button>
			</div>     
      	</form>
      	<br>
        <br>
        <%if (listaE.size() > 0) {%>
      	<div class="container">
        	<table class="table table-striped">
        		<thead>
					<tr>
						<th>Id</th>
						<th>Exame</th>
					</tr>
				</thead>
        		<tbody>
        			<% for (Exame e : listaE) { %>
        			<tr>
        				<td><%=e.getExame() %></td>	
        				<td>
							<div class="form-group">
								<button type="button" class="btn btn-primary" onclick="remover('<%=e.getId()%>');">Remover</button>
								<button type="button" class="btn btn-primary" onclick="editar('<%=e.getId()%>');">Editar</button>
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