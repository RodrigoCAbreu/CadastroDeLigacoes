<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="entidade.Medico, java.util.List, java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Exames</title>
<link rel="stylesheet" href="./css/bootstrap.css" />
<script src="./js/jquery-3.3.1.min.js"></script>
<script src="js/bootstrap.js"></script>
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
        </form>
        <br>
        <br>
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
</body>
</html>