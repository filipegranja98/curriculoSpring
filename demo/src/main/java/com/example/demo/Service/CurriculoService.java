package com.example.demo.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.model.Curriculo;
import com.example.demo.repository.CurriculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurriculoService {
    private final CurriculoRepository curriculoRepository;

    @Autowired
    public CurriculoService(CurriculoRepository curriculoRepository){
        this.curriculoRepository = curriculoRepository;
    }

    public Curriculo createCurriculo(Curriculo curriculo){
        return curriculoRepository.save(curriculo);
    }
    public List<Curriculo> encontrarCurriculo(){
            return curriculoRepository.findAll();
    }
    public Optional<Curriculo> curriculoId(UUID id){
        return curriculoRepository.findById(id);
    }
    public Curriculo atualizarCurriculo(Curriculo curriculo, UUID id){
        return curriculo;
    }
    public Boolean deletarCurriculo(UUID id){
        try{
            curriculoRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
