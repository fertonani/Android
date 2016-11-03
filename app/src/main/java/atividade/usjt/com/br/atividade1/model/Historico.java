package atividade.usjt.com.br.atividade1.model;

import java.io.Serializable;

/**
 * Created by guilhermefertonani on 26/10/16.
 */

public class Historico implements Serializable {
    private int conta, numeroDoc;
    private double valor;
    private char tipo;
    private String data;

    public Historico(int conta, int numeroDoc, double valor, char tipo, String data) {
        this.conta = conta;
        this.numeroDoc = numeroDoc;
        this.valor = valor;
        this.tipo = tipo;
        this.data = data;
    }

    public int getConta() {
        return conta;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }

    public int getNumeroDoc() {
        return numeroDoc;
    }

    public void setNumeroDoc(int numeroDoc) {
        this.numeroDoc = numeroDoc;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Historico{" +
                "conta=" + conta +
                ", numeroDoc=" + numeroDoc +
                ", valor=" + valor +
                ", tipo=" + tipo +
                ", data='" + data + '\'' +
                '}';
    }
}
