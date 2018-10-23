<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="entidade.Cadastro, java.util.List, java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Registro de Ligação</title>
	<link rel="stylesheet" href="./css/bootstrap.css" />
	<script src="./js/bootstrap.min.js"></script>
</head>
<body>
	
	<section>
		<h1>IPGG - Registro de ligações</h1>
	</section>
	
	<%  String msg = (String)session.getAttribute("MENSAGEM");
	   List<Cadastro> lista = (List<Cadastro>)session.getAttribute("LISTA");
	   if (lista == null){
		   lista = new ArrayList<Cadastro>();
	   } else {
		   session.setAttribute("LISTA", null);
	   }
	   
	   if (msg != null) {
		   session.setAttribute("MENSAGEM", null);
	%>
			<h3 class="alert alert-danger"><%=msg%></h3>
	<% } %>
		

	<form action="./CadastroController" method="post" class="form-inline">
	  
		<label for="textfield" class="margemR">Usuário:</label>
		<input type="text" class="margemB" name="usuario" id="usuario">
        
        <label for="textfield" class="margemR">Data:</label>
		<input type="date" class="margemB" name="data" id="data">
        
        <label for="time" class="margemR">Hora:</label>
      	<input type="time" class="margemB" name="hora" id="hora">
                
        <label for="select" class="margemR">Setor:</label>
  		<select name="setor" class="margemB" name="setor" id="setor">
        	<option selected>Escolha o setor</option>
            <option>Informática</option>
            <option>NES</option>
            <option>SAME</option>
  		</select>
        
        <br><br><br>
        
            <label for="textfield" class="margemR">Código:</label>
            <input type="text" class="margemB" name="codigo" id="codigo">
            <input type=image src="images/pesquisar.png" name="btnCodigo" id="btnCodigo">
        
        
            <label for="textfield" class="margemR">Prontuário:</label>
            <input type="text" class="margemB" name="prontuario" id="prontuario">
            <input type=image src="images/pesquisar.png" name="btnProntuario" id="btnProntuario">
        <br>
        
        <label for="textfield" class="margemR">Paciente:</label>
		<input type="text" class="margemB" name="paciente" id="paciente">
        
        <br>
        
  		<select class="selectMenu" name="consulta" id="consulta">
  			<option selected>Seleciona a consulta ou exame</option>
            <option>Geriatria</option>
            <option></option>
        </select>
        
        <select class="selectMenu" name="profissional" id="profissional">
  			<option selected>Selecione o nome do profissional</option>
            <option>Dr. Drauzio varella</option>
            <option></option>
        </select>
        
        <br>
        
        <select class="selectMenu" name="motivo" id="motivo">
  			<option selected>Selecione o motivo da ligação</option>
            <option>Alteração data da consulta</option>
            <option></option>
        </select>
        
        <br>
        
        <label for="tel" class="margemR">Telefone:</label>
  		<input type="tel" class="margemB" name="telefone1" id="telefone1">
        
        <label for="textfield" class="margemR">Contato:</label>
		<input type="text" class="margemB" name="contato1" id="contato1">
        
        <select class="margemR" name="situacao1" id="situacao1">
        	<option selected>Situação</option>
            <option>Informado</option>
            <option>Não atende</option>
  		</select>
        
        <br>
        
        <label for="tel" class="margemR">Telefone:</label>
  		<input type="tel" class="margemB" name="telefone2" id="telefone2">
        
        <label for="textfield" class="margemR">Contato:</label>
		<input type="text" class="margemB" name="contato2" id="contato2">
        
        <select class="margemR" name="situacao2" id="situacao2">
  			<option selected>Situação</option>
            <option>Informado</option>
            <option>Não atende</option>
        </select>
        
        <br>
        
        <label for="tel" class="margemR">Telefone:</label>
  		<input type="tel" class="margemB" name="telefone3" id="telefone3">
        
        <label for="textfield" class="margemR">Contato:</label>
		<input type="text" class="margemB" name="contato3" id="contato3">
        
        <select class="margemR" name="situacao3" id="situacao3">
  			<option selected>Situação</option>
            <option>Informado</option>
            <option>Não atende</option>
        </select>
        
        <br>
        
        <label for="tel" class="margemR">Telefone:</label>
  		<input type="tel" class="margemB" name="telefone4" id="telefone4">
        
        <label for="textfield" class="margemR">Contato:</label>
		<input type="text" class="margemB" name="contato4" id="contato4">
        
        <select class="margemR" name="situacao4" id="situacao4">
  			<option selected>Situação</option>
            <option>Informado</option>
            <option>Não atende</option>
        </select>
        
        <br>
        
        <label for="textfield" class="margemR">Observações:</label>
		<input type="text" name="obser" id="obser">
        
        <br><br>
        
        <button class="btn btn-primary" type="submit" value="adicionar" name="cmd" id="btnEnviar">Adicionar</button>     <button class="btn btn-primary" type="submit" value="pesquisar" name="cmd">Pesquisar</button> 
        
        <div class="container">
        	<table class="table table-striped">
        		<tbody>
        			<% for (Cadastro c : lista) { %>
        			<tr>
        				<td><%=c.getData() %></td>
        				<td><%=c.getHora() %></td>
        				<td><%=c.getSetor() %></td>
        				<td><%=c.getCodigo() %></td>
        				<td><%=c.getProntuario() %></td>
        				<td><%=c.getPaciente() %></td>
        				<td><%=c.getConsulta() %></td>
        				<td><%=c.getProfissional() %></td>
        				<td><%=c.getMotivo() %></td>
        				<td><%=c.getTelefone1() %></td>
        				<td><%=c.getContato1() %></td>
        				<td><%=c.getSituacao1() %></td>
        				<td><%=c.getTelefone2() %></td>
        				<td><%=c.getContato2() %></td>
        				<td><%=c.getSituacao2() %></td>
        				<td><%=c.getTelefone3() %></td>
        				<td><%=c.getContato3() %></td>
        				<td><%=c.getSituacao3() %></td>
        				<td><%=c.getTelefone4() %></td>
        				<td><%=c.getContato4() %></td>
        				<td><%=c.getSituacao4() %></td>
        				<td><%=c.getObser() %></td>
        			</tr>
        			<% } %>
        		</tbody>
        	</table>
        </div>
    </form>
</body>
</html>