package com.example.mvcSQL.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity // Para bancos relacionais

public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Para bancos relacionais
    private Long id;

    @NotNull
    @Size(min = 3, max = 100)
    private String titulo;

    @Size(max = 500)
    private String descricao;

    @NotNull
    private String status; 

    private LocalDateTime dataCriacao;
    
}
