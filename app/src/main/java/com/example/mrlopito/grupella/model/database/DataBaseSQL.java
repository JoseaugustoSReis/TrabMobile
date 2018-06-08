package com.example.mrlopito.grupella.model.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseSQL extends SQLiteOpenHelper {
    private static final String NOME_BANCO = "kestudar.db";
    private static final String TABELA = "usuarios";
    private static final String ID = "id";
    private static final String NOME = "nome";

    private static final String TABELA_GRUPO = "grupos";
    private static final String ID_GRUPO = "id_moderador";
    private static final String NOME_GRUPO = "nome";
    private static final String DESCRICAO_GRUPO = "decricao";
    private static final String PHOTO_GRUPO = "photoURL";
    private static final String PUBLICO_GRUPO = "publico";

    private static final String TABELA_INSCRICAO = "grupos";
    private static final String ID_INSCRICAO_USUARIO = "id_usuario";
    private static final String ID_INSCRICAO_GRUPO = "id_grupo";
    private static final int VERSAO = 1;

    public DataBaseSQL(Context context){
        super(context, NOME_BANCO,null,VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE "+TABELA+"("
                + ID + " integer primary key autoincrement,"
                + NOME + " text"
                +")";

        db.execSQL(sql);

        sql = "CREATE TABLE "+TABELA_GRUPO+"("
                + ID_GRUPO + " integer primary key autoincrement,"
                + NOME_GRUPO + " text,"
                + DESCRICAO_GRUPO + " text,"
                + PHOTO_GRUPO + " text,"
                + PUBLICO_GRUPO + " boolean"
                +")";

        db.execSQL(sql);

        sql = "CREATE TABLE "+TABELA_INSCRICAO+"("
                + ID_INSCRICAO_GRUPO + " integer primary key,"
                + ID_INSCRICAO_USUARIO + " integer primary key"
                +")";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA);
        onCreate(db);
    }
}