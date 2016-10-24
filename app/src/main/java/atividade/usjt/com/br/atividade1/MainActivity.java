package atividade.usjt.com.br.atividade1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public final static String AGENCIA = "br.com.usjt.AGENCIA";
    public final static String CONTA = "br.com.usjt.CONTA";
    public final static String SENHA = "br.com.usjt.SENHA";
    private String agencia, conta, senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void logar(View view) {
        Intent intent = new Intent(this, MenuActivity.class);
        EditText eagencia = (EditText)findViewById(R.id.agencia);
        EditText econta = (EditText)findViewById(R.id.conta);
        EditText esenha = (EditText)findViewById(R.id.senha);
        agencia = eagencia.getText().toString();
        conta = econta.getText().toString();
        senha = esenha.getText().toString();
        if (!agencia.equals("") | !conta.equals("") | !senha.equals("")) {
            String msg = "Acesso permitido";
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
            intent.putExtra(AGENCIA, agencia);
            intent.putExtra(CONTA, conta);
            intent.putExtra(SENHA, senha);
            startActivity(intent);
        } else {
            String msg = "Agência e/ou Conta e/ou senha incorreto";
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
        }
    }
}
