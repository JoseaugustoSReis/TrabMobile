package com.example.mrlopito.grupella.helper;

import com.example.mrlopito.grupella.model.dao.ConfiguracaoFirebase;
import com.google.firebase.database.DatabaseReference;

import java.util.Random;


public class StringHelper {

    public static String encodeEmail(String email){
        return email.replace(".", "-");
    }
    public static long retornaCodChat(){
        long cod = 0;

        cod = new Random().nextLong()*111111;
        return cod;

    }
}
