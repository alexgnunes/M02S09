package com.futuroDev.M02S09.models.dtos;

import com.futuroDev.M02S09.models.Lembrete;
import com.futuroDev.M02S09.models.enuns.PrioridadeEnum;

import java.time.LocalDateTime;

public record LembreteDto (Long Id,
                           String titulo,
                           String descricao,
                           LocalDateTime data,
                           PrioridadeEnum prioridade) {

    public LembreteDto(Lembrete lembrete) {
        this(lembrete.getId(),lembrete.getTitulo(), lembrete.getDescricao(), lembrete.getData(), lembrete.getPrioridade());
    }
}
