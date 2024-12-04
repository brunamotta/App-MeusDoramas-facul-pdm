package com.example.meusdoramas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DoramaSQLiteOpenHelper extends SQLiteOpenHelper {
    // Definição da tabela e dos atributos
    public static final String TABELA = " Dorama ";
    public static final String COLUNA_ID = " id ";
    public static final String COLUNA_TITULO = " titulo ";
    public static final String COLUNA_NOTA = " nota ";
    public static final String COLUNA_ANO = " ano ";
    public static final String COLUNA_PAIS = " pais ";
    public static final String COLUNA_NUM_EPISODIOS = " numEpisodios ";
    //nome do banco de dados
    private static final String DATABASE_NAME = "doramas.db";
    //versão do banco de dados
    private static final int DATABASE_VERSION = 1;
    //String com query para criar tabela
    private static final String CRIAR_BD = " create table " + TABELA + " ("
            + COLUNA_ID + " integer primary key autoincrement , "
            + COLUNA_TITULO + " text not null , "
            + COLUNA_NOTA + " real not null , "
            + COLUNA_ANO + " integer not null , "
            + COLUNA_PAIS + " text not null , "
            + COLUNA_NUM_EPISODIOS + " integer not null ) ;";
    //metodo construtor da classe para criação ou atualização do banco
    public DoramaSQLiteOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    //Criar banco (caso não exista)
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CRIAR_BD);
    }
    //Atualizar banco (caso exista)
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABELA);
        onCreate(db);
    }
}
