package com.futuroDev.M02S09.controllers;

import com.futuroDev.M02S09.models.dtos.LembreteDto;
import com.futuroDev.M02S09.services.LembreteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lembretes")
public class LembreteControler {

    private final LembreteService lembreteService;

    @PostMapping
    public ResponseEntity<LembreteDto> criarLembrete(@RequestBody LembreteDto dto) {
        LembreteDto response = this.lembreteService.criarLembrete(dto);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Page<LembreteDto>> listarLembretes(@PageableDefault(size = 10) Pageable pageable) {
        Page<LembreteDto> response = this.lembreteService.listarLembretes(pageable);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LembreteDto> listarLembretesById(@PathVariable Long id) {
        LembreteDto response = this.lembreteService.listarLembretesById(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LembreteDto> atualizarLembrete(@PathVariable Long id, @RequestBody LembreteDto dto) {
        LembreteDto response = this.lembreteService.atualizarLembrete(id, dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<LembreteDto> deletarLembrete(@PathVariable Long id) {
        this.lembreteService.deletarLembrete(id);
        return ResponseEntity.noContent().build();
    }
}
