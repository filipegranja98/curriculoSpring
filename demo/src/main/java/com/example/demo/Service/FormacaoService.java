package com.example.demo.Service;

import com.example.demo.model.Formacao;
import com.example.demo.repository.CurriculoRepository;
import com.example.demo.repository.FormacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FormacaoService {
        private final FormacaoRepository formacaoRepository;

        @Autowired
        public FormacaoService(FormacaoRepository formacaoRepository){
            this.formacaoRepository = formacaoRepository;
        }

        public Formacao criarFormacao(Formacao formacao){
            return formacaoRepository.save(formacao);
        }

        public List<Formacao> encontrarFormacoes(){
            return formacaoRepository.findAll();
        }

        public Optional encontrarFormacao(UUID id){
            return formacaoRepository.findById(id);
        }

        public Optional atualizarFormacao(UUID id, Formacao atualizarFormacao){
            return formacaoRepository.findById(id)
            .map(formacao -> {
                formacao.setNomeFormacao((atualizarFormacao.getNomeFormacao()==null)?formacao.getNomeFormacao(): atualizarFormacao.getNomeFormacao());
                formacao.setDuracao((atualizarFormacao.getDuracao()== null)?formacao.getDuracao():atualizarFormacao.getDuracao());
                return formacaoRepository.save(formacao);
            });
        }

        public boolean deletarFormacao(UUID id){
            try{
                formacaoRepository.deleteById(id);
                return true;
            }catch (Exception e){
                return  false;
            }
        }

}
