package com.example.mrlopito.grupella.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.mrlopito.grupella.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void AbrirHome(View view) {
        Intent it = new Intent(LoginActivity.this, HomeActivity.class);
        startActivity(it);
    }
    public void AbrirCadastro(View view){
        Intent it = new Intent(LoginActivity.this, CadastroActivity.class);
        startActivity(it);
    }

}
