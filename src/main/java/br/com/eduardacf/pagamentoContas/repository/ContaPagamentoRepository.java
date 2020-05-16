package br.com.eduardacf.pagamentoContas.repository;

import br.com.eduardacf.pagamentoContas.entity.ContaPagamento;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@ComponentScan("br.com.desafio.pagamentosContas.repository")
@Repository
public interface ContaPagamentoRepository extends JpaRepository<ContaPagamento, Long> {

}
