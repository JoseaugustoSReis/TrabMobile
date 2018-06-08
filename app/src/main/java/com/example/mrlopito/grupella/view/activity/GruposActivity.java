package com.example.mrlopito.grupella.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.mrlopito.grupella.R;
import com.example.mrlopito.grupella.model.service.DataTest;
import com.example.mrlopito.grupella.view.adapter.GruposAdapter;
import com.example.mrlopito.grupella.model.entity.Grupo;

import java.util.List;

public class GruposActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grupo);



        List<Grupo> grupos = DataTest.todosOsGrupos();
        final ListView listView = (ListView) findViewById(R.id.listview);
        GruposAdapter adapter = new GruposAdapter(grupos, this, listView);

        listView.setAdapter(adapter);

        // seta o listener para pegar o click do usuário no item do seu list View
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // pega o o item selecionado com os dados do grupo
                Grupo grupo = (Grupo) listView.getItemAtPosition(position);

                // cria a intent
                Intent intent = new Intent(GruposActivity.this, GrupoDetalheActivity.class);

                // seta o parametro do grupo a exibir os dados
                intent.putExtra( "grupo" ,  grupo);

                //  chama a Activity que mostra os detalhes
                startActivity(intent);

            }

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate( R.menu.menu_incial, menu );
        return super.onCreateOptionsMenu( menu );

    }


}
