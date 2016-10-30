package atividade.usjt.com.br.atividade1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import atividade.usjt.com.br.atividade1.model.Historico;


public class DetalhesExtratoActivity extends AppCompatActivity {
    ListaExtratoActivity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_extrato);
        TextView valor = (TextView) findViewById(R.id.valor);
        TextView conta = (TextView) findViewById(R.id.conta);
        TextView tipo = (TextView) findViewById(R.id.tipo);
        TextView data = (TextView) findViewById(R.id.data);
        TextView numDoc = (TextView) findViewById(R.id.numDoc);

        Intent intent = getIntent();
        System.out.println(intent.getStringExtra(ListaExtratoActivity.CHAVE));
        int numdoc = Integer.parseInt(intent.getStringExtra(ListaExtratoActivity.CHAVE));
        activity = new ListaExtratoActivity();
        Historico historico = activity.historico(numdoc);
        valor.setText("Valor: R$" + historico.getValor());
        conta.setText("Conta: " + historico.getConta() + "");
        tipo.setText("Tipo: " + historico.getConta() + "");
        data.setText("Data: " + historico.getData() + "");
        numDoc.setText("Numero: " + historico.getNumeroDoc() + "");
    }
}