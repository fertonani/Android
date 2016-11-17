package atividade.usjt.com.br.atividade1.model;

/**
 * Created by guilhermefertonani on 08/11/16.
 */

import android.content.Context;
import android.net.ConnectivityManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class HistoricoRequester {
    OkHttpClient client = new OkHttpClient();


    public ArrayList<Historico> get(String url) throws IOException {
        ArrayList<Historico> lista = new ArrayList<>();
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        String jsonString = response.body().string();
        try {
            JSONArray root = new JSONArray(jsonString);
            JSONObject item = null;
            for (int i = 0; i < root.length(); i++) {
                item = (JSONObject) root.get(i);
                int numeroDoc = item.getInt("numDoc");
                double valor = item.getDouble("valor");
                char tipo = (char) Integer.parseInt(item.getString("tipo").charAt(0) + "" + item.getString("tipo").charAt(1));
                String data = item.getString("data");
                lista.add(new Historico(numeroDoc, valor, tipo, data));
            }
        } catch (JSONException e) {
            throw new IOException(e);
        } finally {
            if (lista.size() == 0) {
                lista.add(new Historico());
            }
        }
        return lista;
    }

    public boolean isConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null &&
                connectivityManager.getActiveNetworkInfo().isConnected();
    }
}
