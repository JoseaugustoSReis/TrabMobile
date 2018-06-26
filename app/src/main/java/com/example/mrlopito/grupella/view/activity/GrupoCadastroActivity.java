package com.example.mrlopito.grupella.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.mrlopito.grupella.R;
import com.example.mrlopito.grupella.helper.StringHelper;
import com.example.mrlopito.grupella.model.dao.ConfiguracaoFirebase;
import com.example.mrlopito.grupella.model.entity.Chat;
import com.example.mrlopito.grupella.model.entity.Grupo;
import com.google.firebase.database.DatabaseReference;

public class GrupoCadastroActivity extends AppCompatActivity {
    private Button btnCadastrar;

    private EditText edtNome;
    private EditText editDescricao;
    private CheckBox cboxPublico;
    private Grupo grupo;
    private DatabaseReference firebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grupo_cadastro);


        Spinner spinnerImagens = findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.lista_imagens, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerImagens.setAdapter(adapter);


        edtNome = findViewById(R.id.edtNome);
        editDescricao = findViewById(R.id.editDescricao);
        cboxPublico = findViewById(R.id.cboxPublico);

    }


    public void OnClickCadastro(View view){

        grupo = new Grupo(
                0,
                edtNome.getText().toString(),
                editDescricao.getText().toString(),
                cboxPublico.isChecked());

        if(insert(grupo)){
            Intent it = new Intent(GrupoCadastroActivity.this, AddMemberActivity.class);
            it.putExtra("grupo", grupo);

            startActivity(it);
        }


    }

    private void alertToast(String s) {

        Toast.makeText(GrupoCadastroActivity.this, s, Toast.LENGTH_SHORT).show();

    }

    private void cadastrarGrupo(){

        this.grupo.insert();

    }
    private boolean insert(Grupo grupo){
        try{
            firebase = ConfiguracaoFirebase.getFirebase().child("grupos");
            firebase.child(grupo.getNome()).setValue(grupo);
            firebase =  ConfiguracaoFirebase.getFirebase().child("chat");
            Chat chat = new Chat(StringHelper.retornaCodChat(), grupo);
            firebase.child(chat.getCodChat()+"").setValue(chat);

            alertToast("Grupo criado com sucesso!");
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
