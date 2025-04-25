package com.example.mvcNOSQL.repository;

import com.example.mvcNOSQL.model.Tarefa;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TarefaRepository extends MongoRepository<Tarefa, String> {}