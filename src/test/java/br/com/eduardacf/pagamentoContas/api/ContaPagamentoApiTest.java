package br.com.eduardacf.pagamentoContas.api;

import br.com.eduardacf.pagamentoContas.entity.ContaPagamento;
import br.com.eduardacf.pagamentoContas.service.ContaPagamentoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class ContaPagamentoApiTest {

    private ContaPagamentoService contaPagamentoService;

    private ContaPagamento contaPagamento;

    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;


    @Before
    public void init(){
        contaPagamentoService = mock(ContaPagamentoService.class);
        objectMapper = mock(ObjectMapper.class);
        contaPagamento = mock(ContaPagamento.class);
        ContaPagamentoApi contaPagamentoApi = new ContaPagamentoApi(contaPagamentoService,objectMapper);
        mockMvc = MockMvcBuilders.standaloneSetup(contaPagamentoApi).build();

    }

    @Test
    public void deveRetornar200ComContratoValido () throws Exception {
        String input = new String(Files.readAllBytes(Paths.get("src/test/resources/json/contaValida.json")));
        mockMvc.perform(post("/contas/incluirConta")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(input))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void deveRetornarBadRequestSeNaoPassarValor () throws Exception {
        String input = new String(Files.readAllBytes(Paths.get("src/test/resources/json/contaFaltandoNome.json")));
        mockMvc.perform(post("/contas/incluirConta")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(input))
                .andExpect(status().isBadRequest());

    }

    @Test
    public void deveRetornarListaDeContasCadastradas () throws Exception {
        String input = new String(Files.readAllBytes(Paths.get("src/test/resources/json/listaContasValidas.json")));
        mockMvc.perform(get("/contas/listaContas")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(input))
                .andExpect(status().is2xxSuccessful());
    }
}
