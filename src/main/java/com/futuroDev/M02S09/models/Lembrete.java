package com.futuroDev.M02S09.models;

import com.futuroDev.M02S09.models.dtos.LembreteDto;
import com.futuroDev.M02S09.models.enuns.PrioridadeEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Getter
@NoArgsConstructor
public class Lembrete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String titulo;
    private String descricao;
    private LocalDateTime data;
    @Enumerated(EnumType.STRING)
    private PrioridadeEnum prioridade;

    public Lembrete (LembreteDto dto) {
        this.titulo = dto.titulo();
        this.descricao = dto.descricao();
        this.data = dto.data();
        this.prioridade = dto.prioridade();
    }

    public void copyProperties(LembreteDto dto) {
        this.titulo = dto.titulo() != null ? dto.titulo() : this.titulo;
        this.descricao = dto.descricao() != null ? dto.descricao() : this.descricao;
        this.data = dto.data() != null ? dto.data() : this.data;
        this.prioridade = dto.prioridade() != null ? dto.prioridade() : this.prioridade;
    }
}
