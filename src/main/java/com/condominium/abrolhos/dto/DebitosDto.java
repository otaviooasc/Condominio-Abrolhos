package com.condominium.abrolhos.dto;

import javax.validation.constraints.NotBlank;

public class DebitosDto {

    @NotBlank
    private String nomeDivida;
    private Double precoDivida;
    private String dataPagamento;

    DebitosDto(){}

    public DebitosDto(String nomeDivida, Double precoDivida, String dataPagamento) {
        this.nomeDivida = nomeDivida;
        this.precoDivida = precoDivida;
        this.dataPagamento = dataPagamento;
    }

    public String getNomeDivida() {
        return nomeDivida;
    }

    public void setNomeDivida(String nomeDivida) {
        this.nomeDivida = nomeDivida;
    }

    public Double getPrecoDivida() {
        return precoDivida;
    }

    public void setPrecoDivida(Double precoDivida) {
        this.precoDivida = precoDivida;
    }

    public String getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
}
