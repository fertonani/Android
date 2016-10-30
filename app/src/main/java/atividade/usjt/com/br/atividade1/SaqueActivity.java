package atividade.usjt.com.br.atividade1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class SaqueActivity extends AppCompatActivity {
    public static final String VALORSAQUE = "atividade.usjt.com.br.atividade1.valorsaque";
    private double valorSaque;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saque);
    }

    public void sacar(View view) {
        EditText evalorSaque = (EditText) findViewById(R.id.valorSaque);
        valorSaque = Double.parseDouble(evalorSaque.getText().toString());
        Intent intent = new Intent(this, ResultadoSaqueActivity.class);
        intent.putExtra(VALORSAQUE, valorSaque + "");
        startActivity(intent);
    }
}
