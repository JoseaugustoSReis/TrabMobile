package com.example.mrlopito.grupella.helper;

public class StringHelper {
    public static String encodeEmail(String email){
        return email.replace(".", "-");
    }
}
