package com.reges.academia.model;

import java.sql.Timestamp;

public class Pagamento {
    private int idpagamento;
    private int idcli;
    private int idplano;
    private Timestamp datapagamento;

    // Construtores
    public Pagamento() {}

    public Pagamento(int idpagamento, int idcli, int idplano, Timestamp datapagamento) {
        this.idpagamento = idpagamento;
        this.idcli = idcli;
        this.idplano = idplano;
        this.datapagamento = datapagamento;
    }

    // Getters e setters
    public int getIdpagamento() {
        return idpagamento;
    }

    public void setIdpagamento(int idpagamento) {
        this.idpagamento = idpagamento;
    }

    public int getIdcli() {
        return idcli;
    }

    public void setIdcli(int idcli) {
        this.idcli = idcli;
    }

    public int getIdplano() {
        return idplano;
    }

    public void setIdplano(int idplano) {
        this.idplano = idplano;
    }

    public Timestamp getDatapagamento() {
        return datapagamento;
    }

    public void setDatapagamento(Timestamp datapagamento) {
        this.datapagamento = datapagamento;
    }
}
