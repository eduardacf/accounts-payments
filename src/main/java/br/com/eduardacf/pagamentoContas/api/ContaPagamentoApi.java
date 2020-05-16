package br.com.eduardacf.pagamentoContas.api;

import br.com.eduardacf.pagamentoContas.api.request.ContaPagamentoRequest;
import br.com.eduardacf.pagamentoContas.entity.ContaPagamento;
import br.com.eduardacf.pagamentoContas.service.ContaPagamentoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import br.com.eduardacf.pagamentoContas.api.response.ContaPagamentoResponse;


import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@RequestMapping("/contas")
public class ContaPagamentoApi {


    private final Logger logger = LoggerFactory.getLogger(ContaPagamentoApi.class);
    private ContaPagamentoService contaPagamentoService;
    private ObjectMapper objectMapper;

    public ContaPagamentoApi(ContaPagamentoService contaPagamentoService, ObjectMapper objectMapper) {
        this.contaPagamentoService = contaPagamentoService;
        this.objectMapper = objectMapper;
    }

    @PostMapping(value = "/incluirConta")
    @ApiOperation(value = "Registra uma conta", notes = "Registra uma conta para pagamento.")
    public ResponseEntity<ContaPagamentoResponse> getRegistraConta(
            @RequestBody @Valid ContaPagamentoRequest contaPagamentoRequest) {

        logger.info("Iniciando registro da conta de nome: {}", contaPagamentoRequest.getNome());

        ContaPagamento contaPagamentoEnt = objectMapper.convertValue(contaPagamentoRequest, ContaPagamento.class);
        ContaPagamento contaPagamentoEntResponse = contaPagamentoService.incluirConta(contaPagamentoEnt);
        ContaPagamentoResponse contaPagamentoResponse = objectMapper.convertValue(contaPagamentoEntResponse, ContaPagamentoResponse.class);

        logger.info("Finalizando registro da conta de nome: {}", contaPagamentoRequest.getNome());

        return ResponseEntity.ok(contaPagamentoResponse);
    }

    @GetMapping(value = "/listaContas")
    @ApiOperation(value = "Listas as contas.", notes = "Listas todas as contas cadastradas..")
    public ResponseEntity getListaContas() {

        logger.info("Iniciando listagem de contas cadastradas.");

        List<ContaPagamento> listasContasCadastradas = contaPagamentoService.listaContas();

        logger.info("Finalizando listagem de contas cadastradas.");

        return ResponseEntity.ok(listasContasCadastradas);
    }

}
