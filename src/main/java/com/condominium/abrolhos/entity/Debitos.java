package com.condominium.abrolhos.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Debitos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeDivida;
    private Double precoDivida;
    private String dataPagamento;

    Debitos(){}

    public Debitos(Long id, String nomeDivida, Double precoDivida, String dataPagamento) {
        this.id = id;
        this.nomeDivida = nomeDivida;
        this.precoDivida = precoDivida;
        this.dataPagamento = dataPagamento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
