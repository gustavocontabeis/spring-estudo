package br.com.coder.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.coder.spring.entity.Tarefa;

public interface Tarefas extends JpaRepository<Tarefa, Long>{

}
