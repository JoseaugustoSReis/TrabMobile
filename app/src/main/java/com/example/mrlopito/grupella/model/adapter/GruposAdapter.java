package com.example.mrlopito.grupella.model.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.mrlopito.grupella.model.entity.Grupo;

import java.util.LinkedList;

public class GruposAdapter extends ArrayAdapter<Grupo> {

    private LinkedList<Grupo> grupos;
    private Context context;

    public GruposAdapter(Context context, LinkedList<Grupo> object) {
        super(context, 0,object);
        this.context = context;
        this.grupos = object;
    }


    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {
        View view = null;
        if(grupos!=null){
            
        }
        return super.getView(position, convertView, parent);
    }
}
