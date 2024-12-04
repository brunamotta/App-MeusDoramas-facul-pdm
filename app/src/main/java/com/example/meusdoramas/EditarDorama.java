package com.example.meusdoramas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class EditarDorama extends AppCompatActivity {
    //componentes da tela
    EditText edtTitulo, edtNota, edtAno, edtPais, edtEpisodios;
    Button btnSalvar, btnExcluir, btnCancelar;
    private long id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_editar_dorama);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnExcluir = findViewById(R.id.btnExcluir);
        btnCancelar = findViewById(R.id.btnCancelar);
        edtTitulo = findViewById(R.id.edtTitulo);
        edtNota = findViewById(R.id.edtNota);
        edtAno = findViewById(R.id.edtAno);
        edtPais = findViewById(R.id.edtPais);
        edtEpisodios = findViewById(R.id.edtEpisodios);
        id = getIntent().getLongExtra("id", 0);

        // Cria um objeto auxiliar para armazenar os dados do registro
        Dorama aux;
        Dorama_DAO dao = new Dorama_DAO(this);
        dao.open();

        aux = dao.buscar(id);
        edtTitulo.setText(aux.getTitulo());
        edtNota.setText(String.format("%.1f", aux.getNota()));
        edtAno.setText(String.valueOf(aux.getAno()));
        edtPais.setText(aux.getPais());
        edtEpisodios.setText(String.valueOf(aux.getNumEpisodios()));
        dao.close();
    }

    // Método para preparar os dados para retornar à atividade principal
    public void alterarDorama(View v) {
        String titulo, pais;
        float nota;
        int ano, numEpisodios;

        titulo = edtTitulo.getText().toString();
        nota = Float.parseFloat(edtNota.getText().toString());
        ano = Integer.parseInt(edtAno.getText().toString());
        pais = edtPais.getText().toString();
        numEpisodios = Integer.parseInt(edtEpisodios.getText().toString());
        Dorama_DAO dao = new Dorama_DAO(this);
        dao.open();
        dao.alterar(id, titulo, nota, ano, pais, numEpisodios);
        dao.close();

        //Quando concluído retorna para main activity
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    //Método para excluir registro do banco de dados e voltar para main activity
    public void excluirDorama(View v) {
        Dorama_DAO dao = new Dorama_DAO(this);
        dao.open();
        dao.excluir(id);
        dao.close();

        //Quando concluído retorna para main activity
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    //Método para cancelar operação e voltar a main activity
    public void cancelar(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}