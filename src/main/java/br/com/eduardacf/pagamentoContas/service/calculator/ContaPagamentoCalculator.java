package br.com.eduardacf.pagamentoContas.service.calculator;

import br.com.eduardacf.pagamentoContas.entity.ContaPagamento;
import br.com.eduardacf.pagamentoContas.repository.ContaPagamentoRepository;
import org.springframework.stereotype.Component;

import java.time.temporal.ChronoUnit;

@Component
public class ContaPagamentoCalculator {

    private ContaPagamentoRepository contaPagamentoRepository;

    public ContaPagamentoCalculator(ContaPagamentoRepository contaPagamentoRepository) {
        this.contaPagamentoRepository = contaPagamentoRepository;
    }

    public long getDiasAtraso(ContaPagamento contaPagamentoDto) {
        long diasAtraso = ChronoUnit.DAYS.between(contaPagamentoDto.getDataVencimento(), contaPagamentoDto.getDataPagamento());
        contaPagamentoDto.setDiasAtraso(diasAtraso);
        return diasAtraso;
    }

    public void somarTaxas(ContaPagamento contaPagamento, long diasAtraso) {
        if (diasAtraso > 0) {
            Double valorComTaxas = contaPagamento.getValorOriginal() + calcularJuros(contaPagamento.getValorOriginal(), diasAtraso) +
                    calcularMulta(contaPagamento.getValorOriginal(), diasAtraso);
            contaPagamento.setValorCorrigido(valorComTaxas);
        }
    }

    public Double calcularJuros(Double valorOriginal, Long diasAtraso) {
        Double jurosTotaisPeriodo = 0.0;
        if (diasAtraso > 0 && diasAtraso <= 3) {
            Double jurosPorDia = diasAtraso * 0.1;
            jurosTotaisPeriodo = ((valorOriginal * jurosPorDia) / 100);
            return jurosTotaisPeriodo;
        } else if (diasAtraso > 3 && diasAtraso <= 5) {
            Double jurosPorDia = diasAtraso * 0.2;
            jurosTotaisPeriodo = ((valorOriginal * jurosPorDia) / 100);
            return jurosTotaisPeriodo;
        } else {
            Double jurosPorDia = diasAtraso * 0.3;
            jurosTotaisPeriodo = ((valorOriginal * jurosPorDia) / 100);
            return jurosTotaisPeriodo;
        }
    }

    public Double calcularMulta(Double valorOriginal, Long diasAtraso) {
        Double multaTotalPeriodo = 0.0;
        if (diasAtraso > 0 && diasAtraso <= 3) {
            multaTotalPeriodo = ((valorOriginal * 2) / 100);
            return multaTotalPeriodo;
        } else if (diasAtraso > 3 && diasAtraso <= 5) {
            multaTotalPeriodo = ((valorOriginal * 3) / 100);
            return multaTotalPeriodo;
        } else {
            multaTotalPeriodo = ((valorOriginal * 5) / 100);
            return multaTotalPeriodo;
        }
    }
}




