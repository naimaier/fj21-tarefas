package br.com.caelum.tarefas.controller;

import java.sql.Connection;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public String adiciona(@Valid Tarefa tarefa, BindingResult result) {
		
		if(result.hasFieldErrors("descricao")) {
			return "tarefa/formulario";
		}
		
		JdbcTarefaDao dao = new JdbcTarefaDao(connection);
		dao.adiciona(tarefa);
		return "tarefa/adicionada";
	}
	
	@RequestMapping("listaTarefas")
	public String lista(Model model) {
		JdbcTarefaDao dao = new JdbcTarefaDao(connection);
		model.addAttribute("tarefas", dao.getLista());
		return "tarefa/lista";
	}
	
	@RequestMapping("removeTarefa")
	public String remove(Tarefa tarefa) {
		JdbcTarefaDao dao = new JdbcTarefaDao(connection);
		dao.remove(tarefa);
		return "redirect:listaTarefas";
	}
	
	@RequestMapping("mostraTarefa")
	public String mostra(Long id, Model model) {
		JdbcTarefaDao dao = new JdbcTarefaDao(connection);
		model.addAttribute("tarefa", dao.getTarefa(id));
		return "tarefa/mostra";
	}
	
	@RequestMapping("alteraTarefa")
	public String altera(Tarefa tarefa) {
		JdbcTarefaDao dao = new JdbcTarefaDao(connection);
		dao.altera(tarefa);
		return "redirect:listaTarefas";
	}
	
	// Tudo que for retornado, será o corpo da nossa resposta.
	//Ou se nada for retornado, então a resposta será vazia porém o status HTTP será 200.
	@ResponseBody
	@RequestMapping("finalizaTarefa")
	public void finaliza(Long id) {
		JdbcTarefaDao dao = new JdbcTarefaDao(connection);
		dao.finaliza(id);
	}
}