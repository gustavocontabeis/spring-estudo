package br.com.coder.spring.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.ModelAndView;

import br.com.coder.spring.entity.Tarefa;
import br.com.coder.spring.entity.Tipo;
import br.com.coder.spring.repository.Tarefas;

@Controller
public class TarefaController {

	@Autowired
	private Tarefas tarefas;

	@GetMapping("tarefa/novo")
	public ModelAndView novo(Tarefa obj) {
		ModelAndView mv = new ModelAndView("tarefas/form");
		mv.addObject("obj", obj);
		mv.addObject("tipos", Tipo.values());
		return mv;
	}

	@GetMapping("tarefa/listar")
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView("tarefas/list");
		List<Tarefa> list = new ArrayList<>();
		list.add(new Tarefa(1L, "Lavar Roupa", Tipo.MELHORIA, new BigDecimal(5.57f)));
		list.add(new Tarefa(2L, "Passar Roupa", Tipo.BUG, new BigDecimal(1.23f)));
		list.add(new Tarefa(3L, "Organizar gavetas", Tipo.MELHORIA, new BigDecimal(4.55)));
		list.add(new Tarefa(4L, "Varrer garagem", Tipo.MELHORIA, new BigDecimal(1.23f)));
		mv.addObject("list", list);
		return mv;
	}

	@PostMapping("tarefa/novo2")
	public String save2(@Valid Tarefa obj) {
		tarefas.save(obj);
		System.out.println(obj.getId());
		return "redirect:novo";
	}

	@PostMapping("tarefa/novo")
	public ModelAndView save(@Valid Tarefa obj, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println("erro!!!");
			return novo(obj);
		}
		tarefas.save(obj);
		System.out.println(obj.getId());
		return new ModelAndView("redirect:novo");
	}

}
