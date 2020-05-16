package br.com.eduardacf.pagamentoContas.service.calculator;

import br.com.eduardacf.pagamentoContas.entity.ContaPagamento;
import br.com.eduardacf.pagamentoContas.repository.ContaPagamentoRepository;
import br.com.eduardacf.pagamentoContas.stub.ContaPagamentoStub;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class ContaPagamentoCalculatorTest {

    @Mock
    private ContaPagamentoRepository contaPagamentoRepository;

    @InjectMocks
    private ContaPagamentoCalculator contaPagamentoCalculator;

    private final String nome = "Eduarda";
    private final Double valorOriginal = 100.00;
    private final LocalDate dataVencimento = LocalDate.of(2020, 04, 01);
    private final LocalDate dataPagamento = LocalDate.of(2020, 04, 06);
    private final Long diasAtraso = 5L;
    private final Double valorCorrigido = 104.2;

    @Test
    @Ignore
    public void deveRetornarDiasAtraso() {
        ContaPagamento expected = ContaPagamentoStub.create(1L, nome, valorOriginal, dataVencimento, dataPagamento, diasAtraso, valorCorrigido);
        contaPagamentoCalculator.getDiasAtraso(expected);
        assertEquals(expected.getDiasAtraso(), java.util.Optional.of(5L));

    }

    @Test
    public void deveRetornarJuros() {
        Double jurosTotaisPeriodo = 0.0;
        Double jurosTotalCalculado = contaPagamentoCalculator.calcularJuros(70.0, 5L);
        assertTrue(jurosTotalCalculado > jurosTotaisPeriodo);
    }

    @Test
    public void deveRetornarMulta() {
        Double multaTotalPeriodo = 0.0;
        Double multaTotalCalculada = contaPagamentoCalculator.calcularMulta(70.0, 5L);
        assertTrue(multaTotalCalculada > multaTotalPeriodo);
    }
}
