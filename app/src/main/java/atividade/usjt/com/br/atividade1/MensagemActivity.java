package atividade.usjt.com.br.atividade1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MensagemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        String mensagem = intent.getStringExtra(MainActivity.MSG_EXTRA);

        TextView tv = new TextView(this);
        tv.setTextSize(42);
        tv.setText(mensagem);
        setContentView(tv);
    }
}
