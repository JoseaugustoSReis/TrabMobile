package com.example.mrlopito.grupella.view.activity;

import android.content.Intent;
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
import com.example.mrlopito.grupella.model.adapter.ParticipantesAdicionadosAdapter;
import com.example.mrlopito.grupella.model.dao.ConfiguracaoFirebase;
import com.example.mrlopito.grupella.model.entity.Grupo;
import com.example.mrlopito.grupella.model.entity.ParticipantesGrupo;
import com.example.mrlopito.grupella.model.entity.User;
import com.google.firebase.database.ChildEventListener;
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
    private ArrayAdapter<User> adapterParticipantes;
    private ArrayList<User> usuarios;
    private DatabaseReference firebase;
    private ValueEventListener valueEventListener;
    private ValueEventListener valueEventListenerParticipantes;
    private ArrayList<User> participantes;
    private EditText edtEmail;
    private FloatingActionButton fab;
    private Grupo grupo;
    private ListView listaParticipantesAdicionados;
    private FloatingActionButton fabIniciarChat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_member);
        usuarios = new ArrayList<User>();
        participantes = new ArrayList<User>();
        listaParticipantes = findViewById(R.id.searchMemberList);
        adpater = new ParticipantesAdapter(this, usuarios);
        adapterParticipantes = new ParticipantesAdicionadosAdapter(this, participantes);
        listaParticipantesAdicionados = findViewById(R.id.listaParticipantesAdicionados);
        listaParticipantesAdicionados.setAdapter(adapterParticipantes);
        listaParticipantes.setAdapter(adpater);
        edtEmail = findViewById(R.id.edtEmailAddMember);
        firebase = ConfiguracaoFirebase.getFirebase().child("usuarios");
        fabIniciarChat = findViewById(R.id.fabIniciarChat);
        Intent it = getIntent();
        grupo = (Grupo)it.getSerializableExtra("grupo");
        //fab.inici
        fab = findViewById(R.id.fabAddByEmail);
        fabIniciarChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddMemberActivity.this, HomeActivity.class);
                intent.putExtra("grupo", grupo);
                startActivity(intent);
            }
        });
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //adicionarUserPorBusca();
                if(adicionaPorBusca())
                    Toast.makeText(AddMemberActivity.this, "AEEEOOO", Toast.LENGTH_SHORT).show();
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
                participantes.clear();
                for(DataSnapshot dados: dataSnapshot.getChildren()){
                    User newUser = dados.getValue(ParticipantesGrupo.class).getUser();
                    participantes.add(newUser);
                }
                adpater.notifyDataSetChanged();
                adapterParticipantes.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };


    }

    private void associarGrupoUsuario(User userByEmail) {
        try{
            ParticipantesGrupo part = new ParticipantesGrupo(grupo, userByEmail);
            firebase = ConfiguracaoFirebase.getFirebase().child("grupos_participantes");
            firebase.child(StringHelper.encodeEmail(userByEmail.getEmail())+"_"+grupo.getNome()).setValue(part);
            Toast.makeText(AddMemberActivity.this, "CARALHO", Toast.LENGTH_SHORT);

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public User retornaUserPorEmail(){
        User userRet = null;
        for(User user: usuarios){
            if(user.getEmail().equals(edtEmail.getText().toString())){
                userRet = user;
                break;
            }

        }
        return userRet;
    }
    public boolean adicionaPorBusca(){
        User user1 = retornaUserPorEmail();
        if(user1!=null){
            try{
                firebase = ConfiguracaoFirebase.getFirebase().child("fiiliacao");
                ParticipantesGrupo fil = new ParticipantesGrupo(grupo, user1);
                firebase.child(StringHelper.encodeEmail(user1.getEmail())).setValue(fil);
                participantes.add(user1);
                return true;
            }
            catch(Exception e){
                e.printStackTrace();
                return false;
            }
        }
        else{
            Toast.makeText(AddMemberActivity.this, "usuario nao localizado", Toast.LENGTH_SHORT).show();
            return false;
        }

    }
    public User retornaUserPorBusca(){
        User user1 = null;
        firebase = ConfiguracaoFirebase.getFirebase();
        Query query = firebase.orderByChild("usuarios").equalTo(StringHelper.encodeEmail(edtEmail.getText().toString()));
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot user: dataSnapshot.getChildren()){
                    try{
                        User user1 = (User) user.getValue();


                    }
                    catch (Exception e){
                        e.printStackTrace();
                        Toast.makeText(AddMemberActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }


                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return user1;
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
