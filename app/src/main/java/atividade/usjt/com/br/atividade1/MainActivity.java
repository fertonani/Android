package atividade.usjt.com.br.atividade1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public final static String MSG_EXTRA= "br.com.usjt.MSG_EXTRA";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void enviarMensagem(View view){

        Intent intent = new Intent(this, MensagemActivity.class);
        EditText editText = (EditText)findViewById(R.id.mensagem);
        String mensagem = editText.getText().toString();
        intent.putExtra(MSG_EXTRA, mensagem);
        startActivity(intent);

    }
}
