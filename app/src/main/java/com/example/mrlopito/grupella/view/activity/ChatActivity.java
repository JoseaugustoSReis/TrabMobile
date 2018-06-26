package com.example.mrlopito.grupella.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mrlopito.grupella.R;
import com.example.mrlopito.grupella.helper.StringHelper;
import com.example.mrlopito.grupella.model.adapter.MessageAdapter;
import com.example.mrlopito.grupella.model.dao.ConfiguracaoFirebase;
import com.example.mrlopito.grupella.model.entity.Chat;
import com.example.mrlopito.grupella.model.entity.Grupo;
import com.example.mrlopito.grupella.model.entity.Message;
import com.example.mrlopito.grupella.model.entity.TexteMessage;
import com.example.mrlopito.grupella.model.entity.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.EventListener;

public class ChatActivity extends AppCompatActivity {

    private Chat chat;

    private DatabaseReference firebase;
    private Grupo grupo;
    private ArrayList<TexteMessage> mensagens;
    private EditText edtmsg;
    private ListView listaMensagem;
    private User user;
    private ValueEventListener valueEventListener;
    private MessageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        Intent it = getIntent();
        grupo = (Grupo)it.getSerializableExtra("grupo");
        firebase = ConfiguracaoFirebase.getFirebase().child("chat").child(grupo.getCode()+"").child("mensagens");
        edtmsg = findViewById(R.id.edtNewMessage);
        user = (User)it.getSerializableExtra("user");
        listaMensagem = findViewById(R.id.listaMensagens);
        mensagens = new ArrayList<TexteMessage>();
        adapter = new MessageAdapter(ChatActivity.this, mensagens);
        listaMensagem.setAdapter(adapter);
        valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mensagens.clear();
                for (DataSnapshot data : dataSnapshot.getChildren()){
                    TexteMessage msg = data.child("chat").child(grupo.getCode()+"").child("mensagens").getValue(TexteMessage.class);
                    mensagens.add(msg);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };



    }
    public void insertMessage(View view){
        firebase = ConfiguracaoFirebase.getFirebase().child("chat").child(grupo.getCode()+"").child("mensagens");
        String txt = edtmsg.getText().toString();
        TexteMessage msg = new TexteMessage(StringHelper.retornaCodChat(), user, txt);
        firebase.child(msg.getCod()+"").setValue(msg);
        Toast.makeText(ChatActivity.this, "Enviado", Toast.LENGTH_LONG).show();
        edtmsg.setText("");
    }
    @Override
    protected void onStart() {
        super.onStart();
        firebase.addValueEventListener(valueEventListener);

    }

    @Override
    protected void onStop() {
        super.onStop();
        firebase.removeEventListener(valueEventListener);
    }


}
