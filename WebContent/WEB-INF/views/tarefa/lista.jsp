<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Tarefas</title>
<script src="resources/js/jquery-3.3.1.min.js"></script>
<script src="resources/js/jquery-ui.js"></script>
<link href="resources/css/jquery-ui.css" rel="stylesheet">
<link href="resources/css/jquery-ui.structure.css" rel="stylesheet">
<link href="resources/css/jquery-ui.theme.css" rel="stylesheet">

</head>
<body>
	
	<a href="novaTarefa">Criar nova tarefa</a>
	<br />
	<br />

	<table>
		<tr>
			<th>Id</th>
			<th>Descricao</th>
			<th>Finalizado?</th>
			<th>Data de finalizacao</th>
		</tr>
		<c:forEach items="${tarefas}" var="tarefa">
			<tr>
				<td>${tarefa.id}</td>
				<td>${tarefa.descricao}</td>
				<c:if test="${tarefa.finalizado eq false}">
					<td id="tarefa_${tarefa.id}">
              			<a href="#" onClick="finalizaAgora(${tarefa.id})">
                  			Finaliza agora!
              			</a>
          			</td>
				</c:if>
				<c:if test="${tarefa.finalizado eq true}">
					<td>Finalizado</td>
				</c:if>
				<td><fmt:formatDate value="${tarefa.dataFinalizacao.time}"
						pattern="dd/MM/yyyy" />
				<td><a href="mostraTarefa?id=${tarefa.id}">Alterar</a></td>
				<td><a href="removeTarefa?id=${tarefa.id}">Remover</a></td>
			</tr>
		</c:forEach>
	</table>
	
	<script type="text/javascript">
      function finalizaAgora(id) {
          $.post("finalizaTarefa", {'id' : id}, function() {
              // selecionando o elemento html através da 
              // ID e alterando o HTML dele 
              $("#tarefa_"+id).html("Finalizado");
          });
      }
	</script>
  
</body>
</html>