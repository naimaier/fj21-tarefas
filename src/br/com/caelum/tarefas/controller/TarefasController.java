package br.com.caelum.tarefas.controller;

import java.sql.Connection;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.tarefas.dao.JdbcTarefaDao;
import br.com.caelum.tarefas.jdbc.ConnectionFactory;
import br.com.caelum.tarefas.model.Tarefa;

@Controller
public class TarefasController {
	Connection connection = new ConnectionFactory().getConnection();
	
	@RequestMapping("novaTarefa")
	public String form() {
		return "tarefa/formulario";
	}
	
	@RequestMapping("adicionaTarefa")
	public String adiciona(Tarefa tarefa) {
		JdbcTarefaDao dao = new JdbcTarefaDao(connection);
		dao.adiciona(tarefa);
		return "tarefa/adicionada";
	}
}