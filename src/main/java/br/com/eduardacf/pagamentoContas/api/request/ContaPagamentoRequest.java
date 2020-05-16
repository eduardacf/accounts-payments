package br.com.eduardacf.pagamentoContas.api.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class ContaPagamentoRequest {

    @ApiModelProperty(value = "Nome da Conta")
    @NotNull(message = "Campo nome não pode ser nulo")
    @NotEmpty(message = "Campo nome não pode ser vazio")
    private String nome;

    @ApiModelProperty(value = "Valor da Conta")
    @NotNull(message = "Campo valorOriginal não pode ser nulo")
    @Min(0)
    private Double valorOriginal;

    @ApiModelProperty(value = "Data Vencimento da Conta.")
    @NotNull(message = "Campo Data Vencimento não pode ser nulo")
    private LocalDate dataVencimento;

    @ApiModelProperty(value = "Data do pagamento da Conta.")
    @NotNull(message = "Campo Data Pagamento não pode ser nulo")
    private LocalDate dataPagamento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValorOriginal() {
        return valorOriginal;
    }

    public void setValorOriginal(Double valorOriginal) {
        this.valorOriginal = valorOriginal;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
}
