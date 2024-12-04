package com.example.meusdoramas;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

// Camada de dados (Persistência)
// Classe de definição para os acessos ao banco de dados
public class Dorama_DAO {

    //Definição de um objeto banco de dados
    private SQLiteDatabase database;

    //Definição das colunas da tabela
    private final String[] columns = {
            DoramaSQLiteOpenHelper.COLUNA_ID,
            DoramaSQLiteOpenHelper.COLUNA_TITULO,
            DoramaSQLiteOpenHelper.COLUNA_NOTA,
            DoramaSQLiteOpenHelper.COLUNA_ANO,
            DoramaSQLiteOpenHelper.COLUNA_PAIS,
            DoramaSQLiteOpenHelper.COLUNA_NUM_EPISODIOS
    };
    private final DoramaSQLiteOpenHelper sqLiteOpenHelper;

    //Método construtor
    public Dorama_DAO(Context context) {
        sqLiteOpenHelper = new DoramaSQLiteOpenHelper(context);
    }

    //Méetodo para abrir recurso de banco de dados
    public void open() throws SQLException {
        database = sqLiteOpenHelper.getWritableDatabase();
    }

    //Método para fechar recurso de banco de dados
    public void close() {
        sqLiteOpenHelper.close();
    }

    //Método para incluir registro
    public void inserir(
            String titulo,
            float nota,
            int ano,
            String pais,
            int numEpisodios
    ) {
        //prepara os valores das colunas da tabela para inserção
        ContentValues values = new ContentValues();
        values.put(DoramaSQLiteOpenHelper.COLUNA_TITULO, titulo);
        values.put(DoramaSQLiteOpenHelper.COLUNA_NOTA, String.valueOf(nota));
        values.put(DoramaSQLiteOpenHelper.COLUNA_ANO, String.valueOf(ano));
        values.put(DoramaSQLiteOpenHelper.COLUNA_PAIS, pais);
        values.put(DoramaSQLiteOpenHelper.COLUNA_NUM_EPISODIOS, String.valueOf(numEpisodios));

        //Efetua a inclusão com retorno do id do registro
        long insertId = database.insert(
                DoramaSQLiteOpenHelper.TABELA,
                null,
                values
        );
    }

    //Método para atualizar registro
    public void alterar(
            long id,
            String titulo,
            float nota,
            int ano,
            String pais,
            int numEpisodios
    ) {
        ContentValues values = new ContentValues();
        values.put(DoramaSQLiteOpenHelper.COLUNA_TITULO, titulo);
        values.put(DoramaSQLiteOpenHelper.COLUNA_NOTA, String.valueOf(nota));
        values.put(DoramaSQLiteOpenHelper.COLUNA_ANO, String.valueOf(ano));
        values.put(DoramaSQLiteOpenHelper.COLUNA_PAIS, pais);
        values.put(DoramaSQLiteOpenHelper.COLUNA_NUM_EPISODIOS, String.valueOf(numEpisodios));
        database.update(
                DoramaSQLiteOpenHelper.TABELA,
                values,
                DoramaSQLiteOpenHelper.COLUNA_ID + "=" + id,
                null
        );
    }

    //Método para excluir registro
    public void excluir(long id) {
        database.delete(
                DoramaSQLiteOpenHelper.TABELA,
                DoramaSQLiteOpenHelper.COLUNA_ID + "=" + id,
                null
        );
    }

    //Método para buscar registro pelo id
    public Dorama buscar(long id) {
        Cursor cursor = database.query(
                DoramaSQLiteOpenHelper.TABELA,
                columns,
                DoramaSQLiteOpenHelper.COLUNA_ID + "=" + id,
                null,
                null,
                null,
                null
        );
        cursor.moveToFirst();
        //Cria um objeto Dorama auxiliar para retornar o objeto
        Dorama dorama = new Dorama();
        dorama.setId(cursor.getLong(0));
        dorama.setTitulo(cursor.getString(1));
        dorama.setNota(cursor.getFloat(2));
        dorama.setAno(cursor.getInt(3));
        dorama.setPais(cursor.getString(4));
        dorama.setNumEpisodios(cursor.getInt(5));

        cursor.close();
        //Retorna o objeto auziliar do tipo Dorama
        return dorama;
    }

    //metodo para montar lista de doramas
    public List<Dorama> getAll() {
        List<Dorama> doramas = new ArrayList<>();

        Cursor cursor = database.query(
                DoramaSQLiteOpenHelper.TABELA,
                columns,
                null,
                null,
                null,
                null,
                null
        );

        cursor.moveToFirst();

        while(!cursor.isAfterLast()) {
            Dorama dorama = new Dorama();
            dorama.setId(cursor.getLong(0));
            dorama.setTitulo(cursor.getString(1));
            dorama.setNota(cursor.getFloat(2));
            dorama.setAno(cursor.getInt(3));
            dorama.setPais(cursor.getString(4));
            dorama.setNumEpisodios(cursor.getInt(5));
            doramas.add(dorama);
            cursor.moveToNext();
        }

        cursor.close();
        return doramas;
    }
}
