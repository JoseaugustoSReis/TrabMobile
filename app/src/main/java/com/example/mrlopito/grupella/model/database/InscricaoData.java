package com.example.mrlopito.grupella.model.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class InscricaoData extends SQLiteOpenHelper {
    public static final String NOME_BANCO = "kestudar.db";
    public static final String TABELA_INSCRICAO = "inscricao";
    public static final String ID_INSCRICAO = "id_inscricao";
    public static final String ID_INSCRICAO_USUARIO = "id_usuario";
    public static final String ID_INSCRICAO_GRUPO = "id_grupo";

    private static final int VERSAO = 1;
    public InscricaoData(Context context){
        super(context, NOME_BANCO,null,VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

         String sql = "CREATE TABLE "+TABELA_INSCRICAO+"("
                 + ID_INSCRICAO + " integer primary key autoincrement,"
                + ID_INSCRICAO_GRUPO + " integer primary key,"
                + ID_INSCRICAO_USUARIO + " integer primary key"
                +")";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_INSCRICAO);
        onCreate(db);
    }
}
