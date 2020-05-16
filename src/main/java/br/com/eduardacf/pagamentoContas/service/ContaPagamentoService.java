package br.com.eduardacf.pagamentoContas.service;

import br.com.eduardacf.pagamentoContas.entity.ContaPagamento;
import br.com.eduardacf.pagamentoContas.repository.ContaPagamentoRepository;
import br.com.eduardacf.pagamentoContas.service.calculator.ContaPagamentoCalculator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContaPagamentoService {

    private ContaPagamentoRepository contaPagamentoRepository;
    private ContaPagamentoCalculator contaPagamentoCalculator;

    public ContaPagamentoService(ContaPagamentoRepository contaPagamentoRepository, ContaPagamentoCalculator contaPagamentoCalculator) {
        this.contaPagamentoRepository = contaPagamentoRepository;
        this.contaPagamentoCalculator = contaPagamentoCalculator;
    }

    public ContaPagamento incluirConta(ContaPagamento contaPagamento) {
        long diasAtraso = contaPagamentoCalculator.getDiasAtraso(contaPagamento);
        contaPagamentoCalculator.somarTaxas(contaPagamento, diasAtraso);
        contaPagamentoRepository.save(contaPagamento);
        return contaPagamento;
    }

    public List<ContaPagamento> listaContas() {
        return contaPagamentoRepository.findAll()
                .stream()
                .collect(Collectors.toList());

    }
}




