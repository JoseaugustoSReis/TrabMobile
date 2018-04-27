package com.example.mrlopito.grupella;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mrlopito.grupella.Grupo;
import com.example.mrlopito.grupella.R;

import java.util.List;

public class AdapterGrupos extends BaseAdapter {
    private final List<Grupo> grupos;
    private final Activity act;

    public AdapterGrupos(List<Grupo> grupos, Activity act) {
        this.grupos = grupos;
        this.act = act;
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
        @SuppressLint("ViewHolder") View view = act.getLayoutInflater()
                .inflate(R.layout.item, parent, false);
        Grupo grupo = grupos.get(position);

        //pegando as referências das Views
        TextView nome = (TextView)
                view.findViewById(R.id.lista_curso_personalizada_nome);
        TextView descricao = (TextView)
                view.findViewById(R.id.lista_curso_personalizada_descricao);
        ImageView imagem = (ImageView)
                view.findViewById(R.id.lista_curso_personalizada_imagem);

        //populando as Views
        nome.setText(grupo.getNome());
        descricao.setText(grupo.getDescricao());
        imagem.setImageResource(R.drawable.ic_login);
        return null;
    }
}
