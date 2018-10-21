<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Registro de Ligações</title>
	<link rel="stylesheet" href="./css/bootstrap.css" />
	<script src="./js/bootstrap.min.js"></script>
</head>
<body>
	
	<section>
		<h1>IPGG - Registro de ligações</h1>
	</section>
		

	<form method="post" class="form-inline">
	  
		<label for="textfield" class="margemR">Usuário:</label>
		<input type="text" class="margemB" name="usuario" id="usuario" readonly>
        
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
        
        <select class="selectMenu" name="nomeProfissional" id="nomeProfissional">
  			<option selected>Selecione o nome do profissional</option>
            <option>Dr. Drauzio varella</option>
            <option></option>
        </select>
        
        <br>
        
        <select class="selectMenu" name="motivoLigacao" id="motivoLigacao">
  			<option selected>Selecione o motivo da ligação</option>
            <option>Alteração data da consulta</option>
            <option></option>
        </select>
        
        <br>
        
        <label for="tel" class="margemR">Telefone:</label>
  		<input type="tel" class="margemB" name="tel1" id="tel1">
        
        <label for="textfield" class="margemR">Contato:</label>
		<input type="text" class="margemB" name="txtcontato1" id="txtcontato1">
        
        <select class="margemR" name="situacao1" id="situacao1">
        	<option selected>Situação</option>
            <option>Informado</option>
            <option>Não atende</option>
  		</select>
        
        <br>
        
        <label for="tel" class="margemR">Telefone:</label>
  		<input type="tel" class="margemB" name="tel2" id="tel2">
        
        <label for="textfield" class="margemR">Contato:</label>
		<input type="text" class="margemB" name="contato2" id="contato2">
        
        <select class="margemR" name="situacao2" id="situacao2">
  			<option selected>Situação</option>
            <option>Informado</option>
            <option>Não atende</option>
        </select>
        
        <br>
        
        <label for="tel" class="margemR">Telefone:</label>
  		<input type="tel" class="margemB" name="tel3" id="tel3">
        
        <label for="textfield" class="margemR">Contato:</label>
		<input type="text" class="margemB" name="contato3" id="contato3">
        
        <select class="margemR" name="situacao3" id="situacao3">
  			<option selected>Situação</option>
            <option>Informado</option>
            <option>Não atende</option>
        </select>
        
        <br>
        
        <label for="tel" class="margemR">Telefone:</label>
  		<input type="tel" class="margemB" name="tel4" id="tel4">
        
        <label for="textfield" class="margemR">Contato:</label>
		<input type="text" class="margemB" name="contato4" id="contato4">
        
        <select class="margemR" name="situacao4" id="situacao4">
  			<option selected>Situação</option>
            <option>Informado</option>
            <option>Não atende</option>
        </select>
        
        <br>
        
        <label for="textfield" class="margemR">Observações:</label>
		<input type="text" name="observacoes" id="observacoes">
        
        <br><br>
        
        <input class="btn btn-primary" type="submit" value="Adicionar" name="cmd" id="btnEnviar">     <input class="btn btn-primary" type="reset" value="Pesquisar" name="cmd" id="btnPesquisar"> 
        
    </form>

</body>
</html>