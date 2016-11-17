package atividade.usjt.com.br.atividade1.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import atividade.usjt.com.br.atividade1.R;


public class DetalhesExtratoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        setContentView(R.layout.activity_detalhes_extrato);
        TextView valor = (TextView) findViewById(R.id.valor);
        TextView tipo = (TextView) findViewById(R.id.tipo);
        TextView data = (TextView) findViewById(R.id.data);
        TextView numDoc = (TextView) findViewById(R.id.numDoc);

        valor.setText("Valor: " + ExtratoActivity.formataReal(Double.parseDouble(intent.getStringExtra(ListaExtratoActivity.VALOR))));
        tipo.setText("Tipo: " + intent.getStringExtra(ListaExtratoActivity.TIPO));
        data.setText("Data: " + intent.getStringExtra(ListaExtratoActivity.DATA));
        numDoc.setText("Comprovante de transação: " + intent.getStringExtra(ListaExtratoActivity.NUMDOC));
    }
}