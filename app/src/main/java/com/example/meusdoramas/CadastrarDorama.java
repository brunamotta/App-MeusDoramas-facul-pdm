package com.example.meusdoramas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class CadastrarDorama extends AppCompatActivity {
    //componentes da tela
    EditText edtTitulo, edtNota, edtAno, edtPais, edtEpisodios;
    Button btnSalvar, btnCancelar;
    private long id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cadastrar_dorama);
        btnSalvar = findViewById(R.id.btnNewSalvar);
        btnCancelar = findViewById(R.id.btnNewCancelar);
        edtTitulo = findViewById(R.id.edtNewTitulo);
        edtNota = findViewById(R.id.edtNewNota);
        edtAno = findViewById(R.id.edtNewAno);
        edtPais = findViewById(R.id.edtNewPais);
        edtEpisodios = findViewById(R.id.edtNewEpisodios);
        id = getIntent().getLongExtra("id", 0);
    }

    //Método para salvar novo dorama no banco de dados
    public void inserirDorama(View v) {
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
        dao.inserir(titulo, nota, ano, pais, numEpisodios);
        dao.close();


    }

    //Método para cancelar operação e voltar a main activity
    public void cancelar(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}