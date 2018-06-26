package com.example.mrlopito.grupella.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mrlopito.grupella.R;
import com.example.mrlopito.grupella.model.dao.ConfiguracaoFirebase;
import com.example.mrlopito.grupella.model.entity.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    private EditText edtEmail;
    private EditText edtSenha;
    private Button btnLogin;
    private FirebaseAuth authentication;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();


        edtEmail = findViewById(R.id.edtEmail);
        edtSenha = findViewById(R.id.edtSenha);
        btnLogin = findViewById(R.id.btnLogin);


    }

    public void AbrirHome(View view) {
        if(!edtEmail.getText().toString().equals("") && !edtSenha.getText().toString().equals("")){
            user = new User();
            user.setEmail(edtEmail.getText().toString());
            user.setSenha(edtSenha.getText().toString());
            validarLogin();
        }
        else{
            alertToast("Insira seu e-mail e senha!");
        }

    }

    private void alertToast(String s) {

        Toast.makeText(LoginActivity.this, s, Toast.LENGTH_SHORT).show();
    }

    public void AbrirCadastro(View view){
        Intent it = new Intent(LoginActivity.this, CadastroActivity.class);
        it.putExtra("user", this.user);
        startActivity(it);
    }
    private void validarLogin(){
        authentication = ConfiguracaoFirebase.getFirebaseAuthentication();
        authentication.signInWithEmailAndPassword(user.getEmail(), user.getSenha()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    abrirHome();
                    alertToast("Login Efetuado com Sucesso");
                }
                else
                    alertToast("Email e/ou senha inválidos");
            }
        });
    }

    private void abrirHome() {
        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);

        startActivity(intent);

    }


}
