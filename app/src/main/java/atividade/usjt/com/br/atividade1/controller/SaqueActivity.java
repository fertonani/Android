package atividade.usjt.com.br.atividade1.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import atividade.usjt.com.br.atividade1.R;
import atividade.usjt.com.br.atividade1.model.Login;


public class SaqueActivity extends AppCompatActivity {
    public static final String VALORSAQUE = "atividade.usjt.com.br.atividade1.controller.valorsaque";
    private double valorSaque;
    private Login login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saque);
        Intent intent = getIntent();
        login = (Login) intent.getSerializableExtra(MenuActivity.LOGIN);
    }

    public void sacar(View view) {
        EditText evalorSaque = (EditText) findViewById(R.id.valorSaque);
        String aux = evalorSaque.getText().toString();
        if (validaValor(aux) && Double.parseDouble(aux) > 0) {
            valorSaque = Double.parseDouble(aux);
            Intent intent = new Intent(this, ResultadoSaqueActivity.class);
            intent.putExtra(VALORSAQUE, valorSaque + "");
            intent.putExtra(MenuActivity.LOGIN, login);
            startActivity(intent);
        } else if (validaValor(aux) && Double.parseDouble(aux) <= 0) {
            String msg = "Insira um valor positivo";
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
        } else {
            String msg = "Insira o valor para sacar.";
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
        }
    }

    public boolean validaValor(String valor) {
        try {
            Double.valueOf(valor);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
