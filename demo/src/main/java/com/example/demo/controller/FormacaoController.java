package com.example.demo.controller;

import com.example.demo.Service.CurriculoService;
import com.example.demo.Service.FormacaoService;
import com.example.demo.model.Formacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/formacoes")
public class FormacaoController {
    private final FormacaoService formacaoService;

    @Autowired
    public FormacaoController(FormacaoService formacaoService){
            this.formacaoService = formacaoService;
    }
    @PostMapping
    public Formacao criarFormacao(@RequestBody Formacao formacao){
        return formacaoService.criarFormacao(formacao);
    }

    @GetMapping
    public List<Formacao> getFormacoes(){
        return formacaoService.encontrarFormacoes();
    }

    @GetMapping("/{id}")
    public Optional<Formacao> getFormacao(@PathVariable UUID id){
        return formacaoService.encontrarFormacao(id);
    }

    @PutMapping("/{id}")
    public Optional<Formacao> atualizarFormacao(@PathVariable UUID id,@RequestBody Formacao formacao){
        return formacaoService.atualizarFormacao(id,formacao);
    }
    @DeleteMapping("/{id}")
    public boolean deletaFormacao(@PathVariable UUID id){
        return formacaoService.deletarFormacao(id);
    }


}
