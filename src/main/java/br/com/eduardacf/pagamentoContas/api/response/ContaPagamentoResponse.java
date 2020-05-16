package br.com.eduardacf.pagamentoContas.api.response;

import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;

public class ContaPagamentoResponse {

    @ApiModelProperty(value = "Nome da Conta.")
    private String nome;

    @ApiModelProperty(value = "Valor da Conta.")
    private Double valorOriginal;

    @ApiModelProperty(value = "Data Vencimento da Conta.")
    private LocalDate dataVencimento;

    @ApiModelProperty(value = "Data do pagamento da Conta.")
    private LocalDate dataPagamento;

    @ApiModelProperty(value = "Dias de atraso em relação a data de vencimento original.")
    private Integer diasAtraso;

    @ApiModelProperty(value = "Valor corrigido da conta, caso tenha ocorrido atrasos.")
    private Double valorCorrigido;

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

    public Integer getDiasAtraso() {
        return diasAtraso;
    }

    public void setDiasAtraso(Integer diasAtraso) {
        this.diasAtraso = diasAtraso;
    }

    public Double getValorCorrigido() {
        return valorCorrigido;
    }

    public void setValorCorrigido(Double valorCorrigido) {
        this.valorCorrigido = valorCorrigido;
    }
}
