package com.futuroDev.M02S09.services;

import com.futuroDev.M02S09.models.dtos.LembreteDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LembreteService {

    LembreteDto criarLembrete(LembreteDto dto);

    Page<LembreteDto> listarLembretes(Pageable pageable);

    LembreteDto listarLembretesById(Long id);

    LembreteDto atualizarLembrete(Long id, LembreteDto dto);

    void deletarLembrete(Long id);
}
