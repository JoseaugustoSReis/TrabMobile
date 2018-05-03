package com.example.mrlopito.grupella;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AdapterGrupos extends BaseAdapter {
    private final List<Grupo> grupos;
    private final Activity act;
    private final ListView listView;

    public List<Grupo> toFilter = new ArrayList<Grupo>();

    public AdapterGrupos(List<Grupo> grupos, Activity act, ListView listView1) {
        this.grupos = grupos;
        this.act = act;
        this.listView = listView1;
    }
    @Override
    public int getCount() {
        return grupos.size();
    }

    @Override
    public Object getItem(int position) {
        return grupos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        @SuppressLint("ViewHolder") View view = act.getLayoutInflater().inflate(R.layout.grupos_row, parent, false);
        Grupo grupo;
        if (toFilter.size() == 0) {
            grupo = grupos.get(position);
        } else {
            grupo = toFilter.get(position);
        }

        Context c = parent.getContext();
        TextView nome = (TextView)
                view.findViewById(R.id.estabelecimento_nome);
        TextView descricao = (TextView)
                view.findViewById(R.id.estabelecimento_descricao);
        ImageView imagem = (ImageView)
                view.findViewById(R.id.estabelecimento_imagem);

        //populando as Views
        nome.setText(grupo.getNome());
        descricao.setText(grupo.getDescricao());
        PicassoClient.downloadImage(c, grupo.getPhotoURL(), imagem);

        return view;
    }

}
