package atividade.usjt.com.br.atividade1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import atividade.usjt.com.br.atividade1.model.Historico;

public class ListaExtratoActivity extends AppCompatActivity {
    public static final String CHAVE = "atividade.usjt.com.br.atividade1.chave";
    Activity atividade;
    ArrayList<Historico> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_extrato);
        atividade = this;
        Intent intent = getIntent();
        String dataDe = intent.getStringExtra(ExtratoActivity.DATADE);
        String dataAte = intent.getStringExtra(ExtratoActivity.DATAATE);

        lista = buscaExtrato(dataDe, dataAte);
        ArrayAdapter<Historico> adapter = new ArrayAdapter<Historico>(this, android.R.layout.simple_list_item_1, lista);

        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(atividade, DetalhesExtratoActivity.class);
                intent.putExtra(CHAVE, lista.get(position).getNumeroDoc() + "");
                startActivity(intent);
            }
        });
    }

    public ArrayList<Historico> buscaExtrato(String dataDe, String dataAte) {
        ArrayList<Historico> lista = geraExtratoLista();
        ArrayList<Historico> subLista;
        if (dataDe == null || dataDe.length() == 0 || dataAte == null || dataAte.length() == 0) {
            return lista;
        } else {
            subLista = new ArrayList<>();
            for (Historico historico : lista) {
                if ((historico.getData().contains(dataDe) && historico.getData().contains(dataAte))) {
                    subLista.add(historico);
                }
            }
        }
        return subLista;
    }

    public ArrayList<Historico> geraExtratoLista() {
        lista = new ArrayList<Historico>();
        lista.add(new Historico(11, 43231, 50.00, 'C', "2013-12-12"));
        lista.add(new Historico(12, 798, 70.00, 'C', "2016-12-12"));
        lista.add(new Historico(13, 412, 90.00, 'C', "2016-12-12"));
        lista.add(new Historico(14, 456, 100.00, 'D', "2016-12-12"));
        lista.add(new Historico(15, 43212, 250.00, 'D', "2016-12-12"));
        lista.add(new Historico(16, 3567, 450.00, 'C', "2013-12-12"));
        lista.add(new Historico(17, 43212, 150.00, 'D', "2013-12-12"));
        lista.add(new Historico(18, 5546, 950.00, 'C', "2013-12-12"));
        lista.add(new Historico(19, 943, 20.00, 'D', "2013-12-12"));
        lista.add(new Historico(20, 43212, 10.00, 'C', "2013-12-12"));
        lista.add(new Historico(21, 934, 1120.00, 'D', "2013-12-12"));
        lista.add(new Historico(22, 23423, 2350.00, 'C', "2013-12-12"));
        lista.add(new Historico(23, 876, 50.50, 'C', "2013-12-12"));
        lista.add(new Historico(24, 2765, 897.00, 'D', "2013-12-12"));
        lista.add(new Historico(25, 3409865, 3350.00, 'C', "2013-12-12"));
        lista.add(new Historico(26, 2342, 60.00, 'D', "2013-12-12"));
        lista.add(new Historico(27, 234324, 55.00, 'C', "2013-12-12"));
        lista.add(new Historico(28, 657, 52.00, 'C', "2013-12-12"));
        lista.add(new Historico(29, 2345, 509.00, 'D', "2013-12-12"));
        lista.add(new Historico(30, 342, 333.00, 'C', "2013-12-12"));
        lista.add(new Historico(31, 34556, 666.00, 'C', "2013-12-12"));
        lista.add(new Historico(32, 9747, 999.00, 'C', "2013-12-12"));
        lista.add(new Historico(33, 875, 1332.00, 'C', "2013-12-12"));
        lista.add(new Historico(34, 883, 1655.00, 'D', "2013-12-12"));
        lista.add(new Historico(35, 3486435, 2000.00, 'D', "2013-12-12"));
        return lista;
    }

    public Historico historico(int numDoc) {
        Historico historico = null;
        ArrayList<Historico> lista = geraExtratoLista();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getNumeroDoc() == numDoc) {
                return lista.get(i);
            }
        }

        return historico;
    }

    public ArrayList<String> historicoString(String dataDe, String dataAte) {
        ArrayList<Historico> listaCheia = geraExtratoLista();
        ArrayList<String> lista = new ArrayList<String>();
        for (Historico historico : listaCheia) {
            if (historico.getData().contains(dataDe) && historico.getData().contains(dataAte)) {
                lista.add(historico.toString());
            }
        }
        return lista;
    }

    public Date randomDate() {
        Calendar data = Calendar.getInstance();
        int dataRandom = new Random().nextInt(50);
        data.add(Calendar.DATE, -dataRandom);
        return data.getTime();
    }
}
