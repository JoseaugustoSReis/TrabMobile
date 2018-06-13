package com.example.mrlopito.grupella.model.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.mrlopito.grupella.R;
import com.example.mrlopito.grupella.model.entity.Grupo;
import com.example.mrlopito.grupella.model.entity.User;

import java.util.ArrayList;
import java.util.LinkedList;

public class GruposAdapter extends ArrayAdapter<Grupo> {

    private ArrayList<Grupo> grupos;
    private Context context;

    public GruposAdapter(Context context, ArrayList<Grupo> object) {
        super(context, 0,object);
        this.context = context;
        this.grupos = object;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        if(grupos!=null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_grupo,parent, false );
            TextView txtNome = view.findViewById(R.id.nomeGrupoMain);
            TextView txtEmail = view.findViewById(R.id.txtViewEmailPart);
            Grupo grupo = grupos.get(position);
            txtNome.setText(grupo.getNome());

        }
        return view;
    }
}
