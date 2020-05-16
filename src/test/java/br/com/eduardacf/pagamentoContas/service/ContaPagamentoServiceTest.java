package br.com.eduardacf.pagamentoContas.service;

import br.com.eduardacf.pagamentoContas.entity.ContaPagamento;
import br.com.eduardacf.pagamentoContas.repository.ContaPagamentoRepository;
import br.com.eduardacf.pagamentoContas.service.calculator.ContaPagamentoCalculator;
import br.com.eduardacf.pagamentoContas.stub.ContaPagamentoStub;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ContaPagamentoServiceTest {

    private ContaPagamentoRepository contaPagamentoRepository;
    private ContaPagamentoCalculator contaPagamentoCalculator;

    @InjectMocks
    private ContaPagamentoService contaPagamentoService;

    @Before
    public void init(){
        contaPagamentoRepository = mock(ContaPagamentoRepository.class);
        contaPagamentoCalculator = mock(ContaPagamentoCalculator.class);
    }

    private final String nome = "Eduarda";
    private final Double valorOriginal = 100.00;
    private final LocalDate dataVencimento = LocalDate.of(2020, 04, 01);
    private final LocalDate dataPagamento = LocalDate.of(2020, 04, 06);
    private final Long diasAtraso = 5L;
    private final Double valorCorrigido = 104.2;

    @Test
    public void deveSalvarConta () {
        ContaPagamento expected = ContaPagamentoStub.create(1L,nome,valorOriginal,dataVencimento,dataPagamento,diasAtraso,valorCorrigido);
        when(contaPagamentoCalculator.getDiasAtraso(any())).thenReturn(5L);
       when(contaPagamentoRepository.save(expected)).thenReturn(expected);
    }

    @Test
    public void deveRetornarListaDeContas() {
        List<ContaPagamento> expected = Arrays.asList(ContaPagamentoStub.create(1L,nome,valorOriginal,dataVencimento,dataPagamento,diasAtraso,valorCorrigido));
        when(contaPagamentoRepository.findAll()).thenReturn(expected);
        assertEquals(expected.size(),1L);
    }
}
