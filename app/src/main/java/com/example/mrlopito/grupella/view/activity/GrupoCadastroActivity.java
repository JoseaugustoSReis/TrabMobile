package com.example.mrlopito.grupella.view.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.mrlopito.grupella.R;
import com.example.mrlopito.grupella.helper.Base64Custom;
import com.example.mrlopito.grupella.helper.Preferences;
import com.example.mrlopito.grupella.model.dao.ConfiguracaoFirebase;
import com.example.mrlopito.grupella.model.entity.Grupo;
import com.example.mrlopito.grupella.model.entity.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;
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

        insert(grupo);

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
            alertToast("Grupo criado com sucesso!");
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
