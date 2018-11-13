<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="entidade.Medico, java.util.List, java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Médicos</title>
<script src="./js/bootstrap.min.js"></script>
<script src="./js/jquery-3.3.1.min.js"></script>
<link rel="stylesheet" href="./css/bootstrap.css" />
<script >
function remover( id ) {
			if (confirm("Remove o Exame com id " + id)) {
				$('#fMedico').empty();
				$('#fMedico').append('<input type="hidden" name="idMedico" value="' + id + '"/>');
				$('#fMedico').append('<input type="hidden" name="cmdM" value="remover"/>');
				$('#fMedico').submit();
			}
		}

		function editar( id ) {
			$('#fMedico').empty();
			$('#fMedico').append('<input type="hidden" name="idMedico" value="' + id + '"/>');
			$('#fMedico').append('<input type="hidden" name="cmdM" value="editar"/>');
			$('#fMedico').submit();
		}
</script>
</head>
<body>
<%@ include file="./menu.jsp" %>
<br><br>

	<section>
		<h1>Cadastro de Médico</h1>
	</section>

		<%  String msg = (String)session.getAttribute("MENSAGEM");
	   		List<Medico> lista = (List<Medico>)session.getAttribute("LISTA");
	   		if (lista == null){
		   		lista = new ArrayList<Medico>();
	   		} else {
		   		session.setAttribute("LISTA", null);
	   		}
	   		
	   		Medico medicoAtual = (Medico)session.getAttribute("MEDICO_ATUAL");
	   		if (medicoAtual == null) {
	   			medicoAtual = new Medico();
	   		} else {
	   			session.setAttribute("MEDICO_ATUAL", null);
	   		}
	   
	   		if (msg != null) {
		  		session.setAttribute("MENSAGEM", null);
		%>
			<h3 class="alert alert-danger"><%=msg%></h3>
		<% } %>
        
        <form action="./MedicoController" method="post" id="fMedico">
            <div class="form-group">
                <label for="id">ID:</label>
                <input type="text1" class="form-control" name="idMedico"  id="idMedico" value="<%=medicoAtual.getId()%>" readonly>
            </div>
            <div class="form-group">
                <label for="id">Nome:</label>
                <input type="text1" class="form-control" name="nomeMedico" id="nomeMedico" value="<%=medicoAtual.getNome()%>">
            </div>      
            
            <div class="form-group">
				<%if (medicoAtual.getId() == 0) { %>
					<button type="submit" class="btn btn-primary" name="cmdM" value="adicionar">Adicionar</button>
				<%} else { %>
					<button type="submit" class="btn btn-primary" name="cmdM" value="salvar">Salvar</button>
				<%} %>
				<button type="submit" class="btn btn-primary" name="cmdM" value="pesquisar">Pesquisar</button>
			</div>       
        </form>
        <br>
        <br>
        <%if (lista.size() > 0) {%>
        <div class="container">
	        <table class="table table-striped">
	        	<thead>
					<tr>
						<th>Id</th>
						<th>Médico</th>
					</tr>
				</thead>
	        	<tbody>
	        		<% for (Medico m : lista) { %>
	        		<tr>
	        			<td><%=m.getId() %></td>
	        			<td><%=m.getNome() %></td>
	        			<td>
							<div class="form-group">
								<button type="button" class="btn btn-primary" onclick="remover('<%=m.getId()%>');">Remover</button>
								<button type="button" class="btn btn-primary" onclick="editar('<%=m.getId()%>');">Editar</button>
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