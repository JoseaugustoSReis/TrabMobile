package com.example.mrlopito.grupella.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.mrlopito.grupella.R;
import com.example.mrlopito.grupella.model.entity.User;

public class GrupoCadastroActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grupo_cadastro);


        Spinner spinnerImagens = findViewById(R.id.spinner);

        //String[] lsPeso = getResources().getStringArray(R.array.lista_peso);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.lista_imagens, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerImagens.setAdapter(adapter);
        //spinnerPeso.setAdapter(new ArrayAdapter<String>(GrupoCadastroActivity.this, R.layout.activity_grupo_cadastro, lsPeso));


    }


    public void OnClickCadastro(View view){
    }
}
