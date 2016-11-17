package atividade.usjt.com.br.atividade1.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Locale;

import atividade.usjt.com.br.atividade1.R;
import atividade.usjt.com.br.atividade1.model.Historico;
import atividade.usjt.com.br.atividade1.model.HistoricoRequester;
import atividade.usjt.com.br.atividade1.model.Login;

public class ExtratoActivity extends AppCompatActivity {

    public final static String LISTA = "atividade.usjt.com.br.atividade1.controller.lista";
    public final static String SERVIDOR = "http://10.129.82.159:8080";
    public final static String PASTA = "/ProjetoWeb";
    public final static String RECURSO = "/extrato";
    private EditText dataDe, dataAte;
    private ArrayList<Historico> lista;
    private Intent intent;
    private String aux;
    private HistoricoRequester requester;
    private Login login;

    public static String formataReal(double valor) {
        DecimalFormat fmt = new DecimalFormat("##,###,###,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR")));
        return "R$" + fmt.format(valor);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extrato);
        Intent intent = getIntent();
        login = (Login) intent.getSerializableExtra(MenuActivity.LOGIN);
        dataDe = (EditText) findViewById(R.id.dataDe);
        dataAte = (EditText) findViewById(R.id.dataAte);
    }

    public void buscarExtrato(View view) {
        intent = new Intent(this, ListaExtratoActivity.class);
        requester = new HistoricoRequester();
        final String data1 = dataDe.getText().toString();
        final String data2 = dataAte.getText().toString();
        aux = "";
        if (data1 == null || data2 == null || data1.length() == 0 || data2.length() == 0)
            aux = SERVIDOR + PASTA + RECURSO + "?agencia=" + login.getAgencia() + "&conta=" + login.getConta();
        else
            aux = SERVIDOR + PASTA + RECURSO + "?agencia=" + login.getAgencia() + "&conta=" + login.getConta() + "&de=" + data1 + "&ate=" + data2;
        System.out.println(aux);
        if (requester.isConnected(this)) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        lista = requester.get(aux);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                intent.putExtra(LISTA, lista);
                                startActivity(intent);
                            }
                        });
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        } else {
            Toast toast = Toast.makeText(this, "Rede indisponível", Toast.LENGTH_LONG);
            toast.show();
        }
    }
}