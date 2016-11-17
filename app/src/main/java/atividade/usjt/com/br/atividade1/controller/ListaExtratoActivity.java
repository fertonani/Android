package atividade.usjt.com.br.atividade1.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import atividade.usjt.com.br.atividade1.R;
import atividade.usjt.com.br.atividade1.model.Historico;
import atividade.usjt.com.br.atividade1.model.HistoricoAdapter;

public class ListaExtratoActivity extends AppCompatActivity {
    public static final String DATA = "atividade.usjt.com.br.atividade1.controller.data";
    public static final String NUMDOC = "atividade.usjt.com.br.atividade1.controller.numdoc";
    public static final String TIPO = "atividade.usjt.com.br.atividade1.controller.tipo";
    public static final String VALOR = "atividade.usjt.com.br.atividade1.controller.valor";

    Activity atividade;
    List<Historico> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_extrato);
        atividade = this;
        Intent intent = getIntent();

        lista = (ArrayList<Historico>) intent.getSerializableExtra(ExtratoActivity.LISTA);

        BaseAdapter adapter = new HistoricoAdapter(this, lista.toArray(new Historico[0]));
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(atividade, DetalhesExtratoActivity.class);
                intent.putExtra(DATA, lista.get(position).getData());
                intent.putExtra(NUMDOC, lista.get(position).getNumeroDoc() + "");
                intent.putExtra(TIPO, lista.get(position).getTipo() + "");
                intent.putExtra(VALOR, lista.get(position).getValor() + "");
                startActivity(intent);
            }
        });
    }
}