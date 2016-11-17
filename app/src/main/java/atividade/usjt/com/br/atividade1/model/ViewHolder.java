package atividade.usjt.com.br.atividade1.model;

import android.widget.TextView;

/**
 * Created by guilhermefertonani on 08/11/16.
 */

public class ViewHolder {
    private TextView valor, tipo, data, numDoc, saque;

    public ViewHolder(TextView valor, TextView tipo, TextView data, TextView numDoc) {
        this.valor = valor;
        this.tipo = tipo;
        this.data = data;
        this.numDoc = numDoc;
    }

    public ViewHolder(TextView saque) {
        this.saque = saque;
    }

    public TextView getValor() {
        return valor;
    }

    public void setValor(TextView valor) {
        this.valor = valor;
    }

    public TextView getTipo() {
        return tipo;
    }

    public void setTipo(TextView tipo) {
        this.tipo = tipo;
    }

    public TextView getData() {
        return data;
    }

    public void setData(TextView data) {
        this.data = data;
    }

    public TextView getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(TextView numDoc) {
        this.numDoc = numDoc;
    }

    public TextView getSaque() {
        return saque;
    }

    public void setSaque(TextView saque) {
        this.saque = saque;
    }
}
