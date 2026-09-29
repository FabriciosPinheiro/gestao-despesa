package br.com.bemol.gestao_custos.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.bemol.gestao_custos.entity.Despesas;
import br.com.bemol.gestao_custos.useCases.BuscarDespesaUSeCase;
import br.com.bemol.gestao_custos.useCases.CadastroDespesaUseCase;

@RequestMapping("/gestaoDespesa")
@RestController()
public class GestaoDespesaController {

    /*
    - Cadastro de despesas
    - Criar tabela no banco de dados
    - Criar entidade
    */

    //Instancia da classe CadastroDespesaUseCase para ser utilizada no controller
    @Autowired
    CadastroDespesaUseCase cadastroDespesaUseCase;

    @Autowired 
    BuscarDespesaUSeCase buscarDespesaUSeCase;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody  Despesas despesa) {

        try{

            var result = cadastroDespesaUseCase.execute(despesa);
            return ResponseEntity.ok(result);

        }catch(IllegalArgumentException e){
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }
    
    @GetMapping ("/{email}")
    public List<Despesas> findByEmailAndDate(@PathVariable String email, @RequestParam(required = false) LocalDate data) {
        
        return buscarDespesaUSeCase.execute(email, data);
    }

}
