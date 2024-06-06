package com.example.demo.controller;

import com.example.demo.Service.HistoricoProfissionalService;
import com.example.demo.model.HistoricoProfissional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("historicoprofissional")
public class HistoricoProfissionalController {
    private final HistoricoProfissionalService historicoProfissionalService;

    @Autowired
    public HistoricoProfissionalController(HistoricoProfissionalService historicoProfissionalService){
        this.historicoProfissionalService = historicoProfissionalService;
    }

    @PostMapping
    public HistoricoProfissional criarHistoricoProfissional(@RequestBody HistoricoProfissional historicoProfissional){
        return historicoProfissionalService.createHistorioProfissional(historicoProfissional);
    }

    @GetMapping
    public List<HistoricoProfissional> getHistoricosProfissional(){
        return historicoProfissionalService.encontrarHistoricoProfissional();
    }

    @GetMapping("/{id}")
    public Optional<HistoricoProfissional> getHistorico(@PathVariable UUID id){
        return historicoProfissionalService.historicoId(id);
    }
    @PutMapping("/{id}")
    public Optional<HistoricoProfissional> atualizarHistorico(@PathVariable UUID id, @RequestBody HistoricoProfissional historicoProfissional){
        return historicoProfissionalService.atualizarHistoricoProfissional(id,historicoProfissional);
    }
    @DeleteMapping("/{id}")
    public boolean deletaHistoricoProfissional(@PathVariable UUID id){
        return historicoProfissionalService.deletarHistoricoProfissional(id);
    }
}
