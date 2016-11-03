package atividade.usjt.com.br.atividade1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class ResultadoSaqueActivity extends AppCompatActivity {
    private double valor;
    private Activity atividade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_saque);
        TextView msgSaque = (TextView) findViewById(R.id.msgSaque);
        atividade = this;
        Intent intent = getIntent();

        valor = Double.parseDouble(intent.getStringExtra(SaqueActivity.VALORSAQUE));
        System.out.println(intent.getStringExtra(SaqueActivity.VALORSAQUE));

        String msg = "";
        if (valor <= 800.00) {
            msg = "Saque efetuado com sucesso";
        } else {
            msg = "Saque efetuado sem sucesso. Limite abaixo do solicitado.";
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
        }

        msgSaque.setText(msg);
    }
}
