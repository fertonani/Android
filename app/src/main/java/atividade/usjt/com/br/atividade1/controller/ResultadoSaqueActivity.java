package atividade.usjt.com.br.atividade1.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import atividade.usjt.com.br.atividade1.R;
import atividade.usjt.com.br.atividade1.model.Login;
import atividade.usjt.com.br.atividade1.model.SaqueRequester;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit.Callback;

public class ResultadoSaqueActivity extends AppCompatActivity {
    public final static String SAQUE = "/saque";
    Callback callBackSaque;
    OkHttpClient client = new OkHttpClient();
    private double valor;
    private Activity atividade;
    private Login login;
    private String endereco;
    private SaqueRequester requester;
    private boolean resposta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_saque);
        TextView msgSaque = (TextView) findViewById(R.id.msgSaque);
        atividade = this;
        Intent intent = getIntent();
        requester = new SaqueRequester();
        valor = Double.parseDouble(intent.getStringExtra(SaqueActivity.VALORSAQUE));
        login = (Login) intent.getSerializableExtra(MenuActivity.LOGIN);
        String msg = "";
        endereco = ExtratoActivity.SERVIDOR + ExtratoActivity.PASTA + SAQUE + "?agencia=" + login.getAgencia() + "&conta=" + login.getConta() + "&valor=" + valor;

        if (requester.isConnected(this)) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        resposta = requester.get(endereco);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        } else {
            Toast toast = Toast.makeText(this, "Rede indisponível", Toast.LENGTH_LONG);
            toast.show();
        }
        if (!resposta) {
            msg = "Saque efetuado com sucesso no valor de " + ExtratoActivity.formataReal(valor);
        } else {
            msg = "Saque efetuado sem sucesso. Limite abaixo do solicitado.";
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
        }


        msgSaque.setText(msg);
    }

    public String run(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public boolean isConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null &&
                connectivityManager.getActiveNetworkInfo().isConnected();
    }

}
