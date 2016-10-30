package atividade.usjt.com.br.atividade1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void verExtrato(View view) {
        Intent intent = new Intent(this, ExtratoActivity.class);
        startActivity(intent);
    }

    public void verSacar(View view) {
        Intent intent = new Intent(this, SaqueActivity.class);
        startActivity(intent);
    }
}