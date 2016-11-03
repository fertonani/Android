package atividade.usjt.com.br.atividade1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public final static String AGENCIA = "atividade.usjt.com.br.atividade1.agencia";
    public final static String CONTA = "atividade.usjt.com.br.atividade1.conta";
    public final static String SENHA = "atividade.usjt.com.br.atividade1.senha";

    private String agencia, conta, senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void logar(View view) {
        Intent intent = new Intent(this, MenuActivity.class);
        EditText eagencia = (EditText) findViewById(R.id.agencia);
        EditText econta = (EditText) findViewById(R.id.conta);
        EditText esenha = (EditText) findViewById(R.id.senha);
        agencia = eagencia.getText().toString();
        conta = econta.getText().toString();
        senha = esenha.getText().toString();
        if ((agencia.length() == 0) || (conta.length() == 0 || (senha.length() == 0))) {
            String msg = "Agência e/ou Conta e/ou senha incorreto";
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
        } else {
            String msg = "Acesso permitido";
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
            intent.putExtra(AGENCIA, agencia);
            intent.putExtra(CONTA, conta);
            intent.putExtra(SENHA, senha);
            startActivity(intent);
        }
    }
}
