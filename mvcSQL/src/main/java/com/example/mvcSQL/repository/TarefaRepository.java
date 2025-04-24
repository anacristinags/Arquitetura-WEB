package com.example.mvcSQL.repository;

import com.example.mvcSQL.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {}