package com.example.mrlopito.grupella.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mrlopito.grupella.R;

public class CadastroActivity extends AppCompatActivity {

    private TextView txtRetornarLogin;
    private Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        txtRetornarLogin = findViewById(R.id.txtRetornarLogin);
        btnCadastrar = findViewById(R.id.btnCadastrar);

        txtRetornarLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(CadastroActivity.this, LoginActivity.class);
                startActivity(it);
            }
        });


    }
}

