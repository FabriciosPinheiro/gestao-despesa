package br.com.bemol.gestao_custos.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.bemol.gestao_custos.entity.Despesas;

/*
Faz a comunicação com o banco de dados
 */

public interface DespesaRepository extends JpaRepository<Despesas, UUID>{

    List<Despesas> findByEmail(String email);
    List<Despesas> findByEmailAndData(String email, LocalDate data);    
}
