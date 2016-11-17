package atividade.usjt.com.br.atividade1.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import atividade.usjt.com.br.atividade1.R;
import atividade.usjt.com.br.atividade1.model.Login;

public class MenuActivity extends AppCompatActivity {
    public static final String LOGIN = "atividade.usjt.com.br.atividade1.controller.login";
    private Login login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Intent intent = getIntent();
        login = new Login(intent.getStringExtra(MainActivity.AGENCIA), intent.getStringExtra(MainActivity.CONTA), intent.getStringExtra(MainActivity.SENHA));
    }

    public void verExtrato(View view) {
        Intent intent = new Intent(this, ExtratoActivity.class);
        intent.putExtra(LOGIN, login);
        startActivity(intent);
    }

    public void verSacar(View view) {
        Intent intent = new Intent(this, SaqueActivity.class);
        intent.putExtra(LOGIN, login);
        startActivity(intent);
    }

    public void sair(View view) {
        login = null;
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}