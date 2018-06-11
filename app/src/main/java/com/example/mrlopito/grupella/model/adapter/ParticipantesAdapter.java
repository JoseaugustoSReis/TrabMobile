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
import com.example.mrlopito.grupella.model.entity.User;

import java.util.ArrayList;

public class ParticipantesAdapter extends ArrayAdapter<User> {
    private ArrayList<User> usuarios;
    private Context context;


    public ParticipantesAdapter(Context c, ArrayList<User> objects) {
        super(c, 0, objects);
        this.context = c;
        this.usuarios = objects;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        if(usuarios!=null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.lista_participantes,parent, false );
            TextView txtNome = view.findViewById(R.id.txtViewNomePart);
            TextView txtEmail = view.findViewById(R.id.txtViewEmailPart);
            User user2 = usuarios.get(position);
            txtNome.setText(user2.getNome());
            txtEmail.setText(user2.getEmail());
        }
        return view;
    }
}
