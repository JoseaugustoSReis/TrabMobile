package com.example.mrlopito.grupella.view.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mrlopito.grupella.R;
import com.example.mrlopito.grupella.helper.Base64Custom;
import com.example.mrlopito.grupella.helper.Preferences;
import com.example.mrlopito.grupella.model.dao.ConfiguracaoFirebase;
import com.example.mrlopito.grupella.model.entity.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;

public class CadastroActivity extends AppCompatActivity {

    private TextView txtRetornarLogin;

    private Button btnCadastrar;

    private EditText edtEmail;
    private EditText edtSenha;
    private EditText edtSenhaConf;
    private EditText edtNome;
    private User user;
    private FirebaseAuth authentication;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        txtRetornarLogin = findViewById(R.id.txtRetornarLogin);
        btnCadastrar = findViewById(R.id.btnCadastrar);
        edtEmail = findViewById(R.id.editEmail);
        edtSenha = findViewById(R.id.editSenha1);
        edtSenhaConf = findViewById(R.id.edtSenha2);
        edtNome = findViewById(R.id.edtNome);

        txtRetornarLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                abrirLogin();

            }
        });


    }
    public void OnClickCadastro(View view){
        if(edtSenha.getText().toString().equals(edtSenhaConf.getText().toString())){
            user = new User();
            user.setNome(edtNome.getText().toString());
            user.setEmail(edtEmail.getText().toString());
            user.setSenha(edtSenha.getText().toString());
            cadastrarUsuario();
        }
        else
            alertToast("As senhas devem ser idênticas!");
    }
    private void alertToast(String s) {

        Toast.makeText(CadastroActivity.this, s, Toast.LENGTH_SHORT).show();
    }
    private void cadastrarUsuario(){
        authentication = ConfiguracaoFirebase.getFirebaseAuthentication();
        authentication.createUserWithEmailAndPassword(
                user.getEmail(),
                user.getSenha()
        ).addOnCompleteListener(CadastroActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    alertToast("Seu cadastro foi realizado com sucesso!");
                    String identificadorUsuario = Base64Custom.codificarBase64(user.getEmail());
                    FirebaseUser firebaseUser = task.getResult().getUser();
                    user.setCod(identificadorUsuario);
                    user.insert();
                    Preferences preferences = new Preferences(CadastroActivity.this);
                    preferences.salvarUsuario(identificadorUsuario, user.getNome());
                    alertToast("Usuario cadastrado!");
                    abrirLogin();
                }
                else{
                    String exception = "";
                    try{
                        throw task.getException();
                    }
                    catch (FirebaseAuthWeakPasswordException e){
                        exception = "Senha broxante, digite uma senha melhor, no mínimo 8 caracteres, incluindo letras e números!";
                    }
                    catch (FirebaseAuthInvalidCredentialsException e){
                        exception = "E-mail inválido!";

                    }
                    catch (FirebaseAuthUserCollisionException e){
                        exception = "E-mail já cadastrado!";
                    }
                    catch (Exception e){
                        exception = "Erro ao efutuar o cadastro, tente novamente mais tarde!";
                    }
                    alertToast(exception);

                }
            }
        });
    }
    public void abrirLogin(){
        Intent it = new Intent(CadastroActivity.this, LoginActivity.class);
        startActivity(it);
    }

}

