package br.com.bemol.gestao_custos.performance;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.bemol.gestao_custos.entity.Despesas;
import br.com.bemol.gestao_custos.repository.DespesaRepository;

//@Component //Comentado para não rodar novamente
public class GestaoDespesaSeeder implements CommandLineRunner {

    @Autowired
    DespesaRepository despesaRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Despesas> despesas = new ArrayList<>();
        System.out.println("Rodadndo junto com a aplicação...");
        // Aqui você pode adicionar código para popular o banco de dados, se necessário

        for(int i = 0; i <= 150000; i++){
            Despesas despesa = new Despesas();
            despesa.setDescricao("Gasto n: " + i);
            despesa.setValor(BigDecimal.valueOf(10 + (i % 50)));
            despesa.setData(LocalDate.now().minusDays(i % 30));
            despesa.setCategoria("Teste");
            despesa.setEmail("performance@bemol.com");

            despesas.add(despesa);
        }

        despesaRepository.saveAll(despesas);
        System.out.println("Finalizou a geração de seed");
    }
    
}
