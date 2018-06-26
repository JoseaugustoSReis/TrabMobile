package com.example.mrlopito.grupella.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mrlopito.grupella.R;
import com.example.mrlopito.grupella.model.dao.ConfiguracaoFirebase;
import com.example.mrlopito.grupella.model.entity.Grupo;
import com.example.mrlopito.grupella.model.entity.Message;
import com.google.firebase.database.DatabaseReference;

public class ChatActivity extends AppCompatActivity {

    private DatabaseReference firebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);


    }


}
