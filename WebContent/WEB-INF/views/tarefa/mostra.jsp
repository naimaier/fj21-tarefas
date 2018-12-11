<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alterar tarefa</title>
<script src="resources/js/jquery-3.3.1.min.js"></script>
<script src="resources/js/jquery-ui.js"></script>
<link href="resources/css/jquery-ui.css" rel="stylesheet">
<link href="resources/css/jquery-ui.structure.css" rel="stylesheet">
<link href="resources/css/jquery-ui.theme.css" rel="stylesheet">
<link type="text/css" href="resources/css/tarefas.css" rel="stylesheet"/>
</head>
<body>
	<fmt:formatDate value="${tarefa.dataFinalizacao.time}" pattern="dd/MM/yyyy" var="formattedDate"/>
	<h3>Alterar tarefa - ${tarefa.id}</h3>
	
	<form action="alteraTarefa" method="post">
	<input type="hidden" name="id" value="${tarefa.id}"/>
	Descrição:<br/>
	<textarea name="descricao" cols="100" rows="5">${tarefa.descricao}</textarea>
	<br/>
	
	Finalizado? <input type="checkbox" name="finalizado" value="true" ${tarefa.finalizado? 'checked' : ''}/><br/>
	Data de finalização: <br/>
	<caelum:campoData id="dataFinalizacao" value="${formattedDate}"/>
	<br/>
	
	<input type="submit" value="Alterar"/>
	</form>
</body>
</html>