<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" href="resources/css/tarefas.css" rel="stylesheet"/>
</head>
<body>
	<h3>Adicionar tarefas</h3>
	<form:errors path="tarefa.descricao"/>
	<form action="adicionaTarefa" method="post">
		Descri��o: <br />
		<textarea name="descricao" rows="5" cols="100"></textarea>
		<input type="submit" value="Adicionar">
	</form>
</body>
</html>