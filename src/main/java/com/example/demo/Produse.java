package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Produse {
    String codProdus;
    String codPFurnizor;
    BigDecimal grossPalet;
    BigDecimal netPalet;

    BigDecimal pcsPallet;
    BigDecimal grosPcs;
    static Map<String, Produse> mapProduse = new HashMap<String, Produse>();
    public void setCodProdus(String codProdus) {
        this.codProdus = codProdus;
    }

    public Produse(String codProdus, String codPFurnizor, BigDecimal grossPalet, BigDecimal netPalet, BigDecimal pcsPallet, BigDecimal grosPcs) {
        this.codProdus = codProdus;
        this.codPFurnizor = codPFurnizor;
        this.grossPalet = grossPalet;
        this.netPalet = netPalet;
        this.pcsPallet = pcsPallet;
        this.grosPcs = grosPcs;
    }

    public BigDecimal getPcsPallet() {
        return pcsPallet;
    }

    public void setPcsPallet(BigDecimal pcsPallet) {
        this.pcsPallet = pcsPallet;
    }

    public void setCodPFurnizor(String codPFurnizor) {
        this.codPFurnizor = codPFurnizor;
    }

    public void setGrossPalet(BigDecimal grossPalet) {
        this.grossPalet = grossPalet;
    }

    public void setNetPalet(BigDecimal netPalet) {
        this.netPalet = netPalet;
    }

    public void setGrosPcs(BigDecimal grosPcs) {
        this.grosPcs = grosPcs;
    }

    public String getCodProdus() {
        return codProdus;
    }

    public String getCodPFurnizor() {
        return codPFurnizor;
    }

    public BigDecimal getGrossPalet() {
        return grossPalet;
    }

    public BigDecimal getNetPalet() {
        return netPalet;
    }

    public BigDecimal getGrosPcs() {
        return grosPcs;
    }
}
