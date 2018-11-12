<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="entidade.Setor, java.util.List, java.util.ArrayList" %>
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
		<h1>Cadastro de Setor</h1>
	</section>

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
        </form>
	<br><br>
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
</body>
</html>