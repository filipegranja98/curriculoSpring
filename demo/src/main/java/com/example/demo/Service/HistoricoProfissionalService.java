package com.example.demo.Service;

import com.example.demo.model.Curriculo;
import com.example.demo.model.HistoricoProfissional;
import com.example.demo.repository.HistoricoProfissionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HistoricoProfissionalService {

    private final HistoricoProfissionalRepository historicoProfissionalRepository;

    @Autowired
    public HistoricoProfissionalService(HistoricoProfissionalRepository historicoProfissionalRepository){this.historicoProfissionalRepository = historicoProfissionalRepository;}

    public HistoricoProfissional createHistorioProfissional(HistoricoProfissional historicoProfissional){
        return historicoProfissionalRepository.save(historicoProfissional);
    }
    public List<HistoricoProfissional> encontrarHistoricoProfissional(){
        return historicoProfissionalRepository.findAll();
    }
    public Optional historicoId(UUID id){
        return historicoProfissionalRepository.findById(id);
    }
    public Optional<HistoricoProfissional> atualizarHistoricoProfissional(UUID id, HistoricoProfissional atualizarHistoricoProfissional){
            return historicoProfissionalRepository.findById(id)
                    .map(historicoProfissional -> {
                        historicoProfissional.setCargo((atualizarHistoricoProfissional.getCargo()==null)? historicoProfissional.getCargo() : atualizarHistoricoProfissional.getCargo());
                        historicoProfissional.setDuracao((atualizarHistoricoProfissional.getDuracao()==null)? historicoProfissional.getDuracao() : atualizarHistoricoProfissional.getDuracao());
                        historicoProfissional.setEmpresa((atualizarHistoricoProfissional.getEmpresa()==null)? historicoProfissional.getEmpresa() : atualizarHistoricoProfissional.getEmpresa());
                        historicoProfissional.setCurriculo((atualizarHistoricoProfissional.getCurriculo()==null)?historicoProfissional.getCurriculo(): atualizarHistoricoProfissional.getCurriculo());
                        return historicoProfissionalRepository.save(historicoProfissional);
                    });
    }
    public Boolean deletarHistoricoProfissional(UUID id){
        try{
            historicoProfissionalRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
