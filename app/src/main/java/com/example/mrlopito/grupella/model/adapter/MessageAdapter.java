package com.example.mrlopito.grupella.model.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.mrlopito.grupella.R;
import com.example.mrlopito.grupella.model.entity.Message;
import com.example.mrlopito.grupella.model.entity.TexteMessage;

import java.util.ArrayList;

public class MessageAdapter extends ArrayAdapter<TexteMessage> {

    private ArrayList<TexteMessage> mensagens;
    private Context context;

    public MessageAdapter(Context context,  ArrayList<TexteMessage> object){
        super(context,0,object);
        this.context = context;
        this.mensagens = object;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        if(mensagens !=null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_grupo,parent, false );
            TextView txtNome = view.findViewById(R.id.item_usuario);

            TextView txtMensagem = view.findViewById(R.id.item_mensagem);
            TexteMessage mensagem = mensagens.get(position);
            txtNome.setText(mensagem.getUser().getNome());

        }
        return view;
    }

}
