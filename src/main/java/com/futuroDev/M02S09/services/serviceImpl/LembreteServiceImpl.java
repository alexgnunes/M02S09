package com.futuroDev.M02S09.services.serviceImpl;

import com.futuroDev.M02S09.exceptions.ProductNotFoundException;
import com.futuroDev.M02S09.models.Lembrete;
import com.futuroDev.M02S09.models.dtos.LembreteDto;
import com.futuroDev.M02S09.repositories.LembreteRepository;
import com.futuroDev.M02S09.services.LembreteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
@RequiredArgsConstructor
public class LembreteServiceImpl implements LembreteService {

    private final LembreteRepository lembreteRepository;

    @Override
    public LembreteDto criarLembrete(LembreteDto dto) {
        Lembrete lembrete = new Lembrete(dto);
        return new LembreteDto( this.lembreteRepository.save(lembrete));
    }

    @Override
    public Page<LembreteDto> listarLembretes(Pageable pageable) {
        return this.lembreteRepository.findAll(pageable).map(LembreteDto::new);
    }

    @Override
    public LembreteDto listarLembretesById(Long id) {
        Lembrete lembrete = this.lembreteRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
        return new LembreteDto(lembrete);
    }

    @Override
    public LembreteDto atualizarLembrete(Long id, LembreteDto dto) {
        Lembrete lembrete = this.lembreteRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
        lembrete.copyProperties(dto);
        return new LembreteDto(this.lembreteRepository.save(lembrete));

    }

    @Override
    public void deletarLembrete(Long id) {
        Lembrete lembrete = this.lembreteRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
        this.lembreteRepository.delete(lembrete);
    }
}
