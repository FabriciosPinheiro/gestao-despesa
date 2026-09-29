package br.com.bemol.gestao_custos.useCases;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bemol.gestao_custos.entity.Despesas;
import br.com.bemol.gestao_custos.repository.DespesaRepository;

@Service 
public class BuscarDespesaUSeCase {

    @Autowired
    private DespesaRepository despesaRepository;

    public List<Despesas> execute(String email, LocalDate data){
        
        List<Despesas> despesas;
        if(data != null){
            despesas = despesaRepository.findByEmailAndData(email, data);
        }else{
            despesas = despesaRepository.findByEmail(email);
        }
        return despesas;
    }
    
}
