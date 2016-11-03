package atividade.usjt.com.br.atividade1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class ExtratoActivity extends AppCompatActivity {

    public final static String DATADE = "atividade.usjt.com.br.atividade1.datade";
    public final static String DATAATE = "atividade.usjt.com.br.atividade1.dataate";
    private EditText dataDe, dataAte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extrato);
        dataDe = (EditText) findViewById(R.id.dataDe);
        dataAte = (EditText) findViewById(R.id.dataAte);
    }

    public void buscarExtrato(View view) {
        Intent intent = new Intent(this, ListaExtratoActivity.class);
        String data1 = dataDe.getText().toString();
        String data2 = dataAte.getText().toString();
        intent.putExtra(data1, DATADE);
        intent.putExtra(data2, DATAATE);
        startActivity(intent);
    }
}