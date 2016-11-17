package atividade.usjt.com.br.atividade1.model;

import java.io.Serializable;

/**
 * Created by guilhermefertonani on 26/10/16.
 */

public class Historico implements Comparable, Serializable {
    private int numeroDoc;
    private double valor;
    private char tipo;
    private String data;

    public Historico() {

    }

    public Historico(int numeroDoc, double valor, char tipo, String data) {
        this.numeroDoc = numeroDoc;
        this.valor = valor;
        this.tipo = tipo;
        this.data = data;
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
                "numeroDoc=" + numeroDoc +
                ", valor=" + valor +
                ", tipo=" + tipo +
                ", data='" + data + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Historico)) return false;

        Historico historico = (Historico) o;

        if (numeroDoc != historico.numeroDoc) return false;
        if (Double.compare(historico.valor, valor) != 0) return false;
        if (tipo != historico.tipo) return false;
        return data.equals(historico.data);

    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
