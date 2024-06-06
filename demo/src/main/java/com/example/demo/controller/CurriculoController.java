package com.example.demo.controller;

import com.example.demo.Service.CurriculoService;
import com.example.demo.model.Curriculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("curriculos")
public class CurriculoController {
    private CurriculoService curriculoService;

    @Autowired
    public CurriculoController(CurriculoService curriculoService){

        this.curriculoService = curriculoService;
    }

    @PostMapping
    public Curriculo criarCurriculo(@RequestBody  Curriculo curriculo){
        return curriculoService.createCurriculo(curriculo);
    }
    @GetMapping
    public List<Curriculo> getCurriculos(){
        return curriculoService.encontrarCurriculo();
    }
    @GetMapping("/{id}")
    public Optional<Curriculo> getCurriculo(@PathVariable UUID id){
        return curriculoService.curriculoId(id);
    }
    @PutMapping("/{id}")
    public Optional<Curriculo> atualizarCurriculo(@PathVariable UUID id, @RequestBody Curriculo curriculo){
        return curriculoService.atualizarCurriculo(id,curriculo);
    }
    @DeleteMapping("/{id}")
    public boolean deletarCurriculo(@PathVariable UUID id){
        return curriculoService.deletarCurriculo(id);
    }

}
