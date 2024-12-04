package com.example.meusdoramas;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.content.Intent;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity  implements AdapterView.OnItemClickListener {
    //Componente lista da view
    ListView lista;
    Intent intent;
    // Objeto de acesso ao banco
    private Dorama_DAO dao;
    //vetor com dados dos doramas para alimentar a lista
    private String[] doramas;
    //vetor com id dos doramas para identificar quando for selecionado da lista
    private long[] idDoramas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        lista = findViewById(R.id.listaDoramas);
        dao = new Dorama_DAO(this);
        dao.open();
        //determina a ação de clique nos itens da lista
        lista.setOnItemClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //prepara a lista buscando no banco os registros
        List<Dorama> listaDoramas = dao.getAll();
        doramas = new String[listaDoramas.size()];
        idDoramas = new long[listaDoramas.size()];
        int i = 0;
        Iterator<Dorama> iterator = listaDoramas.iterator();

        while (iterator.hasNext()) {
            Dorama aux = new Dorama();
            aux = (Dorama) iterator.next();
            doramas[i] = aux.textoLista();
            idDoramas[i] = aux.getId();
            i++;
        }

    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, doramas);
    lista.setAdapter(adapter);
    }

    // Fecha o recurso de acesso ao banco sempre que a atividade passar por uma pausa
    @Override
    protected void onPause() {
        dao.close();
        super.onPause();
    }

    //Método para seleção de um item da lista para editar ou excluir e chamada da atividade secundária
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        id = idDoramas[position];
        intent = new Intent(getApplicationContext(), EditarDorama.class);
        intent.putExtra("id",id);
        startActivity(intent);
    }

    //Método para chamada da atividade secundária para adicionar item novo na lista
    public void incluirDorama(View v) {
        intent = new Intent(getApplicationContext(), CadastrarDorama.class);
        intent.putExtra("id",0);
        startActivity(intent);
    }
}