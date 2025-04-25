package com.example.mvcNOSQL.service;

import com.example.mvcNOSQL.model.Tarefa;
import com.example.mvcNOSQL.repository.TarefaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository TarefaRepository;

    public List<Tarefa> listar() {
        return TarefaRepository.findAll();
    }

    public Optional<Tarefa> findById(String id) {
        return TarefaRepository.findById(id);
    }

    public Tarefa criar(@Valid Tarefa tarefa) {
        tarefa.setDataCriacao(java.time.LocalDateTime.now());
        return TarefaRepository.save(tarefa);
    }

    public Tarefa atualizar(String id, @Valid Tarefa tarefaAtualizada) {
        Optional<Tarefa> tarefaOptional = TarefaRepository.findById(id);
        if (tarefaOptional.isEmpty()) {
            throw new RuntimeException("Tarefa não encontrada!");
        }
        Tarefa tarefa = tarefaOptional.get();
        tarefa.setTitulo(tarefaAtualizada.getTitulo());
        tarefa.setDescricao(tarefaAtualizada.getDescricao());
        tarefa.setStatus(tarefaAtualizada.getStatus());
        return TarefaRepository.save(tarefa);
    }

    public void excluir(String id) {
        TarefaRepository.deleteById(id);
    }
    
}
