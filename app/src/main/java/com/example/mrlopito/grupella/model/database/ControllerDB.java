package com.example.mrlopito.grupella.model.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class ControllerDB {
    private SQLiteDatabase db;
    private DataBaseSQL banco;

    public ControllerDB(Context context){
        banco = new DataBaseSQL(context);
    }

    public String insertInscricaoData(String id_usuario, String id_gurpo){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(InscricaoData.ID_INSCRICAO_GRUPO, id_gurpo);
        valores.put(InscricaoData.ID_INSCRICAO_USUARIO, id_usuario);

        resultado = db.insert(InscricaoData.TABELA_INSCRICAO, null, valores);
        db.close();

        if (resultado ==-1)
            return "Erro ao inserir registro";
        else {
            return "Registro Inserido com sucesso";
        }

    }

    public boolean inscricao_grupo(String id_usuario, String id_grupo){

        String selectQuery = "SELECT id_inscricao FROM inscricao WHERE id_usuario = ? and id_grupo = ?";

        if( db.rawQuery(selectQuery, new String[] { id_usuario, id_grupo }) != null) {
            return false;
        }


        return true;


    }
}
