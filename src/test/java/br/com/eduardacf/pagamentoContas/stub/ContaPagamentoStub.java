package br.com.eduardacf.pagamentoContas.stub;


import br.com.eduardacf.pagamentoContas.entity.ContaPagamento;

import java.time.LocalDate;

public class ContaPagamentoStub {
    
        public static ContaPagamento create(Long idConta, String nome, Double valorOriginal, LocalDate dataVencimento, LocalDate dataPagamento, Long diasAtraso, Double valorCorrigido) {
            ContaPagamento contaPagamentoStub = new ContaPagamento();
            contaPagamentoStub.setNome(nome);
            contaPagamentoStub.setValorCorrigido(valorCorrigido);
            contaPagamentoStub.setDataPagamento(dataPagamento);
            contaPagamentoStub.setDataVencimento(dataVencimento);
            contaPagamentoStub.setValorOriginal(valorOriginal);
            contaPagamentoStub.setDiasAtraso(diasAtraso);
          contaPagamentoStub.setIdConta(idConta);
            return contaPagamentoStub;
        }
}
