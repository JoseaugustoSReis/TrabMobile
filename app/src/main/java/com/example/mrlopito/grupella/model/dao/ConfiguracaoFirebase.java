package com.example.mrlopito.grupella.model.dao;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ConfiguracaoFirebase {
    private static DatabaseReference referenciaFirabase;
    private static FirebaseAuth autenticacao;

    public static DatabaseReference getFirebase(){
        if(referenciaFirabase == null)
            referenciaFirabase = FirebaseDatabase.getInstance().getReference();
        return referenciaFirabase;
    }
    public static FirebaseAuth getFirebaseAuthentication(){
        if(autenticacao == null)
            autenticacao = FirebaseAuth.getInstance();
        return autenticacao;
    }

}
