package atividade.usjt.com.br.atividade1.model;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.Hashtable;
import java.util.Locale;

import atividade.usjt.com.br.atividade1.R;
import atividade.usjt.com.br.atividade1.controller.ExtratoActivity;

/**
 * Created by guilhermefertonani on 06/11/16.
 */

public class HistoricoAdapter extends BaseAdapter {
    Activity context;
    Historico[] historicos;
    Object[] sectionHeaders;
    Hashtable<Integer, Integer> positionForSectionMap;
    Hashtable<Integer, Integer> sectionForPositionMap;

    public HistoricoAdapter(Activity context, Historico[] historicos) {
        this.context = context;
        this.historicos = historicos;
    }

    @Override
    public int getCount() {
        return historicos.length;
    }

    @Override
    public Object getItem(int position) {
        if (position >= 0 && position < historicos.length)
            return historicos[position];
        else
            return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //o list view recicla os layouts para melhor performance
        //o layout reciclado vem no parametro convert view
        View view = convertView;
        //se nao recebeu um layout para reutilizar deve inflar um
        if (view == null) {
            //um inflater transforma um layout em uma view
            LayoutInflater inflater = (LayoutInflater) context.getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.linha_historico, parent, false);


            TextView numDoc = (TextView) view.findViewById(R.id.numDoc);
            TextView valor = (TextView) view.findViewById(R.id.valor);
            TextView tipo = (TextView) view.findViewById(R.id.tipo);
            TextView data = (TextView) view.findViewById(R.id.data);
            //faz cache dos widgets instanciados na tag da view para reusar quando houver reciclagem
            view.setTag(new ViewHolder(valor, tipo, data, numDoc));
        }
        //usa os widgets cacheados na view reciclada
        ViewHolder holder = (ViewHolder) view.getTag();
        //carrega os novos valores
        //Drawable drawable = Util.getDrawable(context, clientes.get(position).getFoto());
        //Picasso.with(context).load(APIClient.SERVIDOR+APIClient.PASTA+clientes.get(position).getFoto()+".jpg").into(holder.getFotoCliente());
        //holder.getFotoCliente().setImageDrawable(drawable);
        Locale locale = new Locale("pt", "BR");
        holder.getValor().setText(ExtratoActivity.formataReal(historicos[position].getValor()));
        holder.getTipo().setText(historicos[position].getTipo() + "");
        holder.getData().setText(historicos[position].getData() + "");
        holder.getNumDoc().setText(historicos[position].getNumeroDoc() + "");

        return view;
    }
}
