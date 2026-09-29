package br.com.bemol.gestao_custos.performance;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bemol.gestao_custos.entity.Despesas;
import br.com.bemol.gestao_custos.repository.DespesaRepository;

@RequestMapping("/gestao/performance")
@RestController 
public class GestaoDespesaPerformance {

    @Autowired 
    DespesaRepository repository;

    @GetMapping("/sem-paginacao")
    public ResponseEntity<List<Despesas>> listarSemPaginacao(){

        long inicio = System.currentTimeMillis();
        var despesas = repository.findAll();
        long fim = System.currentTimeMillis();
        System.out.println("Tempo de execução sem paginação: " + (fim - inicio) + " ms");
        return ResponseEntity.ok(despesas);

    }

    @GetMapping("/com-paginacao") //http://localhost:8080/gestao/performance/com-paginacao?page=1&size=10
     public ResponseEntity<Page<Despesas>> listarComPaginacao(Pageable pageable){

        StopWatch stopwatch = new StopWatch();
        stopwatch.start();

        var despesas = repository.findAll(pageable);
        stopwatch.stop();

        System.out.println("Tempo de execução com paginação: " + stopwatch.getTotalTimeMillis() + " ms");
        return ResponseEntity.ok(despesas);

    }
    
}
