package com.example.mrlopito.grupella.view.activity;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mrlopito.grupella.R;
import com.example.mrlopito.grupella.helper.StringHelper;
import com.example.mrlopito.grupella.model.adapter.ParticipantesAdapter;
import com.example.mrlopito.grupella.model.dao.ConfiguracaoFirebase;
import com.example.mrlopito.grupella.model.entity.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AddMemberActivity extends AppCompatActivity {
    private ListView listaParticipantes;
    private ArrayAdapter<User> adpater;
    private ArrayList<User> usuarios;
    private DatabaseReference firebase;
    private ValueEventListener valueEventListener;
    private ArrayList<User> participantes;
    private EditText edtEmail;
    private FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_member);
        usuarios = new ArrayList<User>();
        participantes = new ArrayList<User>();
        listaParticipantes = findViewById(R.id.searchMemberList);
        adpater = new ParticipantesAdapter(this, usuarios);
        listaParticipantes.setAdapter(adpater);
        edtEmail = findViewById(R.id.edtEmailAddMember);
        firebase = ConfiguracaoFirebase.getFirebase().child("usuarios");
        fab = findViewById(R.id.fabAddByEmail);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adicionarUserPorBusca();
                Toast.makeText(AddMemberActivity.this, "Usuario adicionado", Toast.LENGTH_SHORT).show();
            }
        });

        valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                usuarios.clear();
                for(DataSnapshot dados: dataSnapshot.getChildren()){
                    User newUser = dados.getValue(User.class);
                    usuarios.add(newUser);
                }
                adpater.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };


    }
    public void adicionarUserPorBusca(){
        Query query = firebase.orderByChild("usuarios").equalTo(StringHelper.encodeEmail(edtEmail.getText().toString()));
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot user: dataSnapshot.getChildren()){
                    participantes.add((User)user.getValue());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
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
