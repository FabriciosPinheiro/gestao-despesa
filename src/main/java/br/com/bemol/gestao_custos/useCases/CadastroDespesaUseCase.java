package br.com.bemol.gestao_custos.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bemol.gestao_custos.entity.Despesas;
import br.com.bemol.gestao_custos.repository.DespesaRepository;

@Service
public class CadastroDespesaUseCase { //SOLID - Single Responsibility Principle

    @Autowired  // Injeção de dependência
    private DespesaRepository despesaRepository;

    public Despesas execute(Despesas despesa) {

        if(despesa.getCategoria() == null || despesa.getData() == null || despesa.getDescricao() == null || despesa.getEmail() == null || despesa.getValor() == null){
            throw new IllegalArgumentException("Todos os campos devem ser preenchidos");
        }

        despesa = despesaRepository.save(despesa); // Salva a despesa
        return despesa;
    }
    
}
