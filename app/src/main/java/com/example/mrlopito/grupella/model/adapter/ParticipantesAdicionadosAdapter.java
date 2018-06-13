package com.example.mrlopito.grupella.model.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.mrlopito.grupella.R;
import com.example.mrlopito.grupella.model.entity.User;

import java.util.ArrayList;

public class ParticipantesAdicionadosAdapter extends ArrayAdapter{
    private ArrayList<User> users;
    private Context context;
    public ParticipantesAdicionadosAdapter(Context c, ArrayList<User> objects) {
        super(c, 0, objects);
        this.users = objects;
        this.context = c;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        if(users!=null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_grupo_participantes,parent, false );
            TextView txtEmail = view.findViewById(R.id.txtPreViewEmail);

            User user2 = users.get(position);
            //stxtEmail.setText(user2.getEmail());
        }
        return view;
    }

}
